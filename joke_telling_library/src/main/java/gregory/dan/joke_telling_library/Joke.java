package gregory.dan.joke_telling_library;

/**
 * Created by Daniel Gregory on 08/08/2018.
 */
public class Joke {

    private String joke;
    private String punchLine;

    public Joke(String joke, String punchLine) {
        this.joke = joke;
        this.punchLine = punchLine;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getPunchLine() {
        return punchLine;
    }

    public void setPunchLine(String punchLine) {
        this.punchLine = punchLine;
    }
}
