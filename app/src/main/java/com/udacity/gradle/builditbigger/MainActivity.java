package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.Joke;
import com.example.android.jokeandroidlibrary.JokeActivity;


public class MainActivity extends AppCompatActivity implements EndPointAsyncTask.onResponseListener {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.loading_indicator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        new EndPointAsyncTask(this,progressBar).execute();
    }
    public void displayJoke(View view) {
       Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKEINTENT, Joke.getJoke());
        startActivity(intent);
    }


    @Override
    public void onResponse(String response) {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKEINTENT, response);
        startActivity(intent);

    }
}
