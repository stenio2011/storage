package org.stenio.docmanager.util;

import org.stenio.docmanager.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bjhexin3 on 2017/3/21.
 */
public class UserContextHolder {

    public static long getLoginUserId(HttpServletRequest request){
        Object userObj = request.getSession().getAttribute("user");
        if(userObj != null){
            return ((User) userObj).getId();
        }
        throw new NullPointerException("user has not login");
    }
}
