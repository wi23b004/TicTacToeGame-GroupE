package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void testGetMarker_Positive() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testGetMarker_Negative() {
        Player player = new Player('X');
        assertNotEquals('O', player.getMarker());
    }
}