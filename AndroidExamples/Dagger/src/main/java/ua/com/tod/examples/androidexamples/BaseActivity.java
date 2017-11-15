package ua.com.tod.examples.androidexamples;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApp) getApplication()).inject(this);
    }
}
