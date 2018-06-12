package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;
import android.util.Pair;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskJokeTest //extends ApplicationTestCase<Application>
 {
    //private Context context;

   /* public AsyncTaskJokeTest() {
       super(Application.class);
    }

    @Before
    public void setup() {
        context = InstrumentationRegistry.getContext();;
    }*/

    @Test
    public void NonEmptyStringCheck(){
        String joke=null;
        EndpointsAsyncTask endpointsAsyncTask
                =new EndpointsAsyncTask();
        endpointsAsyncTask.isTesting=true;
        endpointsAsyncTask.execute();
        try {
          joke=  endpointsAsyncTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        assertNotNull(joke);
        assertEquals("Did you hear about the mathematician who's afraid of negative numbers ? "
                +"He'll stop at nothing to avoid them", joke);
    }
}
