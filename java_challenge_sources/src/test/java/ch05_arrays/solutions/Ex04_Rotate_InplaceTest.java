package ch05_arrays.solutions;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_Rotate_InplaceTest
{
    @Test
    void rotateInplace()
    {
        final Character[][] board = { { '1', '2', '3', '4', '5', '6' }, { 'J', 'K', 'L', 'M', 'N', '7' },
                                      { 'I', 'V', 'W', 'X', 'O', '8' }, { 'H', 'U', 'Z', 'Y', 'P', '9' },
                                      { 'G', 'T', 'S', 'R', 'Q', '0' }, { 'F', 'E', 'D', 'C', 'B', 'A' } };

        // works inplace
        Ex04_Rotate_Inplace.rotateInplace(board);

        final Character[][] expectedBoard = { { 'F', 'G', 'H', 'I', 'J', '1' }, { 'E', 'T', 'U', 'V', 'K', '2' },
                                              { 'D', 'S', 'Z', 'W', 'L', '3' }, { 'C', 'R', 'Y', 'X', 'M', '4' },
                                              { 'B', 'Q', 'P', 'O', 'N', '5' }, { 'A', '0', '9', '8', '7', '6' } };

        assertArrayEquals(expectedBoard, board);
    }

    @Test
    void rotateInplaceRecursive()
    {
        final Character[][] board = { { '1', '2', '3', '4', '5', '6' }, { 'J', 'K', 'L', 'M', 'N', '7' },
                                      { 'I', 'V', 'W', 'X', 'O', '8' }, { 'H', 'U', 'Z', 'Y', 'P', '9' },
                                      { 'G', 'T', 'S', 'R', 'Q', '0' }, { 'F', 'E', 'D', 'C', 'B', 'A' } };

        // works inplace
        Ex04_Rotate_Inplace.rotateInplaceRecursive(board);

        final Character[][] expectedBoard = { { 'F', 'G', 'H', 'I', 'J', '1' }, { 'E', 'T', 'U', 'V', 'K', '2' },
                                              { 'D', 'S', 'Z', 'W', 'L', '3' }, { 'C', 'R', 'Y', 'X', 'M', '4' },
                                              { 'B', 'Q', 'P', 'O', 'N', '5' }, { 'A', '0', '9', '8', '7', '6' } };

        assertArrayEquals(expectedBoard, board);
    }

    @Test
    void rotateInplaceV2()
    {
        final Character[][] board = { { '1', '2', '3', '4', '5', '6' }, { 'J', 'K', 'L', 'M', 'N', '7' },
                                      { 'I', 'V', 'W', 'X', 'O', '8' }, { 'H', 'U', 'Z', 'Y', 'P', '9' },
                                      { 'G', 'T', 'S', 'R', 'Q', '0' }, { 'F', 'E', 'D', 'C', 'B', 'A' } };

        // works inplace
        Ex04_Rotate_Inplace.rotateInplaceV2(board);

        final Character[][] expectedBoard = { { 'F', 'G', 'H', 'I', 'J', '1' }, { 'E', 'T', 'U', 'V', 'K', '2' },
                                              { 'D', 'S', 'Z', 'W', 'L', '3' }, { 'C', 'R', 'Y', 'X', 'M', '4' },
                                              { 'B', 'Q', 'P', 'O', 'N', '5' }, { 'A', '0', '9', '8', '7', '6' } };

        assertArrayEquals(expectedBoard, board);
    }
}