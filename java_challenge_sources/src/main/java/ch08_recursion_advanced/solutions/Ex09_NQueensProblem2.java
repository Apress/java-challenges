package ch08_recursion_advanced.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_NQueensProblem2
{
    private Ex09_NQueensProblem2()
    {
    }

    public static void main(final String[] args)
    {
        solveAndPrint(4);
        solveAndPrint(8);
    }

    private static void solveAndPrint(final int size)
    {
        final List<Integer> board = solveNQueens(size);
        if (board.isEmpty())
            System.out.println("No Solution!");
        else
            printBoard(board, size);
    }

    //
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

    static List<Integer> solveNQueens(final int size)
    {
        final List<Integer> board = new ArrayList<>();

        if (solveNQueens(board, 0, size))
            return board;

        return List.of();
    }

    static boolean solveNQueens(final List<Integer> board, final int row, final int size)
    {
        if (row >= size)
            return true;

        boolean solved = false;
        int col = 0;
        while (!solved && col < size)
        {
            if (isValidPosition(board, col, row, size))
            {
                placeQueen(board, col, row);

                // recursive descent
                solved = solveNQueens(board, row + 1, size);

                // Backtracking, if no solution
                if (!solved)
                    removeQueen(board, col, row);
            }
            col++;
        }

        return solved;
    }

    static void placeQueen(final List<Integer> board, final int col, final int row)
    {
        if (board.size() != row)
            throw new IllegalStateException("invalid row");

        board.add(col);
    }

    static void removeQueen(final List<Integer> board, final int col, final int row)
    {
        if (board.get(row) != col)
            throw new IllegalStateException("invalid col");

        board.remove(row);
    }

    static boolean isValidPosition(final List<Integer> board,
                                   final int col, final int row,
                                   final int size)
    {
        final boolean xfree = true; // ist ja neue Zeile
        final boolean yfree = !board.contains(col);
        final boolean diagfree = checkDiagonally(board, col, row, size);

        return xfree && yfree && diagfree;
    }

    static boolean checkDiagonally(final List<Integer> board,
                                   final int col, final int row,
                                   final int size)
    {
        boolean diagLUfree = true;
        boolean diagRUfree = true;

        for (int y = 0; y < row; y++)
        {
            final int xPosLU = col - (row - y);
            final int xPosRU = col + row - y;

            if (xPosLU >= 0)
                diagLUfree = diagLUfree && board.get(y) != xPosLU;

            if (xPosRU < size)
                diagRUfree = diagRUfree && board.get(y) != xPosRU;
        }

        return diagRUfree && diagLUfree;
    }

    static void printBoard(final List<Integer> board,
                           final int size)
    {
        final String line = "-".repeat(size * 2 + 1);
        System.out.println(line);
        for (int y = 0; y < size; y++)
        {
            System.out.print("|");
            for (int x = 0; x < size; x++)
            {
                Object value = ' ';
                if (x == board.get(y))
                    value = 'Q';

                System.out.print(value + "|");
            }
            System.out.println("\n" + line);
        }
    }
}
