package org.stenio.docmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stenio.docmanager.constants.FileItemType;
import org.stenio.docmanager.mapper.FileItemMapper;
import org.stenio.docmanager.model.FileItem;
import org.stenio.docmanager.model.FileItemCriteria;
import org.stenio.docmanager.util.FileUtil;

import java.util.Date;
import java.util.List;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileItemMapper fileItemMapper;

    @Override
    public FileItem createFolder(String path, long uid) {
        String[] strs = FileUtil.splitDirAndName(path);
        FileItem fileItem = new FileItem();
        fileItem.setDir(strs[0]);
        fileItem.setName(strs[1]);
        fileItem.setUid(uid);
        fileItem.setcTime(new Date());
        fileItem.setmTime(new Date());
        fileItem.setIsDir(FileItemType.Dir.getValue().byteValue());
        fileItem.setSize(0L);
        fileItem.setMd5("");
        fileItemMapper.insert(fileItem);
        return fileItem;
    }


    @Override
    public List<FileItem> test() {
        FileItemCriteria query = new FileItemCriteria();
        return fileItemMapper.selectByExample(query);
    }

    @Override
    public FileItem save(FileItem fileItem) {
        fileItem.setIsDir(FileItemType.File.getValue().byteValue());
        fileItem.setcTime(new Date());
        fileItem.setmTime(new Date());
        fileItemMapper.insert(fileItem);
        return fileItem;
    }

    @Override
    public List<FileItem> list(String path, long uid) {
        FileItemCriteria query = new FileItemCriteria();
        query.createCriteria().andUidEqualTo(uid).andDirEqualTo(path);
        return fileItemMapper.selectByExample(query);
    }
}
