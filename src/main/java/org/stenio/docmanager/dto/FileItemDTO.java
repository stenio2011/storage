package org.stenio.docmanager.dto;

import org.stenio.docmanager.model.FileItem;

/**
 * Created by bjhexin3 on 2017/3/22.
 */
public class FileItemDTO extends FileItem{

    private String userName;

    private String path;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
