package com.insight.into.life.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Zhang_Xiang
 * @since 2022/5/9 11:09:25
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/list")
    public List<String> list() {
        return List.of("menu1", "menu2", "menu3");
    }
}
