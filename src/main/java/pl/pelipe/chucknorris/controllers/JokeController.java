package pl.pelipe.chucknorris.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.pelipe.chucknorris.services.JokeService;

@Controller

public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/")
    public String displayIndex() {
        return "index";
    }

    @GetMapping("/getjoke")
    public String getJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());
        return "joke";
    }
}
