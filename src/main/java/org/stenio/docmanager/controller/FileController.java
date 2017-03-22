package org.stenio.docmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.stenio.docmanager.model.FileItem;
import org.stenio.docmanager.service.FileService;
import org.stenio.docmanager.util.ConfigUtil;
import org.stenio.docmanager.util.FileUtil;
import org.stenio.docmanager.util.UserContextHolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping(params = "method=createFolder")
    @ResponseBody
    public FileItem createFolder(String path) {
        return fileService.createFolder(path, UserContextHolder.getLoginUserId());
    }

    @RequestMapping(params = "method=upload")
    @ResponseBody
    public FileItem upload(String path, @RequestParam("file") MultipartFile file) throws IOException {
        String rootPath = ConfigUtil.getString("file_root");
        String absoluteDir = FileUtil.fixPath(rootPath + "/" + path);
        File dir = new File(absoluteDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!dir.isDirectory()) {
            // TODO 返回错误
        }
        String fileName = file.getOriginalFilename();
        file.transferTo(new File(FileUtil.fixPath(absoluteDir + "/" + fileName)));
        FileItem fileItem = new FileItem();
        fileItem.setSize(file.getSize());
        fileItem.setDir(path);
        fileItem.setName(fileName);
        fileItem.setMd5("");
        fileItem.setUid(UserContextHolder.getLoginUserId());
        return fileService.save(fileItem);
    }

    public List<FileItem> list(String path) {
        return fileService.list(path, UserContextHolder.getLoginUserId());
    }

}
