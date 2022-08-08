package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String guessPage() {
        return "roll-dice";
    }

    @GetMapping("roll-dice/{n}")
    public String winOrLose(@PathVariable int n, Model model) {
        model.addAttribute("num", n);
        model.addAttribute("roll1", (int)Math.floor((Math.random()*12) + 1));
        model.addAttribute("roll2", (int)Math.floor((Math.random()*12) + 1));
        model.addAttribute("roll3", (int)Math.floor((Math.random()*12) + 1));
        model.addAttribute("roll4", (int)Math.floor((Math.random()*12) + 1));
        model.addAttribute("roll5", (int)Math.floor((Math.random()*12) + 1));

        return "guess-page";
    }


}
