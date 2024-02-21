package com.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/")
    public String login(){
        return "login";
    }

    @GetMapping("/all")
    public String allChats(){
        return "chat";
    }

}
