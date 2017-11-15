package com.example.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private CustomData[] datas;

    public CustomAdapter(Context context, CustomData[] strings) {
        this.context = context;
        this.datas = strings;
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public CustomData getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CustomData data = getItem(position);

        View view = View.inflate(context, R.layout.item_some, null);

        TextView textView = (TextView) view.findViewById(R.id.text1);
        textView.setText(data.getText());

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageResource(data.getDrawableId());

        return view;
    }
}
