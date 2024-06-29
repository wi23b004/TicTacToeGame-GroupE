package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void testPlayerInitialization() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    @Test
    public void testPlayerInitializationWithDifferentMarker() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }

    @Test
    public void testPlayerMarkerIsNotEmpty() {
        Player player = new Player('X');
        assertNotEquals('\0', player.getMarker());
    }
}
