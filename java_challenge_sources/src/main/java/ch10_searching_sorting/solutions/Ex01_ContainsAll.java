package ch10_searching_sorting.solutions;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_ContainsAll
{
    private Ex01_ContainsAll()
    {
    }

    public static boolean containsAll(final int[] values, final int... searchFor)
    {
        for (int current : searchFor)
        {
            if (!ArrayUtils.contains(values, current))
            {
                return false;
            }
        }

        return true;
    }
}
