package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.rohit.java.backend.myApi.MyApi;

import java.io.IOException;

public class EndpointsAysncTask extends AsyncTask<Void, Void, String> {
    private EndpointsAsyncTaskCommunicator communicator;

    public interface EndpointsAsyncTaskCommunicator{
        public void taskCompleted(String result);
    }

    public EndpointsAysncTask(EndpointsAsyncTaskCommunicator communicator){
        this.communicator = communicator;
    }

    @Override
    protected String doInBackground(Void... voids) {
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null);
        builder.setRootUrl("http://10.0.0.6:8080/_ah/api/");    //10.0.0.6 is my laptop's IP
        builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
            @Override
            public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                request.setDisableGZipContent(true);
            }
        });
        MyApi myApiService = builder.build();

        try{
            return myApiService.getOneJoke().execute().getData();
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        if(communicator != null){
           communicator.taskCompleted(s);
        }
    }
}
