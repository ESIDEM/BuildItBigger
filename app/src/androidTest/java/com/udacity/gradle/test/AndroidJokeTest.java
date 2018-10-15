package com.udacity.gradle.test;

import android.app.Application;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeOutput;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class AndroidJokeTest extends ApplicationTestCase<Application> implements JokeOutput{
    public AndroidJokeTest() {
        super(Application.class);
    }

    CountDownLatch countDownLatch;
    String joke;

    @Test
    public void jokeTest(){

        try {
            countDownLatch = new CountDownLatch(1);
            new EndpointsAsyncTask().execute(this);
            countDownLatch.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    @Override
    public void processFinish(String output) {

        this.joke = output;
        countDownLatch.countDown();

    }
}
