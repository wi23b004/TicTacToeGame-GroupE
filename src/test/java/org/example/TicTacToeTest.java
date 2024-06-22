package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testBrettHerstellen() {
        TicTacToe spiel = new TicTacToe();
        char[][] erwartetesBrett = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(erwartetesBrett, spiel.getSpielBrett());
    }

    @Test
    public void testSpielBrettAnzeigen() {
        TicTacToe spiel = new TicTacToe();
        assertDoesNotThrow(() -> spiel.spielbrettAnzeigen());
    }

    @Test
    public void testZugMachenGueltigePosition() {
        TicTacToe spiel = new TicTacToe();
        boolean ergebnis = spiel.zugMachen(1,1,'x');
        assertTrue(ergebnis);
        assertEquals('X', spiel.getSpielBrett()[1][1]);
    }

    @Test
    public void testZugMachenUngueltigePosition() {
        TicTacToe spiel = new TicTacToe();
        boolean ergebnis = spiel.zugMachen(3,7,'x');
        assertFalse(ergebnis);
    }
}



