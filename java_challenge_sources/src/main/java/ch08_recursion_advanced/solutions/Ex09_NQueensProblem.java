package ch08_recursion_advanced.solutions;

import java.util.Optional;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_NQueensProblem
{
    private Ex09_NQueensProblem()
    {
    }

    public static void main(final String[] args)
    {
        solveAndPrint(4);
        solveAndPrint(8);

        final Optional<char[][]> optBoards16 = solveNQueens(16);
        optBoards16.ifPresentOrElse(board_16x16 -> printBoard(board_16x16), () -> System.out.println("No Solution!"));
    }

    private static void solveAndPrint(final int size)
    {
        final Optional<char[][]> optBoards = solveNQueens(size);

        optBoards.ifPresentOrElse(board -> printBoard(board), () -> System.out.println("No Solution!"));
    }

    static Optional<char[][]> solveNQueens(final int size)
    {
        final char[][] board = initializeBoard(size);

        if (solveNQueens(board, 0))
            return Optional.of(board);

        return Optional.empty();
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

    static boolean solveNQueens(final char[][] board, final int row)
    {
        final int maxRow = board.length;
        final int maxCol = board[0].length;

        if (row >= maxRow)
            return true;

        boolean solved = false;
        int col = 0;
        while (!solved && col < maxCol)
        {
            if (isValidPosition(board, col, row))
            {
                placeQueen(board, col, row);

                // recursive descent
                solved = solveNQueens(board, row + 1);

                // Backtracking, if no solution
                if (!solved)
                    removeQueen(board, col, row);
            }
            col++;
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

    static boolean isValidPosition(final char[][] board, final int col, final int row)
    {
        final int maxRow = board.length;
        final int maxCol = board[0].length;

        return checkHorizontally(board, row, maxCol) &&
        // is actually NOT needed, since we are just checking the new line 
        // but for general testing of a board it makes sense
                        checkVertically(board, col, maxRow) && checkDiagonallyLO(board, col, row)
                        && checkDiagonallyRO(board, col, row, maxCol);
    }

    private static boolean checkHorizontally(final char[][] board, final int row, final int maxX)
    {
        int x = 0;
        while (x < maxX && board[row][x] == ' ')
            x++;
        return x >= maxX;
    }

    private static boolean checkVertically(final char[][] board, final int col, final int maxY)
    {
        int y = 0;
        while (y < maxY && board[y][col] == ' ')
            y++;
        return y >= maxY;
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
        boolean diagLUfree = true;
        for (int y = row, x = col; y >= 0 && x >= 0; y--, x--)
        {
            diagLUfree = diagLUfree && board[y][x] == ' ';
        }
        return diagLUfree;
    }

    public static void printBoard(final char[][] values)
    {
        final String line = "-".repeat(values[0].length * 2 + 1);
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
