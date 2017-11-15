package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    CustomData[] strings = {
            new CustomData(R.mipmap.ic_launcher, "Cat"),
            new CustomData(R.mipmap.ic_launcher, "dog"),
            new CustomData(R.mipmap.ic_launcher, "cat dog"),
            new CustomData(R.mipmap.ic_launcher, "Mouse"),
            new CustomData(R.mipmap.ic_launcher, "bird"),
            new CustomData(R.mipmap.ic_launcher, "tiger")
    };

    private EditText editText;
    private CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.edit_text);
        editText.addTextChangedListener(textWatcher);

        AdapterView listView = (AdapterView) findViewById(R.id.listView);
        adapter = new CustomAdapter(
                this, strings);
        listView.setAdapter(adapter);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            adapter.getFilter().filter(s.toString());
        }
    };
}
