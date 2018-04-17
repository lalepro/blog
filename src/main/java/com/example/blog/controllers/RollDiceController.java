package com.example.blog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }

    @GetMapping("/rollDice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int random = (int) (Math.random() * 6) + 1;
        boolean result = random == guess;
        model.addAttribute("result", result);
        model.addAttribute("number", random);
        model.addAttribute("guess", guess);
        return "rollDice";
    }
}
