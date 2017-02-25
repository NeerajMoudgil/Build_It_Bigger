package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joke {

    private static ArrayList<String> jokes = new ArrayList<>();

    public  static String getJoke() {
     Random random = new Random();
    jokes.add("THERE IS NO JOKE HERE");
    jokes.add("TRY CLICKING SOME OTHER BUTTON YOU SEE NEARBY");
    jokes.add("GOOGLE IT");
    return jokes.get(random.nextInt(jokes.size()));
    }
}
