package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myapplication.jokebackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;


   public class EndPointAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {


        private static MyApi myApiService = null;
        private Context context;
        private ProgressBar mprogressBar;

       private static onResponseListener onResponseListener;

       public EndPointAsyncTask(Context context, ProgressBar progressBar) {
           this.context = context;
           this.mprogressBar=progressBar;
           onResponseListener=(onResponseListener )context;
       }

       @Override
       protected void onPreExecute() {
           super.onPreExecute();
           if(mprogressBar!=null)
           {
               mprogressBar.setVisibility(View.VISIBLE);
           }
       }

       public interface onResponseListener
       {
           void onResponse(String response);
       }

        @Override
        protected String doInBackground(Pair<Context, String>... params) {
            if(myApiService == null) {  // Only do this once
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // options for running against local devappserver
                        // - 10.0.2.2 is localhost's IP address in Android emulator
                        // - turn off compression when running against local devappserver
                        .setRootUrl("http://192.168.1.100:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end options for devappserver

                myApiService = builder.build();
            }

            try {
                return myApiService.sayJoke().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i("hherere",result);
            if(mprogressBar!=null)
            {
                mprogressBar.setVisibility(View.GONE);
            }
            onResponseListener.onResponse(result);
        }
    }

