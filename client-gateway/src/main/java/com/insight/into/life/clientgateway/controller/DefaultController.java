package com.insight.into.life.clientgateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zhang_Xiang
 * @since 2022/5/10 10:29:34
 */
@Controller
public class DefaultController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
