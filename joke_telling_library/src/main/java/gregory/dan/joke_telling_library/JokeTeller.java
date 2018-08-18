package gregory.dan.joke_telling_library;


import java.util.Random;

public class JokeTeller {
    public JokeTeller() {
    }

    String[] jokes = {
            "What's the best thing about Switzerland?",
            "I invented a new word!!",
            "Did you hear about the mathematician who’s afraid of negative numbers?",
            "Why do we tell actors to “break a leg?”"
        };

    String[] punchlines = {
            "I don't know, but the flag is a big plus.",
            "Plagiarism",
            "He’ll stop at nothing to avoid them.",
            "Because every play has a cast."
    };

    public Joke getJoke(){
        Random randomNum =  new Random();
        int jokeNumber = randomNum.nextInt(4);

        return new Joke(jokes[jokeNumber], punchlines[jokeNumber]);
    }



}
