package org.stenio.docmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.stenio.docmanager.model.User;
import org.stenio.docmanager.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by stenio on 2017/4/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public String index(String msg, Model model){
        model.addAttribute("msg", msg);
        return "login";
    }

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpServletRequest request, HttpServletResponse response) {
        User user = userService.getByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user", user);
            return "redirect:/files";
        }
        model.addAttribute("msg", "错误的用户名或密码");

        return "redirect:/login";
    }
}
