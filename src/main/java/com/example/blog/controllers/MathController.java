package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{x}/and/{y}")
    @ResponseBody
    public String adding(@PathVariable int x, @PathVariable int y){
        int z = x + y;
        return "Adding Method: " + x + " plus " + y + " = " + z;
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String substract(@PathVariable int x, @PathVariable int y){
        int z = x - y;
        return "Subtracting Method " + x + " minus " + y + " = " + z;
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String multiply(@PathVariable int x, @PathVariable int y){
        int z = x * y;
        return "Multiplying Method " + x + " multiply " + y + " = " + z;
    }

    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String divide(@PathVariable int x, @PathVariable int y){
        int z = x/y;
        return "Dividing Method " + x + " divided " + y + " = " + z;

    }
}
