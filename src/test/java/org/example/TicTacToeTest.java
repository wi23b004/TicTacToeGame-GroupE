package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
        assertNotEquals(initialPlayer, game.currentPlayer, "Der aktuelle Spieler sollte gewechselt werden.");
        game.switchCurrentPlayer(); // Switch back to initial player for next test consistency
        assertEquals(initialPlayer, game.currentPlayer, "Der aktuelle Spieler sollte nach dem Wechsel wiederhergestellt werden.");
    }

    @Test
    public void testMakeMoveValid() {
        assertTrue(game.makeMove(0, 0), "Ein gültiger Zug sollte akzeptiert werden.");
    }

    @Test
    public void testMakeMoveInvalid() {
        game.makeMove(0, 0); // Place 'X' at (0, 0)
        assertFalse(game.makeMove(0, 0), "Ein ungültiger Zug sollte abgelehnt werden (Zelle bereits besetzt).");
    }

    @Test
    public void testGameFlowWithValidInput() {
        String input = "0\n0\n0\n1\n1\n1\n0\n2\n2\n2\n";
        provideInput(input);
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte ohne Fehler mit gültigen Eingaben laufen.");
    }

    @Test
    public void testGameFlowWithInvalidInput() {
        String input = "0\n0\n5\n0\na\n0\n1\n1\n1\n0\n2\n2\n2\n";
        provideInput(input);
        assertDoesNotThrow(() -> game.start(), "Das Spiel sollte ungültige Eingaben verarbeiten können.");
    }

    private void provideInput(String data) {
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            game = new TicTacToe();
        } finally {
            System.setIn(stdin);
        }
    }
}
