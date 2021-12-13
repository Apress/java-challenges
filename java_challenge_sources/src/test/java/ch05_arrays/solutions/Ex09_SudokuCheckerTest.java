package ch05_arrays.solutions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_SudokuCheckerTest
{
    @Test
    void isSudokuValid()
    {
        final int[][] board = createInitializedBoard();

        final boolean validSudoku = Ex09_SudokuChecker.isSudokuValid(board);

        assertTrue(validSudoku);
    }

    @Test
    void isSudokuValidForInvalidBoard()
    {
        final int[][] board = createInitializedBoardWithEmptyCells();

        board[0][2] = 2;
        ArrayUtils.printArray(board);

        final boolean validSudoku = Ex09_SudokuChecker.isSudokuValid(board);

        assertFalse(validSudoku);
    }

    @Test
    void isSudokuValidForInvalidBoard2()
    {
        final int[][] board = createInitializedBoardWithEmptyCells();

        board[5][0] = 2;
        ArrayUtils.printArray(board);

        final boolean validSudoku = Ex09_SudokuChecker.isSudokuValid(board);

        assertFalse(validSudoku);
    }

    @Test
    void isSudokuValidForInvalidBoard3()
    {
        final int[][] board = createInitializedBoardWithEmptyCells();

        board[0][2] = 6;
        ArrayUtils.printArray(board);

        final boolean validSudoku = Ex09_SudokuChecker.isSudokuValid(board);

        assertFalse(validSudoku);
    }


    @Test
    void isSudokuValidWithEmptyCells()
    {
        final int[][] board = createInitializedBoardWithEmptyCells();

        final boolean validSudoku = Ex09_SudokuChecker.isSudokuValid(board);

        assertTrue(validSudoku);
    }

    @Test
    void isSudokuValidForInvalidBoardWithEmptyCells()
    {
        final int[][] board = createInitializedBoardWithEmptyCells();

        board[0][2] = 2;
        ArrayUtils.printArray(board);

        final boolean validSudoku = Ex09_SudokuChecker.isSudokuValid(board);

        assertFalse(validSudoku);
    }

    private int[][] createInitializedBoardWithEmptyCells()
    {
        final int[][] board = new int[9][9];
        board[0] = new int[] { 1, 2, 0, 4, 5, 0, 7, 8, 9 };
        board[1] = new int[] { 0, 5, 6, 7, 0, 9, 0, 2, 3 };
        board[2] = new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6 };
        board[3] = new int[] { 2, 1, 4, 0, 6, 0, 8, 0, 7 };
        board[4] = new int[] { 3, 6, 0, 8, 9, 7, 2, 1, 4 };
        board[5] = new int[] { 0, 9, 7, 0, 1, 4, 3, 6, 0 };
        board[6] = new int[] { 5, 3, 1, 6, 0, 2, 9, 0, 8 };
        board[7] = new int[] { 6, 0, 2, 9, 7, 8, 5, 3, 1 };
        board[8] = new int[] { 9, 7, 0, 0, 3, 1, 6, 4, 2 };

        return board;
    }

    private int[][] createInitializedBoard()
    {
        final int[][] board = new int[9][9];

        board[0] = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        board[1] = new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
        board[2] = new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        board[3] = new int[] { 2, 1, 4, 3, 6, 5, 8, 9, 7 };
        board[4] = new int[] { 3, 6, 5, 8, 9, 7, 2, 1, 4 };
        board[5] = new int[] { 8, 9, 7, 2, 1, 4, 3, 6, 5 };
        board[6] = new int[] { 5, 3, 1, 6, 4, 2, 9, 7, 8 };
        board[7] = new int[] { 6, 4, 2, 9, 7, 8, 5, 3, 1 };
        board[8] = new int[] { 9, 7, 8, 5, 3, 1, 6, 4, 2 };

        return board;
    }
}