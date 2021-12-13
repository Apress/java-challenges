package ch05_arrays.intro;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class ArrayRotationExample
{
    public static void main(final String[] args)
    {
        final int[] numbers = { 1, 2, 3, 4, 5, 6, 7 };
        rotateRight(numbers);
        System.out.println("number: " + Arrays.toString(numbers));
        rotateRight(numbers);
        System.out.println("number: " + Arrays.toString(numbers));
        rotateRight(numbers);
        System.out.println("number: " + Arrays.toString(numbers));
        rotateRight(numbers);
        System.out.println("number: " + Arrays.toString(numbers));

        final int[] numbers1 = { 1, 2, 3, 4, 5, 6, 7 };
        rotateRightByN_Simple(numbers1, 4);
        System.out.println("numbers1: " + Arrays.toString(numbers1));
        rotateRightByN_Simple(numbers1, 7);
        System.out.println("numbers1: " + Arrays.toString(numbers1));
        rotateRightByN_Simple(numbers1, 21);
        System.out.println("numbers1: " + Arrays.toString(numbers1));
        rotateRightByN_Simple(numbers1, 22);
        System.out.println("numbers1: " + Arrays.toString(numbers1));

        final int[] numbers2 = { 1, 2, 3, 4, 5, 6, 7 };
        final int[] rotated2 = rotateRightByN(numbers2, 3);
        System.out.println(Arrays.toString(rotated2));
    }

    public static void rotateRight(final int[] values)
    {
        if (values.length < 2)
            return;

        final int endPos = values.length - 1;
        final int temp = values[endPos];

        for (int i = endPos; i > 0; i--)
            values[i] = values[i - 1];

        values[0] = temp;
    }

    static void rotateRightByN_Simple(final int[] values, final int n)
    {
        for (int i = 0; i < n % values.length; i++)
        {
            rotateRight(values);
        }
    }

    void rotateLeft(final int[] values)
    {
        if (values.length < 2)
            return;

        final int endPos = values.length - 1;
        final int temp = values[0];

        for (int i = 0; i < endPos; i++)
            values[i] = values[i + 1];

        values[endPos] = temp;
    }

    public static int[] rotateRightByN(final int[] values, final int n)
    {
        final int adjustedN = n % values.length;
        final int[] tempBuffer = fillTempWithLastN(values, adjustedN);

        // copy n positions to the right
        for (int i = values.length - 1; i >= adjustedN; i--)
        {
            values[i] = values[i - adjustedN];
        }

        copyTempBufferToStart(tempBuffer, values);

        return values;
    }

    private static int[] fillTempWithLastN(final int[] values, final int n)
    {
        final int[] tempBuffer = new int[n];
        for (int i = 0; i < n; i++)
        {
            tempBuffer[i] = values[values.length - 1 - i];
        }
        return tempBuffer;
    }

    private static void copyTempBufferToStart(final int[] tempBuffer, final int[] values)
    {
        for (int i = 0; i < tempBuffer.length; i++)
        {
            values[i] = tempBuffer[tempBuffer.length - 1 - i];
        }
    }
}
