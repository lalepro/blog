package com.example.blog.controllers.exercises;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @GetMapping("/home")
    public String welcome(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcomeUser(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/home/users")
    public String welcomeUser( Model model){
        List<String> users = new ArrayList<>();

        users.add("John");
        users.add("laura");
        model.addAttribute("users", users);
        return "home";
    }

    @Controller
    public static class RollDiceController {
        @GetMapping("/roll-dice")
        public String rollDice() {
            return "roll-dice";
        }

        @GetMapping("/dice-roll/{guess}")
        public String rollDice(@PathVariable int guess, Model model) {
            int random = (int) (Math.random() * 6 + 1);
            boolean win;
            if(random == guess) {
                win = true;
            } else {
                win = false;
            }
            model.addAttribute("random", random);
            model.addAttribute("guess", guess);
            model.addAttribute("win", win);
            return "dice-roll";
        }
    }
}
