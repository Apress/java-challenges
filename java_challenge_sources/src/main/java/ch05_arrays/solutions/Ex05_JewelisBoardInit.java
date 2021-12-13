package ch05_arrays.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_JewelisBoardInit
{
    public static void main(final String[] args)
    {
        final int[][] board = initJewelsBoard(8, 8, 4);
        ArrayUtils.printArray(board);
        System.out.println("Valid? " + checkBoardValidity(board));

        final int[][] board2 = { { 2, 3, 8, 4, 4, 3, 2 }, { 1, 3, 3, 1, 3, 4, 4 }, { 3, 1, 4, 5, 3, 1, 3 },
                                 { 2, 2, 6, 1, 2, 3, 2 }, { 3, 2, 4, 4, 3, 3, 4 } };
        ArrayUtils.printArray(board2);
        System.out.println("Checking: " + checkBoardValidity(board2));
    }

    static int[][] initJewelsBoard(final int width, final int height, final int numOfColors)
    {
        final int[][] board = new int[height][width];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                board[y][x] = selectValidJewel(board, x, y, numOfColors);
            }
        }

        return board;
    }

    private static boolean checkBoardValidity(final int[][] board)
    {
        for (int y = 0; y < board.length; y++)
        {
            for (int x = 0; x < board[0].length; x++)
            {
                final int currentJewel = board[y][x];

                final boolean invalidHor = checkHorizontally(board, x, y, currentJewel);
                final boolean invalidVer = checkVertically(board, x, y, currentJewel);
                final boolean invalidDia = checkDiagonally(board, x, y, currentJewel);

                if (invalidHor || invalidVer || invalidDia)
                {
                    System.out.format("Invalid at x=%d y=%d hor=%b, ver=%b, dia=%b", x, y, invalidHor, invalidVer,
                                      invalidDia);
                    return false;
                }

            }
        }

        return true;
    }

    private static int selectValidJewel(final int[][] board, final int x, final int y, final int numOfColors)
    {
        int nextJewelNr = -1;

        boolean isValid = false;

        while (!isValid)
        {
            nextJewelNr = 1 + (int) (Math.random() * numOfColors);

            isValid = !checkHorizontally(board, x, y, nextJewelNr) && !checkVertically(board, x, y, nextJewelNr) &&
                            // Bonus
                            !checkDiagonally(board, x, y, nextJewelNr);
        }

        return nextJewelNr;
    }

    static boolean checkVertically(final int[][] board, final int x, final int y, final int jewelNr)
    {
        final int left1 = getAt(board, x - 1, y);
        final int left2 = getAt(board, x - 2, y);

        return left1 == jewelNr && left2 == jewelNr;
    }

    static boolean checkHorizontally(final int[][] board, final int x, final int y, final int jewelNr)
    {
        final int top1 = getAt(board, x, y - 1);
        final int top2 = getAt(board, x, y - 2);

        return top1 == jewelNr && top2 == jewelNr;
    }

    static boolean checkDiagonally(final int[][] board, final int x, final int y, final int jewelNr)
    {
        final int nw1 = getAt(board, x - 1, y - 1);
        final int nw2 = getAt(board, x - 2, y - 2);

        final int ne1 = getAt(board, x + 1, y - 1);
        final int ne2 = getAt(board, x + 2, y - 2);

        return nw1 == jewelNr && nw2 == jewelNr || ne1 == jewelNr && ne2 == jewelNr;
    }

    // -1 as indicator for off board
    static int getAt(final int[][] board, final int x, final int y)
    {
        if (x < 0 || x >= board[0].length || y < 0 || y >= board.length)
            return -1;

        return board[y][x];
    }
}
