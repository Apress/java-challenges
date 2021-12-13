package ch10_searching_sorting.intro;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class SearchInArraysExample
{
    private SearchInArraysExample()
    {
    }

    public static void main(final String[] args)
    {
        final int[] values = { 0,1,2,3,4,5,6,7,8,9};

        System.out.println(ArrayUtils.indexOf(values, 7));
        System.out.println(ArrayUtils.indexOf(values, 11));

        System.out.println(ArrayUtils.contains(values, 7));
        System.out.println(ArrayUtils.contains(values, 11));

        System.out.println(ArrayUtils.lastIndexOf(values, 7));
        System.out.println(ArrayUtils.lastIndexOf(values, 11));
    }
}
