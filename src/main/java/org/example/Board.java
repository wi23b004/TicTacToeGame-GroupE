package org.example;
import java.util.Arrays;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '-';
    }




    //Überprüfung des Gewinners

    public boolean checkWinner() {
        // Überprüfung der Reihen im Spiel
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != '-') {
                return true;
            }
        }
        // Überprüfung der Spalten im Spiel
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][i] != '-') {
                return true;
            }
        }
        // Überprüfung der Diagonalen
        if (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2] && cells[0][0] != '-') {
            return true;
        }
        if (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0] && cells[0][2] != '-') {
            return true;
        }
        return false;
    }

    public void clear () {
        for (int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                cells[x][y] = '-';
            }
        }
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
            return true;
        }
        return false;
    }


}