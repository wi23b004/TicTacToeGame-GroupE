package org.example;

public class TicTacToe {
    private char[][] spielbrett; // Das Spielfeld für das TicTacToe-Spiel

    public TicTacToe() {
        spielbrett = new char[3][3]; // Initialisiert ein 3x3 Spielfeld
        spielbrettHerstellen(); // Initialisiert ein 3x3 Spielfeld
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

}
