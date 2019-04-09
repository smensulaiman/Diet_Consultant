package com.diu.finalproject.dietplan.LIstAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.diu.finalproject.dietplan.R;
import com.diu.finalproject.dietplan.UserModel.Item;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;
    public CustomListAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total item in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns the item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_part_listview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item currentItem = (Item) getItem(position);
        viewHolder.itemName.setText(currentItem.getName());
        viewHolder.itemDescription.setText(currentItem.getDesc());

        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView itemName;
        TextView itemDescription;

        public ViewHolder(View view) {
            itemName = (TextView)view.findViewById(R.id.partBtn);
            itemDescription = (TextView) view.findViewById(R.id.desc);
        }
    }
}
