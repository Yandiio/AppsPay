package com.example.paycash;

public class ScreenView {
    String Description, Title;
    int ImageView;

    public ScreenView(String title, String description, int imageView) {
        Title = title;
        Description = description;
        ImageView = imageView;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getImageView() {
        return ImageView;
    }

    public void setImageView(int imageView) {
        ImageView = imageView;
    }
}