package com.mohammed.shameem.clist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {

    ArrayList<Flower> flowerList = new ArrayList<Flower>();
    LayoutInflater inflater;
    Context context;


    public MyBaseAdapter(Context context, ArrayList<Flower> flowerList) {
        this.flowerList = flowerList;
        this.context = context;
        inflater = LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return flowerList.size();
    }

    @Override
    public Flower getItem(int position) {
        return flowerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_list_item, parent, false);
            mViewHolder = new MyViewHolder(convertView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (MyViewHolder) convertView.getTag();
        }

        Flower flowerListData = getItem(position);

        mViewHolder.tvTitle.setText(flowerListData.getName());
        mViewHolder.tvDesc.setText(flowerListData.getInstructions());
        String imageURL = flowerListData.getPhoto();
        Picasso.with(context).load(imageURL).into(mViewHolder.ivIcon); //Always viewholderConstructor.anyView
        return convertView;
    }

    private class MyViewHolder {
        TextView tvTitle, tvDesc;
        ImageView ivIcon;

        public MyViewHolder(View item) {
            tvTitle = (TextView) item.findViewById(R.id.tvTitle);
            tvDesc = (TextView) item.findViewById(R.id.tvDesc);
            ivIcon = (ImageView) item.findViewById(R.id.ivIcon);
        }
    }
}