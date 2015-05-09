package com.edward.instagramphotoviewer.models;

import java.util.ArrayList;

/**
 * Created by edwardyang on 5/6/15.
 */
public class Photo {

    public String caption;
    public String link;
    public String author;
    public int imageHeight;
    public String imageUrl;
    public String createdAt;
    public int likes;


    public static ArrayList<Photo> getMockPhotos() {
        ArrayList<Photo> photos = new ArrayList<>();

        Photo photo1 = new Photo();
        photo1.caption = "Photo 1";

        Photo photo2 = new Photo();
        photo2.caption = "Photo 2";

        Photo photo3 = new Photo();
        photo3.caption = "Photo 3";

        photos.add(photo1);
        photos.add(photo2);
        photos.add(photo3);

        return photos;
    }

}
