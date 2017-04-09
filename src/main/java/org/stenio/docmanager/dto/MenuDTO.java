package org.stenio.docmanager.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stenio on 2017/4/9.
 */
public class MenuDTO {

    private Long id;

    private String name;

    private String dir;

    private List<MenuDTO> subMenus = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<MenuDTO> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<MenuDTO> subMenus) {
        this.subMenus = subMenus;
    }
}
