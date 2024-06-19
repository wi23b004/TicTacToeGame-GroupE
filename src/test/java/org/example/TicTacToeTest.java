package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {

    @Test
    public void testSpielfeldHerstellen() {
        TicTacToe spiel = new TicTacToe();
        char[][] erwartetesSpielfeld = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        assertArrayEquals(erwartetesSpielfeld, spiel.getSpielfeld());
    }

}
