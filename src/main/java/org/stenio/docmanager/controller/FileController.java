package org.stenio.docmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.stenio.docmanager.dto.FileItemDTO;
import org.stenio.docmanager.dto.MenuDTO;
import org.stenio.docmanager.model.FileItem;
import org.stenio.docmanager.service.FileService;
import org.stenio.docmanager.util.ConfigUtil;
import org.stenio.docmanager.util.FileUtil;
import org.stenio.docmanager.util.StringUtil;
import org.stenio.docmanager.util.UserContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
@Controller
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/createFolder")
    @ResponseBody
    public FileItem createFolder(String path) {
        return fileService.createFolder(path, UserContextHolder.getLoginUserId());
    }

    @RequestMapping("/upload")
    public String upload(String path, String redirectPath, FileItem fileItem, @RequestParam("file") MultipartFile file) throws IOException {
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

        fileItem.setSize(file.getSize());
        fileItem.setDir(path);
        fileItem.setName(fileName);
        fileItem.setMd5("");
        fileItem.setUid(UserContextHolder.getLoginUserId());
        fileService.save(fileItem);
        return "redirect:" + redirectPath;
    }

    @RequestMapping("/delete")
    public String delete(String redirectPath, String path) {
        int i = fileService.delete(path);
        return "redirect:" + redirectPath;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<FileItemDTO> list(String path) {
        return fileService.list(path, UserContextHolder.getLoginUserId());
    }

    @RequestMapping("/download")
    @ResponseBody
    public void download(String path, HttpServletRequest request, HttpServletResponse response) {
        FileItem file = fileService.getFile(path, UserContextHolder.getLoginUserId());
        if (file == null) {
            return;
        }
        response.setContentType("application/octet-stream;charset=UTF-8");

        String rootDir = ConfigUtil.getString("file_root");
        String absolutePath = FileUtil.fixPath(rootDir + "/" + file.getDir() + "/" + file.getName());
        File f = new File(absolutePath);
        try {
            response.addHeader("Content-Disposition", "attachment;filename=\"" + java.net.URLEncoder.encode(file.getName(), "UTF-8") + "\"");
        } catch (UnsupportedEncodingException e) {
        }
        if (!f.exists()) {
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(f);
            out = response.getOutputStream();
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

    @RequestMapping
    public String index(Model model, HttpServletRequest request, @RequestParam(defaultValue = "/") String path) {
        String requestURL = request.getRequestURL().toString();
        if (StringUtil.isNotEmpty(request.getQueryString())) {
            try {
                requestURL += "?" + URLEncoder.encode(request.getQueryString(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("requestURL", requestURL);
        List<MenuDTO> menus = showMenu(model);
        model.addAttribute("menus", menus);
        if ("/".equals(path)) {
            path = FileUtil.fixPath(menus.get(0).getSubMenus().get(0).getDir() + "/" + menus.get(0).getSubMenus().get(0).getName());
        }

        String projectName = path.substring(path.lastIndexOf("/") + 1);
        model.addAttribute("projectName", projectName);
        model.addAttribute("path", path);
        List<FileItemDTO> leafDirs = fileService.listDir(path, UserContextHolder.getLoginUserId());
        List<Map<String, Object>> leafNodes = new ArrayList<>();
        if (leafDirs.isEmpty()) {
            FileItemDTO leafDir = new FileItemDTO();
            leafDir.setDir(path);
            leafDir.setId(1L);
            leafDir.setName("文件列表");
            leafDirs.add(leafDir);
        }
        for (FileItemDTO fileItem : leafDirs) {
            Map<String, Object> item = new HashMap();
            item.put("meta", fileItem);
            String leafPath = FileUtil.fixPath(fileItem.getDir() + "/" + (fileItem.getName().equals("文件列表") ? "" : fileItem.getName()));
            item.put("path", leafPath);
            item.put("data", fileService.list(leafPath, UserContextHolder.getLoginUserId()));
            leafNodes.add(item);
        }
        model.addAttribute("leafNodes", leafNodes);

        return "file";
    }

    private List<MenuDTO> showMenu(Model model) {
        List<MenuDTO> menus = new ArrayList<>();
        List<FileItemDTO> rootMenus = fileService.list("/", UserContextHolder.getLoginUserId());
        for (FileItemDTO rootMenu : rootMenus) {
            MenuDTO menu = new MenuDTO();
            menu.setId(rootMenu.getId());
            menu.setName(rootMenu.getName());
            menu.setDir(rootMenu.getDir());
            List<FileItemDTO> subMenus = fileService.list("/" + rootMenu.getName(), UserContextHolder.getLoginUserId());
            for (FileItemDTO subMenu : subMenus) {
                MenuDTO subMenuDTO = new MenuDTO();
                subMenuDTO.setId(subMenu.getId());
                subMenuDTO.setName(subMenu.getName());
                subMenuDTO.setDir(subMenu.getDir());
                String path = subMenu.getDir() + "/" + subMenu.getName();
                try {
                    path = URLEncoder.encode(path, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                subMenuDTO.setPath(path);
                menu.getSubMenus().add(subMenuDTO);
            }
            menus.add(menu);
        }
        return menus;
    }

}
