package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_FlagPartitioning
{
    private Ex02_FlagPartitioning()
    {
    }

    public static String partition2(final String charValues)
    {
        return partition2(charValues.toCharArray());
    }

    public static String partition2(final char[] charValues)
    {
        int low = 0;
        int high = charValues.length - 1;

        while (low <= high)
        {
            if (charValues[low] == 'A')
                low++;
            else
            {
                ArrayUtils.swap(charValues, low, high);

                high--;
                // low must remain, because theoretically also a B can be exchanged to the front
            }
        }

        return new String(charValues);
    }

    public static String partition3(final String charValues)
    {
        return partition3(charValues.toCharArray());
    }

    public static String partition3(final char[] charValues)
    {
        int low = 0;
        int mid = 0;
        int high = charValues.length - 1;

        while (mid <= high)
        {
            if (charValues[mid] == 'A')
            {
                ArrayUtils.swap(charValues, low, mid);

                low++;
                mid++;
            }
            else if (charValues[mid] == 'B')
                mid++;
            else
            {
                ArrayUtils.swap(charValues, mid, high);

                high--;
                // low, mid must remain, because theoretically a B, C can also be exchanged to the front
            }
        }

        return new String(charValues);
    }
}
