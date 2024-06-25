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

}
