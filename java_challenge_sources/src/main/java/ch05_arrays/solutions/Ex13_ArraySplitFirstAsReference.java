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
public class Ex13_ArraySplitFirstAsReference
{
    public static void main(final String[] args)
    {
        final int[] values = {7, 2, 14, 10, 1, 11, 3, 12, 4};
        splitArray(values);

        final int[] values2 = {9, 4, 7, 1, 20 };
        splitArray(values2);

        final int[] values3 = { 5, 2, 7, 1, 4, 3, 6, 8 };
        splitArray(values3);

        final int[] values4 = { 5, 2, 7, 9, 6, 3, 1, 4, 8 };
        splitArray(values4);

        // Special cases, left or right "empty"
        final int[] values5 = { 5, 2, 1, 3, 4 };
        splitArray(values5);

        final int[] values6 = { 1, 2, 5, 3, 4 };
        splitArray(values6);

        final int[] values7 = { 9, 7, 8 };
        splitArray(values7);

        final int[] values7b = { 9, 8, 7 };
        splitArray(values7b);

        final int[] values8 = { 7, 8, 9 };
        splitArray(values8);

        final int[] values12 = { 1, 2 };
        splitArray(values12);

        final int[] values21 = { 2, 1 };
        splitArray(values21);

        final int[] valuesDuplicates = { 11, 3, 5, 7, 1, 11, 11, 13, 17, 19 };
        splitArray(valuesDuplicates);
    }

    private static void splitArray(final int[] values)
    {
        System.out.println(Arrays.toString(values));
        System.out.println("SPL I: " + Arrays.toString(arraySplit(values)));
        final int[] values2 = Arrays.copyOfRange(values, 0, values.length);
        System.out.println("SPL II: " + Arrays.toString(arraySplitInplace(values)));
        System.out.println("SPL III: " + Arrays.toString(arraySplitInplaceShorter(values2)));
    }

    static int[] arraySplit(final int[] values)
    {
        final List<Integer> lesser = new ArrayList<>();
        final List<Integer> bigger = new ArrayList<>();

        final int referenceValue = values[0];
        for (int i = 1; i < values.length; i++)
        {
            final int current = values[i];
            if (current < referenceValue)
                lesser.add(current);
            else
                bigger.add(current);
        }

        return buildResult(lesser, bigger, referenceValue);
    }

    protected static int[] buildResult(final List<Integer> lesser, final List<Integer> bigger, final int referenceValue)
    {
        final List<Integer> result = new ArrayList<>();
        result.addAll(lesser);
        result.add(referenceValue);
        result.addAll(bigger);

        return result.stream().mapToInt(i -> i).toArray();
    }

    static int[] arraySplitInplace(final int[] values)
    {
        final int referenceValue = values[0];

        int low = 1;
        int high = values.length - 1;

        while (low < high)
        {
            while (values[low] < referenceValue && low < high)
                low++;

            while (values[high] >= referenceValue && high >= low)
                high--;

            if (low < high)
            {
                ArrayUtils.swap(values, low, high);
            }
        }

        // important for 1,2 => then 1 would be pivot, do not swap!
        if (referenceValue > values[high])
            ArrayUtils.swap(values, 0, high);

        return values;
    }

    static int[] arraySplitInplaceShorter(final int[] values)
    {
        final int referenceValue = values[0];

        int left = 0;
        int right = values.length - 1;

        while (left < right)
        {
            while (values[left] < referenceValue && left < right)
                left++;
            while (values[right] > referenceValue && right > left)
                right--;

            ArrayUtils.swap(values, left, right);
        }
        return values;
    }

}
