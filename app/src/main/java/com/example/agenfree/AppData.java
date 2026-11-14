package com.example.agenfree;

// Essa classe serve para compartilhar informações entre as activity
public class AppData {

    private static AppData instance;

    public boolean fakeToken = false;

    private AppData() {}

    public static AppData getInstance(){
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }
}
