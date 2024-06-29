package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    public void setUp() {
        game = new TicTacToe();
    }

    @Test
    public void testSwitchCurrentPlayer() {
        Player initialPlayer = game.currentPlayer;
        game.switchCurrentPlayer();
        assertNotEquals(initialPlayer, game.currentPlayer);
        game.switchCurrentPlayer();
        assertEquals(initialPlayer, game.currentPlayer);
    }

    @Test
    public void testMakeMove_Positive() {
        assertTrue(game.makeMove(0, 0));
    }

    @Test
    public void testMakeMove_Negative() {
        game.makeMove(0, 0);
        assertFalse(game.makeMove(0, 0));
    }

    @Test
    public void testStartGame_WithWinner() {
        String input = "0\n0\n1\n0\n2\n0\n";
        simulateInput(input);
        game.startGame();
        assertTrue(game.board.checkWinner());
    }

    @Test
    public void testStartGame_WithDraw() {
        String input = "0\n0\n0\n1\n0\n2\n1\n1\n1\n0\n2\n2\n2\n1\n2\n0\n";
        simulateInput(input);
        game.startGame();
        assertTrue(game.board.isFull());
    }

    private void simulateInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
