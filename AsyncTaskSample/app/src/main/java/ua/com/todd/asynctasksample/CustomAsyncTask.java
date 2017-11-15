package ua.com.todd.asynctasksample;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Random;

public class CustomAsyncTask extends AsyncTask<Object,String,String> {
    private CallBack c;
    public CustomAsyncTask(){

    }

    public CustomAsyncTask(CallBack c){
        this.c = c;
    }
    @Override
    protected String doInBackground(Object[] params) {
        Random r = new Random();
        int t = r.nextInt(3000);
        String str = "AsyncTask: " + params[1] + " " + params[2] + " Random: " + t;
        Log.i("CustomAsyncTask", str);
        try {
            Thread.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.i("CustomAsyncTask", "--RESULT--   " + s);
        if(c != null)
            c.callback(s);
    }

    public interface CallBack{
        void callback(String s);
    }
}
