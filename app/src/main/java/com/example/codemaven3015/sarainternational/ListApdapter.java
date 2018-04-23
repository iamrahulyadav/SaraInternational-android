package com.example.codemaven3015.sarainternational;

/**
 * Created by CodeMaven3015 on 1/23/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListApdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private int images[];
    private Context context;




    public ListApdapter(ArrayList<String> list, Context context, int images[]) {
        this.list = list;
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_image_text, null);
        }

        //Handle TextView and display string from your list
        LinearLayout linearLayout_image_text = view.findViewById(R.id.linearLayout_image_text);
        TextView listItemText = (TextView) view.findViewById(R.id.txtList);
        listItemText.setText(list.get(position));
        ImageView imageView = (ImageView) view.findViewById(R.id.imgList);
        imageView.setImageResource(images[position]);

        return view;
    }
}