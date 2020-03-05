package com.example.class5api;

public class ProfileModel {

    private String email;
    private String first_name;
    private String last_name;
    private String avater;

    public ProfileModel(String email, String first_name, String last_name, String avater) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.avater = avater;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAvater() {
        return avater;
    }
}
