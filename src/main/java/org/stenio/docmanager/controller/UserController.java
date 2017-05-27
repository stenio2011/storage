package org.stenio.docmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.stenio.docmanager.model.User;
import org.stenio.docmanager.service.UserService;
import org.stenio.docmanager.util.StringUtil;

/**
 * Created by bjhexin3 on 2017/5/26.
 */

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(String error, String success, Model model){
        if (StringUtil.isNotEmpty(error)) {
            model.addAttribute("error", error);
        } else if (StringUtil.isNotEmpty(success)) {
            model.addAttribute("success", true);
        }
        return "register";
    }


    @RequestMapping("/doRegister")
    public String doRegister(String username, String password, String rePassword, String realName, Model model){
        if (StringUtil.isEmpty(username)) {
            model.addAttribute("error", "用户名不能为空");
        }
        else if (StringUtil.isEmpty(password)) {
            model.addAttribute("error", "密码不能为空");
        }
        else if (StringUtil.isEmpty(rePassword)) {
            model.addAttribute("error", "确认密码不能为空");
        }
        else if (StringUtil.isEmpty(realName)) {
            model.addAttribute("error", "姓名不能为空");
        }
        else if (!password.equals(rePassword)) {
            model.addAttribute("error", "两次输入密码不一致");
        }
        User user = userService.getByUsername(username);
        if (user != null) {
            model.addAttribute("error", "用户名已存在");
        }

        userService.addUser(username, password, realName);

        model.addAttribute("success", true);

        return "redirect:/users/register";
    }
}
