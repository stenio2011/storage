package org.stenio.docmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bjhexin3 on 2017/3/20.
 */
@Controller
public class DemoController {

    public DemoController(){
        System.out.println("demo controller constructor");
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public Map<String, String> test2(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        return map;
    }
}
