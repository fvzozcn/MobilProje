package com.example.odevtekrar;

import android.content.ContentResolver;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;

import java.util.List;

public class userAdap extends BaseAdapter {
    List<webUser> webUsers;
    Context  context;

    public userAdap(List<webUser> webUsers, Context context) {
        this.webUsers = webUsers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return webUsers.size();
    }

    @Override
    public Object getItem(int position) {
        return webUsers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        TextView filmAd=row.findViewById(R.id.txtAd);
        TextView filmYil=row.findViewById(R.id.txtYil);
        ImageView img=row.findViewById(R.id.img);
        filmAd.setText(webUsers.get(position).getFilmAdi());
        filmYil.setText(webUsers.get(position).getFilmYil());
        Glide.with(context).load(webUsers.get(position)._th).into(img);


        return row;
    }
}
