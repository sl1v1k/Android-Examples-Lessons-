package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private List<CustomData> datas;
    private List<CustomData> filteredDatas;
    private CustomFilter customFilter = new CustomFilter();

    public CustomAdapter(Context context, CustomData[] strings) {
        this.context = context;
        this.datas = Arrays.asList(strings);
        this.filteredDatas = datas;
    }

    @Override
    public int getCount() {
        return filteredDatas.size();
    }

    @Override
    public CustomData getItem(int position) {
        return filteredDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("CustomAdapter", "getView");
        ViewHolder viewHolder;
        CustomData data = getItem(position);

        if (convertView == null) {
            Log.i("CustomAdapter", position + " convertView: " + convertView);
            convertView = View.inflate(context, R.layout.item_some, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.textView.setText(data.getText());
        viewHolder.imageView.setImageResource(data.getDrawableId());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return customFilter;
    }

    class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            filteredDatas = new ArrayList<>();
            Log.i("CustomAdapter", "Data: " + constraint);

            for (CustomData item : datas) {
                if (item.getText().toLowerCase().contains(constraint.toString().toLowerCase())) {
                    filteredDatas.add(item);
                }
            }

            return null;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            notifyDataSetChanged();
        }
    }


    class ViewHolder {

        ImageView imageView;
        TextView textView;

        ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.text1);
            imageView = (ImageView) view.findViewById(R.id.image);
        }
    }
}
