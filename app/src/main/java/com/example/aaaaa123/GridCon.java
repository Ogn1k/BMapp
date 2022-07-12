package com.example.aaaaa123;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class GridCon extends BaseAdapter
{

    private Context context;
    private List<Post> imagesResponseList;
    LayoutInflater inflater;

    public GridCon( List<Post> imagesResponseList, Context context) {
        this.context = context;
        this.imagesResponseList = imagesResponseList;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imagesResponseList.size();
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

        textView.setText(imagesResponseList.get(position).getName());

        Glide.with(context)
                .load(imagesResponseList.get(position).getUrl())
                .into(imageView);

        return convertView;
    }
}
