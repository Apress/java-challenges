package ch07_lists.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class PascalTriangle
{
    private PascalTriangle()
    {
    }

    public static void main(final String[] args)
    {
        for (int i = 1; i <= 7; i++)
        {
            final List<List<Integer>> pascalsTriangleLines = calculatePascalsTriangle(i);
            System.out.println(i);
            System.out.println("----------------------------------");
            prettyPrint(pascalsTriangleLines);
            System.out.println("----------------------------------");
        }
    }

    private static List<List<Integer>> calculatePascalsTriangle(final int desiredHeight)
    {
        if (desiredHeight <= 0)
            throw new IllegalArgumentException("height must be positive and grater 0");

        // Start configuration
        final List<List<Integer>> rows = new ArrayList<>();
        rows.add(Collections.singletonList(1));

        // always offset by one i = 0 => desiredHeight = 2
        for (int i = 0; i < desiredHeight - 1; i++)
        {
            List<Integer> currentRow = calcCurrentRow(i, rows.get(i));

            rows.add(currentRow);
        }

        return rows;
    }

    private static List<Integer> calcCurrentRow(int i, List<Integer> upperRow)
    {
        final List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);

        // calc in between values depending on the row before
        for (int x = 0; x < i; x++)
        {
            final Integer sum = upperRow.get(x) + upperRow.get(x + 1);
            currentRow.add(sum);
        }

        currentRow.add(1);

        return currentRow;
    }

    private static void prettyPrint(final List<List<Integer>> pascalsTriangleLines)
    {
        for (int row = 0; row < pascalsTriangleLines.size(); row++)
        {
            System.out.println(pascalsTriangleLines.get(row));
        }
    }
}
