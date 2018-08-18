package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import gregory.dan.jokedisplaylibrary.JokeActivity;

/**
 * Created by Daniel Gregory on 14/08/2018.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, com.udacity.gradle.builditbigger.backend.myApi.model.Joke> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected com.udacity.gradle.builditbigger.backend.myApi.model.Joke doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0].first;

        try {
            return myApiService.tellAJoke().execute();
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(com.udacity.gradle.builditbigger.backend.myApi.model.Joke result) {
        if(result == null) {
            Toast.makeText(context, "No joke could be returned", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra(JokeActivity.JOKE, result.getJoke());
            intent.putExtra(JokeActivity.PUNCHLINE, result.getPunchLine());
            context.startActivity(intent);
        }
    }
}
