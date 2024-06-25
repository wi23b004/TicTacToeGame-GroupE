package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '-';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = '-';
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWin(char marker) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker) {
                return true;
            }
        }
        // Check diagonals
        if (cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) {
            return true;
        }
        if (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker) {
            return true;
        }
        return false;
    }
}
