package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    CustomData[] strings = {
            new CustomData(R.mipmap.ic_launcher, "Some text"),
            new CustomData(R.mipmap.ic_launcher, "Some text"),
            new CustomData(R.mipmap.ic_launcher, "Some text"),
            new CustomData(R.mipmap.ic_launcher, "Some text"),
            new CustomData(R.mipmap.ic_launcher, "Some text"),
            new CustomData(R.mipmap.ic_launcher, "Some text")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView listView = (AdapterView) findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(
                this, strings);
        listView.setAdapter(adapter);
    }
}
