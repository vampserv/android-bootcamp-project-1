package com.edward.instagramphotoviewer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edward.instagramphotoviewer.models.Photo;
import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwardyang on 5/6/15.
 */
public class PhotoAdapter extends ArrayAdapter<Photo> {

    public PhotoAdapter(Context context, List<Photo> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Photo photo = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }

        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        TextView tvAuthor = (TextView) convertView.findViewById(R.id.tvAuthor);
        TextView tvAuthorTop = (TextView) convertView.findViewById(R.id.tvAuthorTop);
        TextView tvLocation = (TextView) convertView.findViewById(R.id.tvLocation);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ImageView ivAuthorPhoto = (ImageView) convertView.findViewById(R.id.ivAuthorPhoto);

        tvCaption.setText(photo.caption);
        tvAuthor.setText(photo.author);
        tvAuthorTop.setText(photo.author);
//        tvLocation.setText(photo.location);
        tvLikes.setText(Integer.toString(photo.likes));
        ivPhoto.setImageResource(0);
        Picasso.with(getContext()).load(photo.imageUrl).placeholder(R.drawable.placeholder).into(ivPhoto);

        com.squareup.picasso.Transformation transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(100)
                .oval(true)
                .build();
        Picasso.with(getContext()).load(photo.authorPhoto).placeholder(R.drawable.placeholder).fit().transform(transformation).into(ivAuthorPhoto);

        return convertView;
    }

}
