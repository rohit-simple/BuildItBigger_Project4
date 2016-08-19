package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private CountDownLatch countDownLatch = null;
    private String jokeString = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        countDownLatch = new CountDownLatch(1);
    }

    public void testEndpointsAsyncTask()throws InterruptedException{
        new EndpointsAysncTask(new EndpointsAysncTask.EndpointsAsyncTaskCommunicator() {
            @Override
            public void taskCompleted(String result) {
                jokeString = result;
                countDownLatch.countDown();
            }
        }).execute();
        countDownLatch.await();

        assertFalse(TextUtils.isEmpty(jokeString));
    }
}