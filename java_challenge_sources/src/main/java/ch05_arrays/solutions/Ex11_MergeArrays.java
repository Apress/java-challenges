package ch05_arrays.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex11_MergeArrays
{
    private Ex11_MergeArrays()
    {
    }

    static int[] merge(final int[] first, final int[] second)
    {
        final int length1 = first.length;
        final int length2 = second.length;

        final int[] result = new int[length1 + length2];

        int pos1 = 0;
        int pos2 = 0;
        int idx = 0;

        // Loop through as long as the two position pointers are less than the length of their array
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

    static void addRemaining(final int[] values, final int[] result, int pos, int idx)
    {
        while (pos < values.length)
        {
            result[idx] = values[pos];

            idx++;
            pos++;
        }
    }

    public static int[] mergeCompact(final int[] first, final int[] second)
    {
        final int[] result = new int[first.length + second.length];

        int idx1 = 0;
        int idx2 = 0;
        int destIdx = 0;

        while (idx1 < first.length && idx2 < second.length)
        {
            if (first[idx1] < second[idx2])
                result[destIdx++] = first[idx1++];
            else
                result[destIdx++] = second[idx2++];
        }

        while (idx1 < first.length)
            result[destIdx++] = first[idx1++];

        while (idx2 < second.length)
            result[destIdx++] = second[idx2++];

        return result;
    }
}
