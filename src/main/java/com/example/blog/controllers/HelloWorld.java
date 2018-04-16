package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorld {
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(){
        return "you have been logged out";
    }

    @RequestMapping(path = "/lights", method = RequestMethod.GET)
    @ResponseBody
    public String lights(){
        return "Lights on";
    }


}
