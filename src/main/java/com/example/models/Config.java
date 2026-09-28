package com.example.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public Properties read() {
        try {
            return tryRead();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    private Properties tryRead() throws IOException {
        String fileName = "bamav.config";
        InputStream inputStream = new FileInputStream(fileName);
        Properties config = new Properties();
        config.load(inputStream);
        return config;
    }
}
