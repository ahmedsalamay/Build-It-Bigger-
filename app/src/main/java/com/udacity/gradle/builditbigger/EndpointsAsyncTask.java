package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.VisibleForTesting;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.phantom.asalama.displayjoke.DisplayJokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.JokeBean;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context context;
    public String JOKE_EXTRA_KEY = "joke_key";

    /*public EndpointsAsyncTask(Context context) {
        this.context=context;
    }*/
    @VisibleForTesting
    public boolean isTesting;
    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            context = params[0].first;
            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            e.printStackTrace();
            return  e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if(!isTesting){
            Intent displayJokeIntent = new Intent(context, DisplayJokeActivity.class);
            displayJokeIntent.putExtra(JOKE_EXTRA_KEY, result);
            context.startActivity(displayJokeIntent);
        }

    }
}


