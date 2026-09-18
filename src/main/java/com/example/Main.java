package com.example;

import com.example.models.DataService;
import com.example.models.Employee;
import com.example.models.Sqlite;

public class Main {
    public static void main(String[] args) {
        System.out.println("Dolgozók...");

        DataService ds = new DataService(new Sqlite());
        Employee emp = new Employee(
            "Buga Jakab", 
            "Kalocsa",
            392);
        ds.insertEmployee(emp);
    }
}