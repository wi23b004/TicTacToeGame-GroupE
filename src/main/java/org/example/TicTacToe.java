package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void startGame() {
        board.clear();
        board.print();
        Scanner scanner = new Scanner(System.in);
        while (!board.checkWinner() && !board.isFull()) {
            System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");

            int row = -1;
            int col = -1;

            // Eingabe für die Zeile validieren
            while (row < 0 || row > 2) {
                System.out.print("Geben Sie die Zeile (0-2) ein: ");
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    if (row < 0 || row > 2) {
                        System.out.println("Ungültige Zeile. Bitte geben Sie eine Zahl zwischen 0 und 2 ein.");
                    }
                } else {
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 0 und 2 ein.");
                    scanner.next(); // Ungültige Eingabe verwerfen
                }
            }

            // Eingabe für die Spalte validieren
            while (col < 0 || col > 2) {
                System.out.print("Geben Sie die Spalte (0-2) ein: ");
                if (scanner.hasNextInt()) {
                    col = scanner.nextInt();
                    if (col < 0 || col > 2) {
                        System.out.println("Ungültige Spalte. Bitte geben Sie eine Zahl zwischen 0 und 2 ein.");
                    }
                } else {
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl zwischen 0 und 2 ein.");
                    scanner.next(); // Ungültige Eingabe verwerfen
                }
            }

            if (makeMove(row, col)) {
                if (board.checkWinner()) {
                    System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                } else if (board.isFull()) {
                    System.out.println("Das Spiel endet unentschieden!");
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Ungültiger Zug. Versuchen Sie es erneut.");
            }
        }

        System.out.print("Wollen Sie erneut spielen (ja/nein): ");
        String neuesSpiel = scanner.next();
        if (neuesSpiel.equalsIgnoreCase("ja")) {
            startNewGame();
        }
        scanner.close();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void startNewGame() {
        System.out.println("Starte ein neues Spiel...");
        startGame();
    }
    public boolean makeMove(int x, int y) {
        if (board.place(x, y, currentPlayer.getMarker())) {
            board.print();
            return true;
        } else {
            System.out.println("Zelle ist bereits besetzt. Wähle eine andere Zelle.");
            return false;
        }
    }

}