package org.example;

public class TicTacToe {
    private char[][] spielbrett; // Das Spielfeld für das TicTacToe-Spiel

    public TicTacToe() {
        spielbrett = new char[3][3]; // Initialisiert ein 3x3 Spielfeld
        spielbrettHerstellen();
    }

    public char[][] getSpielBrett() {
        return spielbrett;
    }

    // Methode zum Initialisieren des Spielfeldes
    private void spielbrettHerstellen() {
        for (int zeile = 0; zeile < 3; zeile++) {
            for (int spalte = 0; spalte < 3; spalte++) {
                spielbrett[zeile][spalte] = '-';
            }
        }
    }

    // Setzt jedes Feld auf '-'
    public void spielbrettAnzeigen() {
        for (int zeile = 0; zeile < 3; zeile++) {
            for (int spalte = 0; spalte < 3; spalte++) {
                System.out.print(spielbrett[zeile][spalte] + " "); // Druckt jedes Feld mit einem Leerzeichen dazwischen
            }
            System.out.println(); // Neue Zeile nach jeder Reihe
        }
        System.out.println(); // Zusätzliche Leerzeile für bessere Lesbarkeit
    }

    public boolean zugMachen(int zeile, int spalte, char symbol){
        // Prüfe ob die Position im Spielbrett ist
        if (zeile < 0 || zeile > 2 || spalte < 0 || spalte > 2) {
            System.out.println("Position außerhalb des Spielbretts");
            return false; // Position nicht im Spielbrett
        }

        // Symbol in Groß umwandeln
        symbol = Character.toUpperCase(symbol);

        // Prüfen ob das Symbol gültig ist
        if (symbol != 'X' && symbol != 'O') {
            System.out.println("Ungültiges Symbol eingegeben! Nur X oder O sind erlaubt.");
            return false; // Ungültiges Symbol
        }

        // Prüfen ob das Feld frei ist
        if (spielbrett[zeile][spalte] == '-') {
            // Wenn Feld frei --> Symbol setzen
            spielbrett[zeile][spalte] = symbol;
            return true; // Zug erfolgreich
        } else {
            // Feld nicht frei
            return false; // Zug nicht erfolgreich
        }
    }

    // Neue Methode zum Starten eines neuen Spiels
    public void neuesSpielstarten() {
        System.out.println("Neues Spiel wird gestartet....");
        spielbrettHerstellen();
        spielbrettAnzeigen();
    }

    // Methode, um zu prüfen, ob das Spiel zu Ende ist
    public boolean istSpielzuEnde(){
        // Diese Methode sollte das Spielende prüfen, aber wir lassen sie hier einfach false zurückgeben
        return false;
    }

    // Methode zur Anzeige des aktuellen Spielstands hinzufügen
    public void aktuellenStandAnzeigen() {
        System.out.println("Aktueller Spielstand:");
        for (int zeile = 0; zeile < 3; zeile++) {
            for (int spalte = 0; spalte < 3; spalte++) {
                System.out.print(spielbrett[zeile][spalte] + " ");
            }
            System.out.println(); // Zeilenumbruch nach jeder Zeile
        }
        System.out.println();
    }
}
