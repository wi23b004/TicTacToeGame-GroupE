package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        board.print();
        Scanner scanner = new Scanner(System.in);
        while (!board.hasWinner() && !board.isFull()) {
            System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");
            System.out.print("Geben Sie die Zeile (0-2) ein: ");
            int row = scanner.nextInt();
            System.out.print("Geben Sie die Spalte (0-2) ein: ");
            int col = scanner.nextInt();
            if (makeMove(row, col)) {
                if (board.hasWinner()) {
                    System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                    return;
                } else if (board.isFull()) {
                    System.out.println("Das Spiel endet unentschieden!");
                    return;
                }
                switchCurrentPlayer();
            } else {
                System.out.println("Ungültiger Zug. Versuchen Sie es erneut.");
            }
        }
        scanner.close();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void startNewGame() {
        System.out.println("Starting a new game...");
        start();
    }

    public boolean hasWinner() {
        return board.checkWin(currentPlayer.getMarker());
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

    public void displayGameState() {
        System.out.println("Aktueller Spielstand:");
        board.print();
    }
}