package com.example.store.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppUser {

    private String username;
    private String email;
    private String password;
    public AppUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                '}';
    }
}
