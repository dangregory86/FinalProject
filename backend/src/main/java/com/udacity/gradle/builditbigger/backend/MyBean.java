package com.udacity.gradle.builditbigger.backend;

import gregory.dan.joke_telling_library.Joke;

/** The object model for the data we are sending through endpoints */
public class MyBean extends Joke {

    private Joke joke;

    public MyBean(String joke, String punchLine) {
        super(joke, punchLine);
    }

    public Joke getData() {
        return joke;
    }

    public void setData(Joke data) {
        joke = data;
    }
}