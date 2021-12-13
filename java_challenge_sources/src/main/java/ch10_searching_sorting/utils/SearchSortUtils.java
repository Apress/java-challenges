package ch10_searching_sorting.utils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class SearchSortUtils
{
    public static int indexOf(final int[] values, final int searchFor)
    {
        int length = values.length;

        for (int pos = 0; pos < length; pos++)
        {
            if (values[pos] == searchFor)
                return pos;
        }

        return -1;
    }

    public static int lastIndexOf(final int[] values, final int searchFor)
    {
        int length = values.length;

        for (int pos = length - 1; pos >= 0; pos--)
        {
            if (values[pos] == searchFor)
                return pos;
        }

        return -1;
    }

    public static int indexOfSpecial(final int[] values, final int searchFor)
    {
        int left = 0;
        int right = values.length - 1;

        while (left < right)
        {
            if (values[left] == searchFor)
                return left;
            if (values[right] == searchFor)
                return right;

            left++;
            right--;
        }

        return -1;
    }

    public static boolean contains(final int[] values, final int searchFor)
    {
        return indexOf(values, searchFor) != -1;
    }
}
