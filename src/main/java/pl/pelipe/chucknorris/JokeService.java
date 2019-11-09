package pl.pelipe.chucknorris;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokeService {

    private ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();

    String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}