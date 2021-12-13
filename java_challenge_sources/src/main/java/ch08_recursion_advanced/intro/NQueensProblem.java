package ch08_recursion_advanced.intro;

import java.util.Optional;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class NQueensProblem
{
    public static void main(final String[] args)
    {
        final Optional<char[][]> optBoard4 = solveNQueens(4);
        optBoard4.ifPresentOrElse(board_4x4 -> {
            printBoard(board_4x4);
        }, () -> System.out.println("No Solution!"));

        final Optional<char[][]> optBoards8 = solveNQueens(8);
        optBoards8.ifPresentOrElse(board_8x8 -> {
            printBoard(board_8x8);
        }, () -> System.out.println("No Solution!"));
    }

    /*
    ---------
    | |Q| | |
    ---------
    | | | |Q|
    ---------
    |Q| | | |
    ---------
    | | |Q| |
    ---------
     */

    static Optional<char[][]> solveNQueens(final int size)
    {
        final char[][] board = initializeBoard(size);

        if (solveNQueens(board, 0))
            return Optional.of(board);

        return Optional.empty();
    }

    static boolean solveNQueens(final char[][] board, final int row)
    {
        final int maxRow = board.length;
        final int maxCol = board[0].length;

        if (row >= maxRow)
        {
            return true;
        }

        boolean solved = false;
        for (int col = 0; col < maxCol; col++)
        {
            if (isValidPosition(board, col, row))
            {
                placeQueen(board, col, row);

                // recursive descent
                solved = solveNQueens(board, row + 1);

                // backtracking, if no solution
                if (!solved)
                {
                    removeQueen(board, col, row);
                }
                else
                {
                    break;
                }
            }
        }

        return solved;
    }

    private static void placeQueen(final char[][] board, final int col, final int row)
    {
        board[row][col] = 'Q';
    }

    private static void removeQueen(final char[][] board, final int col, final int row)
    {
        board[row][col] = ' ';
    }

    private static char[][] initializeBoard(final int size)
    {
        final char[][] board = new char[size][size];

        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                board[row][col] = ' ';
            }
        }
        return board;
    }

    private static boolean isValidPosition(final char[][] board, final int col, final int row)
    {
        final int maxY = board.length;
        final int maxX = board[0].length;

        final boolean xfree = checkHorizontally(board, row, maxX);
        final boolean yfree = checkVertically(board, col, maxY);

        // checkDiagonally() -- Trick: We don't have to check down, just check up!!!
        final boolean diagLUfree = checkDiagonallyLO(board, col, row);
        final boolean diagRUfree = checkDiagonallyRO(board, col, row, maxX);

        return xfree && yfree && diagRUfree && diagLUfree;
    }

    private static boolean checkHorizontally(final char[][] board, final int row, final int maxX)
    {
        boolean xfree = true;
        for (int x = 0; x < maxX; x++)
        {
            xfree = xfree && board[row][x] == ' ';
        }
        return xfree;
    }

    private static boolean checkVertically(final char[][] board, final int col, final int maxY)
    {
        boolean yfree = true;
        for (int y = 0; y < maxY; y++)
        {
            yfree = yfree && board[y][col] == ' ';
        }
        return yfree;
    }

    private static boolean checkDiagonallyRO(final char[][] board, final int col, final int row, final int maxX)
    {
        // Variant with while
        int x = col;
        int y = row;
        boolean diagRUfree = true;
        while (x < maxX && y >= 0)
        {
            diagRUfree = diagRUfree && board[y][x] == ' ';
            y--;
            x++;
        }
        return diagRUfree;

    }

    private static boolean checkDiagonallyLO(final char[][] board, final int col, final int row)
    {
        // check, since we are the last line is one of the few places where a double variable assignment
        // in a for-loop can be used properly, if necessary while clearer
        boolean diagLUfree = true;
        for (int y = row, x = col; y >= 0 && x >= 0; y--, x--)
        {
            diagLUfree = diagLUfree && board[y][x] == ' ';
        }
        return diagLUfree;
    }

    public static void printBoard(final char[][] values)
    {
        final String line = "-".repeat(values[0].length * 2 + 2);
        System.out.println(line);
        for (int y = 0; y < values.length; y++)
        {
            System.out.print("|");
            for (int x = 0; x < values[y].length; x++)
            {
                final Object value = values[y][x];
                System.out.print(value + "|");
            }
            System.out.println();
            System.out.println(line);
        }
    }
}
