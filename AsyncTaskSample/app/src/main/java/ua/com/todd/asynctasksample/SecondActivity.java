package ua.com.todd.asynctasksample;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity implements CustomAsyncTask.CallBack {
    private TextView button;
    private TextView button1;
    private FragmentTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = (TextView) findViewById(R.id.button);
        button1 = (TextView) findViewById(R.id.button1);

        task = (FragmentTask) getFragmentManager().findFragmentByTag(FragmentTask.class.getName());
        if (task == null) {
            task = new FragmentTask();
            getFragmentManager().beginTransaction()
                    .add(task, FragmentTask.class.getName())
                    .commit();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(String.class.getName(), button.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String str = savedInstanceState.getString(String.class.getName());
        button.setText(str);
    }

    public void onClick(View view) {
        AsyncTask a = new CustomAsyncTask(c);
        Integer i = (Integer) view.getTag();
        if (i == null)
            i = 1;
        view.setTag(i + 1);
        a.execute("Data", i, "SecondActivity");
    }

    CustomAsyncTask.CallBack c = new CustomAsyncTask.CallBack() {
        @Override
        public void callback(String s) {
            button.setText(s);
        }
    };


    public void onClick1(View view) {
        Integer i = (Integer) view.getTag();
        if (i == null)
            i = 1;
        view.setTag(i + 1);
        task.startAsync("Data", i + "", "SecondActivity1");
    }

    @Override
    public void callback(String s) {
        button1.setText(s);
    }
}
