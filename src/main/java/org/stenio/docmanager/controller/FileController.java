package org.stenio.docmanager.controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.stenio.docmanager.dto.FileItemDTO;
import org.stenio.docmanager.model.FileItem;
import org.stenio.docmanager.service.FileService;
import org.stenio.docmanager.util.ConfigUtil;
import org.stenio.docmanager.util.FileUtil;
import org.stenio.docmanager.util.UserContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(params = "method=createFolder")
    public FileItem createFolder(String path) {
        return fileService.createFolder(path, UserContextHolder.getLoginUserId());
    }

    @RequestMapping(params = "method=upload")
    public FileItem upload(String path, @RequestParam("file") MultipartFile file) throws IOException {
        String rootPath = ConfigUtil.getString("file_root");
        String absoluteDir = FileUtil.fixPath(rootPath + "/" + path);
        String bakRootPath = ConfigUtil.getString("bak_file_root");
        String bakAbsoluteDir = FileUtil.fixPath(bakRootPath + "/" + path);
        File dir = new File(absoluteDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!dir.isDirectory()) {
            // TODO 返回错误
        }
        String fileName = file.getOriginalFilename();
        File toFile = new File(FileUtil.fixPath(absoluteDir + "/" + fileName));
        file.transferTo(toFile);

        FileUtil.copyFile(toFile, new File(bakAbsoluteDir));

        FileItem fileItem = new FileItem();
        fileItem.setSize(file.getSize());
        fileItem.setDir(path);
        fileItem.setName(fileName);
        fileItem.setMd5("");
        fileItem.setUid(UserContextHolder.getLoginUserId());
        return fileService.save(fileItem);
    }

    @RequestMapping(params = "method=list")
    public List<FileItemDTO> list(String path) {
        return fileService.list(path, UserContextHolder.getLoginUserId());
    }

    @RequestMapping(params = "method=download")
    public void download(String path, HttpServletResponse response) {
        FileItem file = fileService.getFile(path, UserContextHolder.getLoginUserId());
        if (file == null) {
            return;
        }
        response.setContentType("application/octet-stream;charset=UTF-8");

        String rootDir = ConfigUtil.getString("file_root");
        String absolutePath = FileUtil.fixPath(rootDir + "/" + file.getDir() + "/" + file.getName());
        File f = new File(absolutePath);
        response.addHeader("Content-Disposition", "attachment;filename=\"" + f.getName() + "\"");
        if (!f.exists()) {
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(f);
            response.getOutputStream();
            byte[] b = new byte[48];
            int c = 0;
            while ((c = in.read(b)) > 0) {
                out.write(b, 0, c);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
