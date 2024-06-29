package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {
    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testBoardInitialization() {
        board.print(); // just for visual confirmation
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    public void testPlaceMarker() {
        assertTrue(board.place(0, 0, 'X'));
        assertFalse(board.isCellEmpty(0, 0));
        assertFalse(board.place(0, 0, 'O'));
    }

    @Test
    public void testBoardIsFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    public void testClearBoard() {
        board.place(0, 0, 'X');
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    public void testHasWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerColumn() {
        board.place(0, 0, 'X');
        board.place(1, 0, 'X');
        board.place(2, 0, 'X');
        assertTrue(board.hasWinner());
    }

    @Test
    public void testHasWinnerDiagonal() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(board.hasWinner());
    }

    @Test
    public void testCheckWin() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
    }

    @Test
    public void testCheckWinColumn() {
        board.place(0, 0, 'X');
        board.place(1, 0, 'X');
        board.place(2, 0, 'X');
        assertTrue(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
    }

    @Test
    public void testCheckWinDiagonal() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(board.checkWin('X'));
        assertFalse(board.checkWin('O'));
    }

    @Test
    public void testNoWinner() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(1, 0, 'O');
        assertFalse(board.hasWinner());
    }
}
