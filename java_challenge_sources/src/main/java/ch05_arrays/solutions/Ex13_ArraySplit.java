package ch05_arrays.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex13_ArraySplit
{
    private Ex13_ArraySplit()
    {
    }

    public static void main(final String[] args)
    {
        final int[] values = { 2, 14, 10, 1, 11, 3, 12, 4 };
        splitArray(values, 7);

        final int[] values2 = { 4, 7, 1, 20 };
        splitArray(values2, 9);

        final int[] values3 = { 2, 7, 1, 4, 3, 6, 8 };
        splitArray(values3, 5);

        // Special cases, left or right "empty"
        final int[] values5 = { 2, 1, 3, 4 };
        splitArray(values5, 5);

        final int[] values6 = { 2, 5, 3, 4 };
        splitArray(values6, 1);

        final int[] values7 = { 7, 8 };
        splitArray(values7, 9);

        final int[] values7b = { 8, 7 };
        splitArray(values7b, 9);

        final int[] values8 = { 8, 9 };
        splitArray(values8, 7);

        final int[] values12 = { 2 };
        splitArray(values12, 1);

        final int[] values21 = { 1 };
        splitArray(values21, 2);

        final int[] valuesDuplicates = { 3, 5, 7, 1, 11, 11, 13, 17, 19 };
        splitArray(valuesDuplicates, 11);
    }

    private static void splitArray(final int[] values, final int referenceElement)
    {
        System.out.println(Arrays.toString(values));
        System.out.println("SPL I: " + Arrays.toString(arraySplit(values, referenceElement)));

        final int[] result = arraySplitInplace(values, referenceElement);
        System.out.println("SPL II: " + Arrays.toString(result));
    }

    static int[] arraySplit(final int[] values, final int referenceElement)
    {
        final List<Integer> lesser = new ArrayList<>();
        final List<Integer> biggerOrEqual = new ArrayList<>();

        for (int i = 0; i < values.length; i++)
        {
            final int current = values[i];
            if (current < referenceElement)
                lesser.add(current);
            else
                biggerOrEqual.add(current);
        }

        final List<Integer> result = new ArrayList<>();
        result.addAll(lesser);
        result.add(referenceElement);
        result.addAll(biggerOrEqual);

        return result.stream().mapToInt(i -> i).toArray();
    }

    static int[] arraySplitInplace(final int[] values, final int referenceElement)
    {
        int low = 0;
        int high = values.length - 1;

        while (low < high)
        {
            while (low < high && values[low] < referenceElement)
                low++;

            while (high > low && values[high] >= referenceElement)
                high--;

            if (low < high)
                ArrayUtils.swap(values, low, high);
        }

        return integrateReferenceElement(values, high, referenceElement);
    }

    static int[] integrateReferenceElement(final int[] values, final int pos, final int referenceElement)
    {
        // recreate new array
        final int[] result = new int[values.length + 1];

        // copy in lower part
        for (int i = 0; i < pos; i++)
            result[i] = values[i];

        // Reference element
        result[pos] = referenceElement;

        // Successor element(s), if available
        for (int i = pos + 1; i < values.length + 1; i++)
            result[i] = values[i - 1];

        return result;
    }
}
