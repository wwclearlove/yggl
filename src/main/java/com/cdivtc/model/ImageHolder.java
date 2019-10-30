package com.cdivtc.model;

import java.io.InputStream;

public class ImageHolder {
    private String imageName;
    private InputStream image;

    public String getImageName() {
        return imageName;
    }

    public ImageHolder() {
    }

    public ImageHolder(String imageName, InputStream image) {
        this.imageName = imageName;
        this.image = image;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
