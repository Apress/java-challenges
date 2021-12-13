package ch05_arrays.util;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class ArrayUtils
{
    public static <T> int find(final T[] values, final T searchFor)
    {
        for (int i = 0; i < values.length; i++)
        {
            if (values[i].equals(searchFor))
                return i;
        }
        return -1;
    }

    public static <T> T nextCyclic(final T[] values, final int currentPos)
    {
        final int nextPos = (currentPos + 1) % values.length;
        return values[nextPos];
    }

    public static void swap(final int[] number, final int pos1, final int pos2)
    {
        final int temp = number[pos1];

        number[pos1] = number[pos2];
        number[pos2] = temp;
    }

    public static <T> void swap(final T[] number, final int pos1, final int pos2)
    {
        final T temp = number[pos1];

        number[pos1] = number[pos2];
        number[pos2] = temp;
    }

    public static void swap(final char[] values, final int first, final int second)
    {
        final char tmp = values[first];
        values[first] = values[second];
        values[second] = tmp;
    }

    public static int findMin(final int[] values)
    {
        final int minPos = findMinPos(values, 0, values.length);

        return values[minPos];
    }

    public static int findMinPos(final int[] values, final int startPos, final int endPos)
    {
        int minPos = startPos;
        for (int i = startPos + 1; i < endPos; i++)
        {
            if (values[i] < values[minPos])
            {
                minPos = i;
            }
        }
        return minPos;
    }

    public static int findMax(final int[] values)
    {
        final int minPos = findMaxPos(values, 0, values.length);

        return values[minPos];
    }

    public static int findMaxPos(final int[] values, final int startPos, final int endPos)
    {
        int maxPos = startPos;
        for (int i = startPos + 1; i < endPos; i++)
        {
            if (values[i] > values[maxPos])
            {
                maxPos = i;
            }
        }
        return maxPos;
    }

    public static void printArray(final Object[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final Object value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static <T> T[] rotateRight(final T[] values)
    {
        if (values.length < 2)
            return values;

        final T temp = values[values.length - 1];

        for (int i = values.length - 1; i > 0; i--)
        {
            values[i] = values[i - 1];
        }

        values[0] = temp;

        return values;
    }

    public static <T> T[] rotateLeft(final T[] values)
    {
        if (values.length < 2)
            return values;

        final T temp = values[0];

        for (int i = 0; i < values.length - 1; i++)
        {
            values[i] = values[i + 1];
        }

        values[values.length - 1] = temp;

        return values;
    }

    public static int[] rotateRight(final int[] values)
    {
        if (values.length < 2)
            return values;

        final int temp = values[values.length - 1];

        for (int i = values.length - 1; i > 0; i--)
        {
            values[i] = values[i - 1];
        }

        values[0] = temp;

        return values;
    }

    public static int[] rotateLeft(final int[] values)
    {
        if (values.length < 2)
            return values;

        final int temp = values[0];

        for (int i = 0; i < values.length - 1; i++)
        {
            values[i] = values[i + 1];
        }

        values[values.length - 1] = temp;

        return values;
    }

    public static char[] rotateRight(final char[] values)
    {
        if (values.length < 2)
            return values;

        final char temp = values[values.length - 1];

        for (int i = values.length - 1; i > 0; i--)
        {
            values[i] = values[i - 1];
        }

        values[0] = temp;

        return values;
    }

    public static char[] rotateLeft(final char[] values)
    {
        if (values.length < 2)
            return values;

        final char temp = values[0];

        for (int i = 0; i < values.length - 1; i++)
        {
            values[i] = values[i + 1];
        }

        values[values.length - 1] = temp;

        return values;
    }

    public static void printArray(final int[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final int value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(final char[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final char value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(final boolean[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final boolean value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    static <T> void printArrayJdk(final T[][] values)
    {
        for (int i = 0; i < values.length; i++)
        {
            System.out.println(Arrays.toString(values[i]));
        }
    }

    // from chapter search and sort
    // ----------------------------

    public static int indexOf(final int[] values, final int searchFor)
    {
        final int length = values.length;

        for (int pos = 0; pos < length; pos++)
        {
            if (values[pos] == searchFor)
                return pos;
        }

        return -1;
    }

    public static int lastIndexOf(final int[] values, final int searchFor)
    {
        final int length = values.length;

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

    public static int[] merge(final int[] first, final int[] second)
    {
        final int length1 = first.length;
        final int length2 = second.length;

        final int[] result = new int[length1 + length2];

        int pos1 = 0;
        int pos2 = 0;
        int idx = 0;

        // Loop through as long as the two position pointers are lower than the length of their array
        while (pos1 < length1 && pos2 < length2)
        {
            final int value1 = first[pos1];
            final int value2 = second[pos2];

            if (value1 < value2)
            {
                result[idx] = value1;

                idx++;
                pos1++;
            }
            else
            {
                result[idx] = value2;

                idx++;
                pos2++;
            }
        }

        // Collect the remaining elements
        addRemaining(first, result, pos1, idx);
        addRemaining(second, result, pos2, idx);

        return result;
    }

    private static void addRemaining(final int[] values, final int[] result, int pos, int idx)
    {
        while (pos < values.length)
        {
            result[idx] = values[pos];

            idx++;
            pos++;
        }
    }
}
