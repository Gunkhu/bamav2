package com.example;

import com.example.controllers.MainController;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dolgozók...");

        MainController main = new MainController();
        main.start();
    }
}