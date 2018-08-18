package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import gregory.dan.joke_telling_library.Joke;
import gregory.dan.joke_telling_library.JokeTeller;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "tellAJoke")
    public Joke tellAJoke() {
        MyBean response = new MyBean(null, null);
        JokeTeller jokeTeller = new JokeTeller();
        Joke joke = jokeTeller.getJoke();
        response.setData(joke);
        return response;
    }

}


