package ua.com.todd.asynctasksample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

public class FragmentTask extends Fragment {
    private CustomAsyncTask.CallBack callBack;
    private CustomAsyncTask asyncTask;

    public void startAsync(String... str) {
        asyncTask = new CustomAsyncTask(new CustomAsyncTask.CallBack() {
            @Override
            public void callback(String s) {
                callBack.callback(s);
            }
        });
        asyncTask.execute(str);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof CustomAsyncTask.CallBack) {
            callBack = (CustomAsyncTask.CallBack) activity;
        } else {
            throw new RuntimeException("Activity must implement CallBack");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callBack = null;
    }
}
