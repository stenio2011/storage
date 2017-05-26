package org.stenio.docmanager.service;

import org.stenio.docmanager.model.User;

import java.util.List;

/**
 * Created by bjhexin3 on 2017/3/23.
 */
public interface UserService {

    List<User> list(List<Long> ids);

    User getByUsername(String userName);

    void addUser(String username, String password, String realName);
}
