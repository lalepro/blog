package com.example.blog.controllers.exercises;

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


    @Controller
    public static class MathController {
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

    //    @GetMapping("/divide/{x}/by/{y}")
    //    @ResponseBody
    //    public String divide(@PathVariable int x, @PathVariable int y){
    //        int z;
    //        if(x = 0) {
    //            return "error: Cannot use a zero";
    //        } if  (y = 0){
    //            return "error: Cannot use a zero";
    //        }
    //        else {
    //            z = x / y;
    //        }
    //        return "Dividing Method " + x + " divided " + y + " = " + z;
    //    }

    //    @GetMapping("/string/reverse/{string}")
    //    @ResponseBody
    //    public String reverseString(String str){
    //        return str.split("").reverse().join("");
    //    }
    }
}
