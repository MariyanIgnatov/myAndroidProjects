package com.example.mariyan.androidprojectpuzzle;

import android.widget.ImageView;


public class User {
    private String nickname;
    private double time;
    private ImageView imageView;


    public User (String nickname, double time, ImageView imageView) {
        this.nickname = nickname;
        this.time = time;
        this.imageView = imageView;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
