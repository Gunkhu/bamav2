package com.example.models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties{
    private final String fileName = "bamav.config";
    public Config(){
        read();
    }
    private void read() {
        try {
            tryRead();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private void tryRead() throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
    }
}
