package org.stenio.docmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stenio.docmanager.mapper.UserMapper;
import org.stenio.docmanager.model.User;
import org.stenio.docmanager.model.UserCriteria;

import java.util.List;

/**
 * Created by bjhexin3 on 2017/3/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(List<Long> ids) {
        UserCriteria query = new UserCriteria();
        query.createCriteria().andIdIn(ids);
        return userMapper.selectByExample(query);
    }

    @Override
    public User getByUsername(String userName) {
        UserCriteria query = new UserCriteria();
        query.createCriteria().andUsernameEqualTo(userName);
        List<User> users = userMapper.selectByExample(query);
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }
}
