package org.example;

public class TicTacToe {
    private char[][] spielbrett;

    public TicTacToe(){
        spielbrett = new char[3][3];
        spielbrettHerstellen();
    }

    private void spielbrettHerstellen(){
        for (int zeile = 0; zeile < 3; zeile++) {
            for (int spalte = 0; spalte < 3; spalte++) {
                spielbrett[zeile][spalte] = '-';
            }
        }
    }


}
