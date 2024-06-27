package org.example;

import org.example.Player;
import org.example.TicTacToe;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    // Mocking user input for testing
    private void provideInput(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    @Test
    @DisplayName("Test start method with valid moves")
    void testStartValidMoves() {
        TicTacToe game = new TicTacToe();

        // Mock input for player moves (valid sequence)
        provideInput("0\n0\n1\n1\n0\n1\n2\n2\n");

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.start();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Das Spiel endet unentschieden!"));
    }

    @Test
    @DisplayName("Test start method with invalid moves")
    void testStartInvalidMoves() {
        TicTacToe game = new TicTacToe();

        // Mock input for player moves (some invalid moves included)
        provideInput("0\n0\n0\n0\n1\n1\n1\n1\n");

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.start();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Ungültiger Zug. Versuchen Sie es erneut."));
        assertTrue(consoleOutput.contains("Das Spiel endet unentschieden!"));
    }

    @Test
    @DisplayName("Test startNewGame method")
    void testStartNewGame() {
        TicTacToe game = new TicTacToe();

        // Mock input for player moves
        provideInput("0\n0\n1\n1\n2\n2\n");

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run two games
        game.start();
        game.startNewGame();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Starting a new game..."));
    }

    @Test
    @DisplayName("Test makeMove method with valid move")
    void testMakeMoveValid() {
        TicTacToe game = new TicTacToe();

        assertTrue(game.makeMove(0, 0));
    }

    @Test
    @DisplayName("Test makeMove method with invalid move")
    void testMakeMoveInvalid() {
        TicTacToe game = new TicTacToe();

        game.makeMove(0, 0); // make a valid move first

        assertFalse(game.makeMove(0, 0));
    }

    @Test
    @DisplayName("Test switchCurrentPlayer method")
    void testSwitchCurrentPlayer() {
        TicTacToe game = new TicTacToe();
        Player initialPlayer = game.currentPlayer;

        game.switchCurrentPlayer();
        Player newPlayer = game.currentPlayer;

        assertNotEquals(initialPlayer, newPlayer);
    }

    @Test
    @DisplayName("Test displayGameState method")
    void testDisplayGameState() {
        TicTacToe game = new TicTacToe();

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.displayGameState();

        String consoleOutput = outputStream.toString();
        assertTrue(consoleOutput.contains("Aktueller Spielstand:"));
    }
}
