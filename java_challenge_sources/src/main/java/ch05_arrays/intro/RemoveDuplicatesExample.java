package ch05_arrays.intro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class RemoveDuplicatesExample
{
    public static void main(final String[] args)
    {
        final int[] sortedNumbers = { 1, 2, 3, 3, 3, 4, 4, 4, 4 };

        removeDuplicatesFirstTry(sortedNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        final int[] sortedNumbers1 = { 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 };

        System.out.println(removeDuplicatesImproved(sortedNumbers1));
        System.out.println(Arrays.toString(sortedNumbers1));

        // not sorted and return new array
        final int[] noDuplicates = removeDuplicatesNewArray(sortedNumbers);
        System.out.println(Arrays.toString(noDuplicates));

    }

    private static void removeDuplicatesFirstTry(final int[] sortedNumbers)
    {
        // sanity check
        if (sortedNumbers.length < 1)
            return;

        int prevValue = sortedNumbers[0];
        int writePos = 1;
        int readPos = 1;
        while (readPos < sortedNumbers.length)
        {
            final int currentValue = sortedNumbers[readPos];
            if (prevValue != currentValue)
            {
                // copy to the left
                sortedNumbers[writePos] = currentValue;
                writePos++;

                prevValue = currentValue;
            }

            readPos++;
        }
    }

    private static int removeDuplicatesImproved(final int[] sortedNumbers)
    {
        // sanity check
        if (sortedNumbers.length < 1)
            return 0;

        int writeIndex = 1;
        for (int i = 1; i < sortedNumbers.length; i++)
        {
            int currentValue = sortedNumbers[i];
            int prevValue = sortedNumbers[writeIndex - 1];

            if (prevValue != currentValue)
            {
                //
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

    private static int[] removeDuplicatesNewArray(int[] sortedNumbers)
    {
        final Set<Integer> uniqueValues = collectValues(sortedNumbers);

        return convertSetToArray(uniqueValues);
    }

    private static Set<Integer> collectValues(final int[] sortedNumbers)
    {
        // Loop through all elements and collect the values in a TreeSet as auxiliary data structure
        final Set<Integer> uniqueValues = new TreeSet<>();
        for (int i = 0; i < sortedNumbers.length; i++)
        {
            final int value = sortedNumbers[i];
            uniqueValues.add(value);
        }
        return uniqueValues;
    }

    private static int[] convertSetToArray(final Set<Integer> uniqueValues)
    {
        final int size = uniqueValues.size();
        final int[] noDuplicates = new int[size];
        int i = 0;
        // Set does not have an index
        final Iterator<Integer> it = uniqueValues.iterator();
        while (it.hasNext())
        {
            noDuplicates[i] = it.next();
            i++;
        }
        return noDuplicates;
    }

}
