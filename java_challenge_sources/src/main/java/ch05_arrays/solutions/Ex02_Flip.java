package ch05_arrays.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_Flip
{
    private Ex02_Flip()
    {
    }

    static <T> void flipHorizontally(final T[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            final int endPos = values[y].length;

            int leftIdx = 0;
            int rightIdx = endPos - 1;

            while (leftIdx < rightIdx)
            {
                final T leftValue = values[y][leftIdx];
                final T rightValue = values[y][rightIdx];

                // swap
                values[y][leftIdx] = rightValue;
                values[y][rightIdx] = leftValue;

                leftIdx++;
                rightIdx--;
            }
        }
    }

    static <T> void flipHorizontallyV2(final T[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            final T[] row = values[y];
            final int rowLength = row.length;
            for (int x = 0; x < rowLength / 2; x++)
            {
                ArrayUtils.swap(row, x, rowLength - x - 1);
            }
        }
    }

    static <T> void flipVertically(final T[][] values)
    {
        for (int x = 0; x < values[0].length; x++)
        {
            final int endPos = values.length;

            int topIdx = 0;
            int bottomIdx = endPos - 1;

            while (topIdx < bottomIdx)
            {
                final T topValue = values[topIdx][x];
                final T bottomValue = values[bottomIdx][x];

                // swap
                values[topIdx][x] = bottomValue;
                values[bottomIdx][x] = topValue;

                topIdx++;
                bottomIdx--;
            }
        }
    }

    static <T> void flipVerticallySimplified(final T[][] values)
    {
        for (int y = 0; y < values.length / 2; y++)
        {
            // swap line based
            ArrayUtils.swap(values, y, values.length - y - 1);
        }
    }
}
