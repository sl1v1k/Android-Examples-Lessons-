package ua.com.tod.examples.androidexamples;

import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import ua.com.tod.examples.androidexamples.model.Callback;
import ua.com.tod.examples.androidexamples.model.INetworkManager;

public class MainActivity extends BaseActivity {

    @Inject
    INetworkManager networkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkManager.login("", "", new Callback() {
            @Override
            public void onData(String str) {
                Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFail(String str) {

            }
        });
    }
}
