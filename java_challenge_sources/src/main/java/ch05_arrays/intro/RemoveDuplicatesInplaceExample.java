package ch05_arrays.intro;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class RemoveDuplicatesInplaceExample
{
    public static void main(final String[] args)
    {
        final int[] sortedNumbers = { 1, 2, 3, 3, 3, 4, 4, 4, 4 };

        removeDuplicatesFirstTry(sortedNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        final int[] sortedNumbers1 = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };

        System.out.println(removeDuplicatesImproved(sortedNumbers1));
        System.out.println(Arrays.toString(sortedNumbers1));
    }

    private static int[] removeDuplicatesFirstTry(int[] sortedNumbers)
    {
        // Idea: Loop through the array, checking, at each element,
        // if it is a duplicate. This can be done simply by comparing
        // with the predecessor. This is possible because there is a sort order.
        int prevValue = sortedNumbers[0];
        int writePos = 1;
        int i = 1;
        while (i < sortedNumbers.length)
        {
            final int currentValue = sortedNumbers[i];
            if (prevValue != currentValue)
            {
                // copy
                sortedNumbers[writePos] = currentValue;
                writePos++;

                prevValue = currentValue;
            }

            i++;
        }

        return sortedNumbers;
    }

    private static int removeDuplicatesImproved(final int[] sortedNumbers)
    {
        // sanity check
        if (sortedNumbers.length < 1)
            return 0;

        int writeIndex = 1;
        for (int i = 1; i < sortedNumbers.length; i++)
        {
            final int currentValue = sortedNumbers[i];
            final int prevValue = sortedNumbers[writeIndex - 1];

            if (prevValue != currentValue)
            {
                sortedNumbers[writeIndex] = sortedNumbers[i];
                writeIndex++;
            }
        }

        for (int i = writeIndex; i < sortedNumbers.length; i++)
        {
            sortedNumbers[i] = -1;
        }
        return writeIndex;
    }
}
