package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        board.clear();
        board.print();
        while (!board.hasWinner() && !board.isFull()) {
            // Handle player moves (omitted for brevity)
            switchCurrentPlayer();
        }
        if (board.hasWinner()) {
            System.out.println("Player " + currentPlayer.getMarker() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
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
}