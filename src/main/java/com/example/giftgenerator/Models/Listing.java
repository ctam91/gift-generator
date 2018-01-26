package com.example.giftgenerator.Models;

public class Listing {

    private String detail;
    private String imageURL;
    private String title;
    private String price;

    public Listing() {
    }

    public Listing(String detail, String imageURL, String title) {
        this.detail = detail;
        this.imageURL = imageURL;
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
