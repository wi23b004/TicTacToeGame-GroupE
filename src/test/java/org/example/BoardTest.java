package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testIsCellEmpty_Positive() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsCellEmpty_Negative() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    public void testCheckWinner_Positive_Row() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(board.checkWinner());
    }

    @Test
    public void testCheckWinner_Positive_Column() {
        board.place(0, 0, 'O');
        board.place(1, 0, 'O');
        board.place(2, 0, 'O');
        assertTrue(board.checkWinner());
    }

    @Test
    public void testCheckWinner_Positive_Diagonal() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(board.checkWinner());
    }

    @Test
    public void testCheckWinner_Negative() {
        assertFalse(board.checkWinner());
        board.place(0, 0, 'X');
        assertFalse(board.checkWinner());
    }

    @Test
    public void testClear() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    public void testIsFull_Positive() {
        fillBoard();
        assertTrue(board.isFull());
    }

    @Test
    public void testIsFull_Negative() {
        assertFalse(board.isFull());
        board.place(0, 0, 'X');
        assertFalse(board.isFull());
    }

    @Test
    public void testPlace_Positive() {
        assertTrue(board.place(0, 0, 'X'));
    }

    @Test
    public void testPlace_Negative() {
        board.place(0, 0, 'X');
        assertFalse(board.place(0, 0, 'O'));
    }

    private void fillBoard() {
        char[] markers = {'X', 'O'};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, markers[(i + j) % 2]);
            }
        }
    }
}
