package org.stenio.docmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by stenio on 2017/4/16.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping
    public String index(){
        return "redirect:/files";
    }
}
