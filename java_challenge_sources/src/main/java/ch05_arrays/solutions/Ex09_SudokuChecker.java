package ch05_arrays.solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_SudokuChecker
{
    private Ex09_SudokuChecker()
    {
    }

    public static boolean isSudokuValid(final int[][] board)
    {
        return checkVertically(board) && checkHorizontally(board) && checkBoxes(board);
    }

    public static boolean checkHorizontally(final int[][] board)
    {
        for (int row = 0; row < 9; row++)
        {
            // Collect all values of a row in a list
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


    public static boolean checkVertically(final int[][] board)
    {
        for (int x = 0; x < 9; x++)
        {
            // Collect all values of a column in a list
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

    public static boolean checkBoxes(final int[][] board)
    {
        // 3 x 3-Boxes
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

    private static List<Integer> collectBoxValues(final int[][] board, final int yBox, final int xBox)
    {
        final List<Integer> boxValues = new ArrayList<>();

        // inside the boxes each 3 x 3 fields
        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 3; x++)
            {
                // real index values
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
        // remove irrelevant blank field
        final List<Integer> relevantValues = new ArrayList<>(allCollectedValues);
        relevantValues.removeIf(val -> val == 0);

        // no duplicates?
        final Set<Integer> valuesSet = new TreeSet<>(relevantValues);
        if (relevantValues.size() != valuesSet.size())
            return false;

        // only 1 tp 9?
        final Set<Integer> oneToNine = Set.of(1,2,3,4,5,6,7,8,9);

        return oneToNine.containsAll(valuesSet);
    }
}
