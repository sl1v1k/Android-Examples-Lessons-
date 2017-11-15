package ua.com.todd.asynctasksample;

import android.os.Handler;

public abstract class HandlerThread<T> extends Thread {

    private T data;
    private Handler h = new Handler();

    @Override
    public void run() {
        data = doInBackground();
        h.post(new Runnable() {
            @Override
            public void run() {
                onPostExecute(data);
            }
        });
    }

    protected abstract T doInBackground();
    protected abstract void onPostExecute(T data);
}
