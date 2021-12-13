package ch05_arrays.solutions;

import static org.junit.Assert.assertArrayEquals;
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
public class EX06_JewelsEraseDiamondsTest
{
    @Test
    void eraseChains()
    {
        final int[][] board = { { 1, 1, 1, 2, 4, 4, 3 },
                                { 1, 1, 3, 4, 2, 4, 3 },
                                { 1, 3, 1, 1, 2, 2, 3 } };

        // arbeitet inplace
        final boolean deleted = EX06_JewelsEraseDiamonds.eraseChains(board);

        final int[][] expectedBoard = { { 0, 0, 0, 0, 4, 4, 0 },
                                        { 0, 0, 3, 4, 0, 4, 0 },
                                        { 0, 3, 0, 1, 2, 0, 0 } };

        assertTrue(deleted);
        assertArrayEquals(expectedBoard, board);
    }

    @Test
    void eraseChainsOtherBoard()
    {
        final int[][] board =  { { 1, 1, 3, 3, 4, 5 },
                                 { 1, 1, 0, 0, 4, 5 },
                                 { 1, 2, 3, 3, 4, 5 },
                                 { 1, 2, 0, 3, 3, 4 },
                                 { 1, 2, 3, 4, 4, 4 } };

        // works inplace
        final boolean deleted = EX06_JewelsEraseDiamonds.eraseChains(board);

        final int[][] expectedBoard = { { 0, 1, 3, 3, 0, 0 },
                                        { 0, 1, 0, 0, 0, 0 },
                                        { 0, 0, 3, 3, 0, 0 },
                                        { 0, 0, 0, 3, 3, 4 },
                                        { 0, 0, 3, 0, 0, 0 } };

        assertTrue(deleted);
        assertArrayEquals(expectedBoard, board);
    }

    @Test
    void fallDown()
    {
        final int[][] board = { { 0, 1, 3, 3, 0, 0 },
                                { 0, 1, 0, 0, 0, 0 },
                                { 0, 0, 3, 3, 0, 0 },
                                { 0, 0, 0, 3, 3, 4 },
                                { 0, 0, 3, 0, 0, 0 } };

        EX06_JewelsEraseDiamonds.fallDown(board);

        final int[][] expectedBoard = { { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 0, 0, 0, 0 },
                                        { 0, 0, 3, 3, 0, 0 },
                                        { 0, 1, 3, 3, 0, 0 },
                                        { 0, 1, 3, 3, 3, 4 } };

        assertArrayEquals(expectedBoard, board);
    }

    // --------------------------------------------------

    @Test
    void eraseChainsCharBoard()
    {
        final char[][] board =  { "AACCDE".toCharArray(),
                                  "AA  DE".toCharArray(),
                                  "ABCCDE".toCharArray(),
                                  "AB CCD".toCharArray(),
                                  "ABCDDD".toCharArray() };

        // works inplace
        final boolean deleted = EX06_JewelsEraseDiamonds.eraseChains(board);
        ArrayUtils.printArray(board);
        final char[][] expectedBoard = { " ACC  ".toCharArray(),
                                         " A    ".toCharArray(),
                                         "  CC  ".toCharArray(),
                                         "   CCD".toCharArray(),
                                         "  C   ".toCharArray() };

        assertTrue(deleted);
        assertArrayEquals(expectedBoard, board);
    }

    @Test
    void fallDownWithChars()
    {
        final char[][] board = { "123_13".toCharArray(),
                                 "___2_4".toCharArray(),
                                 "234___".toCharArray(), };

        final char[][] result = EX06_JewelsEraseDiamonds.fallDown(board);

        final char[][] expectedBoard = { "______".toCharArray(),
                                         "123__3".toCharArray(),
                                         "234214".toCharArray(), };

        assertArrayEquals(expectedBoard, result);
    }

}
