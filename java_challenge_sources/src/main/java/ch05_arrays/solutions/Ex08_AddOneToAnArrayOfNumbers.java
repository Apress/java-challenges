package ch05_arrays.solutions;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_AddOneToAnArrayOfNumbers {

    private Ex08_AddOneToAnArrayOfNumbers()
    {
    }

    static int[] addOne(final int[] values)
    {
        if (values.length == 0)
            throw new IllegalArgumentException("must pass a valid non empty array");

        final int[] result = Arrays.copyOf(values, values.length);

        boolean overflow = true;
        int pos = values.length - 1;
        while (overflow && pos >= 0)
        {
            int currentValue = result[pos];
            if (overflow)
                currentValue += 1;

            result[pos] = currentValue % 10;

            overflow = currentValue >= 10;

            pos--;
        }

        return handleOverflowAtTop(result, overflow);
    }

    static int[] handleOverflowAtTop(final int[] result, final boolean overflow)
    {
        if (overflow)
        {
            // new array and a 1 in front
            final int[] newValues = new int[result.length + 1];
            newValues[0] = 1;
            for (int i = 0; i < result.length; i++)
                newValues[1 + i] = result[i];

            return newValues;
        }

        return result;
    }
}
