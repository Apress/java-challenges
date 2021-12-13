package ch10_searching_sorting.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_RotatedSearch
{
    private Ex08_RotatedSearch()
    {
    }

    static int findFlankPos(final int[] values)
    {
        return findFlankPosHelper(values, 0, values.length - 1);
    }

    static int findFlankPosHelper(final int[] values, final int left, final int right)
    {
        final int midPos = left + (right - left) / 2;
        final int midValue = values[midPos];

        // special case no rotation
        if (values[left] < values[right])
            return 0;

        // Case A: Value to the left of this is greater, then we have an flank change
        int prevIndex = midPos - 1;
        if (prevIndex < 0)
            prevIndex = values.length - 1;

        if (values[prevIndex] > midValue)
            return midPos;

        if (values[left] > midValue)
        {
            // Case B: Flank change must be on the left, since first value is greater than in the middle
            return findFlankPosHelper(values, left, midPos + 1);
        }
        if (values[right] < midValue)
        {
            // Case C: Flank change must be on the right, since last value is smaller than in the middle
            return findFlankPosHelper(values, midPos + 1, right);
        }

        throw new IllegalStateException("should never reach here!");
    }

    static int minValue(final int[] values)
    {
        final int flankpos = findFlankPos(values);
        return values[flankpos];
    }

    static int maxValue(final int[] values)
    {
        int flankpos = findFlankPos(values);
        // can only occur with rotation 0
        if (flankpos == 0)
            flankpos = values.length;
        return values[flankpos - 1];
    }

    static int binarySearchRotated(final int[] values, final int searchFor)
    {
        final int flankpos = findFlankPos(values);

        return binarySearchRotatedHelper(values, searchFor, flankpos, flankpos - 1 + values.length);
    }

    static int binarySearchRotatedHelper(final int[] values, final int searchFor, final int start, final int end)
    {
        if (start > end)
            return -1;

        final int midPos = start + (end - start) / 2;
        final int midValue = values[midPos % values.length];

        if (midValue == searchFor)
            return midPos % values.length;

        if (searchFor < midValue)
        {
            return binarySearchRotatedHelper(values, searchFor, start, midPos - 1);
        }
        if (searchFor > midValue)
        {
            return binarySearchRotatedHelper(values, searchFor, midPos + 1, end);
        }
        throw new IllegalStateException("should never reach here!");
    }
}
