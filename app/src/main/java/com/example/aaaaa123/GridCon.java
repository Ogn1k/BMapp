package com.example.aaaaa123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridCon extends BaseAdapter
{

    private Context context;
    private String[] itemsNames;
    LayoutInflater inflater;
    int[] image;

    public GridCon(Context context, String[] itemsNames, int[] image) {
        this.context = context;
        this.itemsNames = itemsNames;
        this.image = image;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return itemsNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater==null)
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null)
            convertView=inflater.inflate(R.layout.grid_item, null);

        ImageView imageView = convertView.findViewById(R.id.grid_image);
        TextView textView = convertView.findViewById(R.id.grid_text);

        imageView.setImageResource(image[position]);
        textView.setText(itemsNames[position]);

        return convertView;
    }
}
