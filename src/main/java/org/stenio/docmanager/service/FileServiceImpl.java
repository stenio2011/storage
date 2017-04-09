package org.stenio.docmanager.service;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stenio.docmanager.constants.FileItemType;
import org.stenio.docmanager.dto.FileItemDTO;
import org.stenio.docmanager.mapper.FileItemMapper;
import org.stenio.docmanager.model.FileItem;
import org.stenio.docmanager.model.FileItemCriteria;
import org.stenio.docmanager.model.User;
import org.stenio.docmanager.util.FileUtil;
import org.stenio.docmanager.util.StringUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * Created by bjhexin3 on 2017/3/21.
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileItemMapper fileItemMapper;

    @Autowired
    private UserService userService;

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
    public List<FileItemDTO> list(String path, long uid) {
        FileItemCriteria query = new FileItemCriteria();
        query.createCriteria().andUidEqualTo(uid).andDirEqualTo(path);
        List<FileItem> fileItems = fileItemMapper.selectByExample(query);
        if (fileItems.isEmpty()) {
            return new ArrayList<>();
        }
        List<Long> uids = extractUids(fileItems);
        List<User> users = userService.list(uids);
        List<FileItemDTO> result = mapUsers(fileItems, users);
        return result;
    }

    @Override
    public FileItem getFile(String path, long uid) {
        FileItemCriteria query = new FileItemCriteria();
        String[] strs = FileUtil.splitDirAndName(path);
        // todo
        if (StringUtil.isEmpty(strs[0]) || StringUtil.isEmpty(strs[1])) {
            return null;
        }
        query.createCriteria().andUidEqualTo(uid).andDirEqualTo(strs[0]).andNameEqualTo(strs[1]);
        List<FileItem> fileItems = fileItemMapper.selectByExample(query);
        if (fileItems != null && !fileItems.isEmpty()) {
            return fileItems.get(0);
        }
        return null;
    }

    private List<FileItemDTO> mapUsers(List<FileItem> fileItems, List<User> users) {
        List<FileItemDTO> result = new ArrayList<>(fileItems.size());
        Map<Long, User> userMap = new HashMap<>();
        for (User user : users) {
            userMap.put(user.getId(), user);
        }
        for (FileItem item : fileItems) {
            User user = userMap.get(item.getUid());
            FileItemDTO file = new FileItemDTO();
            try {
                BeanUtils.copyProperties(file, item);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new IllegalStateException("properties copy error");
            }
            file.setUserName(user.getRealName());
            result.add(file);
        }
        return result;
    }

    private List<Long> extractUids(List<FileItem> fileItems) {
        List<Long> uids = new ArrayList<>(fileItems.size());
        for (FileItem item : fileItems) {
            uids.add(item.getUid());
        }
        return uids;
    }
}
