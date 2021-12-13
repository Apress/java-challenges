package ch08_recursion_advanced.solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_SudokuSolver
{
    private Ex05_SudokuSolver()
    {
    }

    public static void main(final String[] args)
    {
        final int[][] boardExample = new int[9][9];

        boardExample[0] = new int[] { 1, 2, 0, 4, 5, 0, 7, 8, 9 };
        boardExample[1] = new int[] { 0, 5, 6, 7, 0, 9, 0, 2, 3 };
        boardExample[2] = new int[] { 7, 8, 0, 1, 2, 3, 4, 5, 6 };
        boardExample[3] = new int[] { 2, 1, 4, 0, 6, 0, 8, 0, 7 };
        boardExample[4] = new int[] { 3, 6, 0, 8, 9, 7, 2, 1, 4 };
        boardExample[5] = new int[] { 0, 9, 7, 0, 1, 4, 3, 6, 0 };
        boardExample[6] = new int[] { 5, 3, 1, 6, 0, 2, 9, 0, 8 };
        boardExample[7] = new int[] { 6, 0, 2, 9, 7, 8, 5, 3, 1 };
        boardExample[8] = new int[] { 9, 7, 0, 0, 3, 1, 6, 4, 2 };

        solveAndMeasure(boardExample);

        final int[][] board2 = { { 6, 0, 2, 0, 5, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 4, 0, 3, 0 },
                                 { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 4, 3, 0, 0, 0, 8, 0, 0, 0 },
                                 { 0, 1, 0, 0, 0, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 0, 7, 0, 0 },
                                 { 5, 0, 0, 2, 7, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 8, 1 },
                                 { 0, 0, 0, 6, 0, 0, 0, 0, 0 } };

        solveAndMeasure(board2);
    }

    protected static void solveAndMeasure(final int[][] boardExample)
    {
        final long startMs = System.currentTimeMillis();
        System.out.println("Solving: \n");
        printArray(boardExample);

        if (solveSudoku(boardExample))
        {
            final long endMs = System.currentTimeMillis();

            System.out.println("Solved in " + (endMs - startMs) + " ms");
            printArray(boardExample);
        }
    }

    public static boolean solveSudoku(final int[][] board)
    {
        return solveSudoku(board, 0, 0);
    }

    static boolean solveSudoku(final int[][] board, final int startRow, final int startCol)
    {
        int row = startRow;
        int col = startCol;

        // Skip fields with numbers until we come across an empty field
        while (row < 9 && board[row][col] != 0)
        {
            col++;
            if (col > 8)
            {
                col = 0;
                row++;
            }
        }

        if (row > 8)
            return true;

        // Find a valid number for the empty cell
        for (int num = 1; num <= 9; num++)
        {
            board[row][col] = num;

            if (isValidPosition(board))
            {
                board[row][col] = num;

                boolean solved = false;
                if (col < 8)
                {
                    // recursive descent: next field in x direction
                    solved = solveSudoku(board, row, col + 1);
                }
                else
                {
                    // recursive descent: next field in new line
                    solved = solveSudoku(board, row + 1, 0);
                }

                if (!solved)
                {
                    // Backtracking: no solution found
                    board[row][col] = 0;
                }
                else
                {
                    return true;
                }
            }
            else
            {
                board[row][col] = 0;
            }
        }

        return false;
    }

    static boolean isValidPosition(final int[][] board)
    {
        return checkHorizontally(board) && checkVertically(board) && checkBoxes(board);
    }

    // ----------------------------------

    public static boolean checkVertically(final int[][] board)
    {
        for (int x = 0; x < 9; x++)
        {
            // collect all values from one column into a list
            final List<Integer> columnValues = new ArrayList<>();
            for (int row = 0; row < 9; row++)
            {
                columnValues.add(board[row][x]);
            }

            if (!allDesiredNumbers(columnValues))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean checkHorizontally(final int[][] board)
    {
        for (int row = 0; row < 9; row++)
        {
            // collect all values from one row into a list
            final List<Integer> rowValues = new ArrayList<>();
            for (int x = 0; x < 9; x++)
            {
                rowValues.add(board[row][x]);
            }

            if (!allDesiredNumbers(rowValues))
            {
                return false;
            }
        }

        return true;
    }

    // check quadrants
    public static boolean checkBoxes(final int[][] board)
    {
        // 3 x 3 boxes
        for (int yBox = 0; yBox < 3; yBox++)
        {
            for (int xBox = 0; xBox < 3; xBox++)
            {
                // values per box
                final List<Integer> boxValues = collectBoxValues(board, yBox, xBox);

                if (!allDesiredNumbers(boxValues))
                {
                    return false;
                }
            }
        }

        return true;
    }

    static List<Integer> collectBoxValues(final int[][] board, final int yBox, final int xBox)
    {
        final List<Integer> boxValues = new ArrayList<>();

        // inside the boxes each 3 x 3 fields
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                // real idx
                final int realY = yBox * 3 + y;
                final int realX = xBox * 3 + x;

                boxValues.add(board[realY][realX]);
            }
        }
        return boxValues;
    }

    // Helpers
    static boolean allDesiredNumbers(final Collection<Integer> allCollectedValues)
    {
        final Collection<Integer> relevantValues = new ArrayList<>(allCollectedValues);
        relevantValues.removeIf(val -> val == 0);

        // no duplicates?
        final Set<Integer> valuesSet = new TreeSet<>(relevantValues);
        if (relevantValues.size() != valuesSet.size())
            return false;

        // only 1 to 9?
        final Set<Integer> oneToNine = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        return oneToNine.containsAll(valuesSet);
    }

    public static void printArray(final int[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final int value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
