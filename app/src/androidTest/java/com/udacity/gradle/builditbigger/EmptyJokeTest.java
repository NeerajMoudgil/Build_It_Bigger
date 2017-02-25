package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EmptyJokeTest  {

    @Test
    public void test() {

        String result = null;

        EndPointAsyncTask endpointsAsyncTask = new EndPointAsyncTask();
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d("okkk", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}