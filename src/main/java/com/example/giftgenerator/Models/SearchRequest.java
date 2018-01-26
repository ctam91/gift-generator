package com.example.giftgenerator.Models;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SearchRequest {
    @NotNull
    @Size(min = 1)
    private String price;

    @NotNull
    @Size(min = 1)
    private String gender;

    @NotNull
    @Size(min = 1)
    private String hobby;

    public SearchRequest() {
    }

    public SearchRequest(String price, String gender, String hobby) {
        this.price = price;
        this.gender = gender;
        this.hobby = hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
