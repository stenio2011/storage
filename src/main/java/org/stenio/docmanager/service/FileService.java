package org.stenio.docmanager.service;

import org.stenio.docmanager.dto.FileItemDTO;
import org.stenio.docmanager.model.FileItem;

import java.util.List;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
public interface FileService {


    FileItem createFolder(String path, long uid);

    List<FileItem> test();

    FileItem save(FileItem fileItem);

    List<FileItemDTO> list(String path, long uid);

    FileItem getFile(String path, long uid);
}
