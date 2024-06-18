package org.example;

public class TicTacToe {
    private char[][] spielbrett;// Das Spielfeld für das TicTacToe-Spiel

    public TicTacToe(){
        spielbrett = new char[3][3]; // Initialisiert ein 3x3 Spielfeld
        spielbrettHerstellen(); // Initialisiert ein 3x3 Spielfeld
    }
    // Methode zum Initialisieren des Spielfeldes
    private void spielbrettHerstellen(){
        for (int zeile = 0; zeile < 3; zeile++) {
            for (int spalte = 0; spalte < 3; spalte++) {
                spielbrett[zeile][spalte] = '-';
            }
        }
    }
    // Setzt jedes Feld auf '-'
    public void spielbrettAnzeigen(){
        for (int zeile = 0; zeile < 3; zeile++) {
            for (int spalte = 0; spalte < 3; spalte++) {
                System.out.print(spielbrett[zeile][spalte]+" "); // Druckt jedes Feld mit einem Leerzeichen dazwischen
            }
            System.out.println();// Neue Zeile nach jeder Reihe
        }
        System.out.println(); // Zusätzliche Leerzeile für bessere Lesbarkeit
    }


}
