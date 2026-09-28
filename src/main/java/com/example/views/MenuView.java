package com.example.views;

public class MenuView {
    public String showMenuAndGetChoice() {
        ConsoleView console = new ConsoleView();
        console.print("-------------------------");
        console.print("1. Dolgozók lekérdezése");
        console.print("2. Új dolgozó");
        console.print("3. Dolgozó módosítása");
        console.print("4. Dolgozók törlése");
        console.print("5. Kilépés");
        return console.input("Választás: ");
    }
}
