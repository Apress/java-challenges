package ch05_arrays.intro;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class RemoveDuplicatesExample2
{
    public static void main(final String[] args)
    {
        final int[] numbers = { 1, 3, 2, 4, 3, 4, 4, 4, 1 };

        final int[] noDup1 = removeDuplicates(numbers);
        System.out.println(Arrays.toString(noDup1));

        final int[] sortedNumbers = { 1, 2, 3, 4, 2, 4, 3, 4, 4, 1 };

        final int[] noDup2 = removeDuplicates(sortedNumbers);
        System.out.println(Arrays.toString(noDup2));
    }

    private static int[] removeDuplicates(final int[] numbers)
    {
        final Set<Integer> uniqueValues = collectValues(numbers);

        return convertSetToArray(uniqueValues);
    }

    private static Set<Integer> collectValues(final int[] numbers)
    {
        // Loop through all elements and collect the values in a LinkedHashSet as auxiliary data structure
        final Set<Integer> uniqueValues = new LinkedHashSet<>();
        for (int i = 0; i < numbers.length; i++)
        {
            final int value = numbers[i];
            uniqueValues.add(value);
        }
        return uniqueValues;
    }

    private static int[] convertSetToArray(final Set<Integer> values)
    {
        return values.stream().mapToInt(n -> n).toArray();
    }

}
