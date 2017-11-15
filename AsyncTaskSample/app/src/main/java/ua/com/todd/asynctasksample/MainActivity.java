package ua.com.todd.asynctasksample;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickThread(final View view) {
        new Thread() {
            @Override
            public void run() {
                sleepThread();
                Button b = (Button) view;
                b.setText("Some text");
            }
        }.start();
    }

    public void onClickViewThread(final View view) {
        new Thread() {
            @Override
            public void run() {
                sleepThread();
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        Button b = (Button) view;
                        b.setText("Some text");
                    }
                });
            }
        }.start();
    }

    public void onClickHandlerThread(final View view) {
        new Thread() {
            @Override
            public void run() {
                sleepThread();
                Handler h = new Handler();
                h.post(new Runnable() {
                    @Override
                    public void run() {
                        Button b = (Button) view;
                        b.setText("Some text");
                    }
                });
            }
        }.start();
    }

    public void onClickHandlerAsyncThread(final View view) {
        new HandlerThread<String>(){

            @Override
            protected String doInBackground() {
                sleepThread();
                return "Some text";
            }

            @Override
            protected void onPostExecute(String data) {
                Button b = (Button) view;
                b.setText(data);
            }
        }.start();
    }

    public void onClickAsyncThread(final View view) {
        AsyncTask a = new CustomAsyncTask();
        Integer i = (Integer) view.getTag();
        if(i == null)
            i = 1;
        view.setTag(i + 1);
        a.execute("Some", i, "Simple");
    }

    public void onClickAsyncThreadPool(final View view) {
        AsyncTask a = new CustomAsyncTask();
        Integer i = (Integer) view.getTag();
        if(i == null)
            i = 1;
        view.setTag(i + 1);
        a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Some", i, "THREAD_POOL_EXECUTOR");
    }

    public void onClickAsyncThreadSerial(final View view) {
        AsyncTask a = new CustomAsyncTask();
        Integer i = (Integer) view.getTag();
        if(i == null)
            i = 1;
        view.setTag(i + 1);
        a.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, "Some", i, "SERIAL_EXECUTOR");
    }

    private void sleepThread(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startSecondActivity(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
