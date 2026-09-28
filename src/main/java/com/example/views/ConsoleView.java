package com.example.views;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in, "852");
    }

    public String input(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
    }
    public void print(String msg) {
        System.out.println(msg);
    }

    
}
