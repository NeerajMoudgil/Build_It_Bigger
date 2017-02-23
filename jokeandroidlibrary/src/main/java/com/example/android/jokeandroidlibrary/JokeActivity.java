package com.example.android.jokeandroidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public  static final String JOKEINTENT="jokePassed";
    TextView jokeTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent= getIntent();
        jokeTextView=(TextView)findViewById(R.id.joke_textview);

        if(intent.hasExtra(JOKEINTENT))
        {
            String joke=intent.getStringExtra(JOKEINTENT);
            jokeTextView.setText(joke);
        }
    }


}
