package pl.pelipe.chucknorris;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class JokeController {

    private JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping("/")
    public String displayJoke(Model model) {
        String joke = jokeService.getJoke();
        model.addAttribute("joke", joke);
        return "jokepage";
    }
}
