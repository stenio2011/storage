package org.stenio.docmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bjhexin3 on 2017/5/27.
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping
    public String doLogout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return "redirect:/login";
    }
}
