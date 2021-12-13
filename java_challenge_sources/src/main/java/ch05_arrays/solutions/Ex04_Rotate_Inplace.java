package ch05_arrays.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_Rotate_Inplace
{
    private Ex04_Rotate_Inplace()
    {
    }

    static <T> void rotateInplace(final T[][] values) {
        final int height = values.length - 1;
        final int width = values[0].length - 1;

        int offset = 0;
        while (offset <= width / 2)
        {
            final int currentWidth = width - offset * 2;
            for (int idx = 0; idx < currentWidth; idx++)
            {
                // top, right, bottom, left
                final int tlX = offset + idx;
                final int tlY = offset;

                final int trX = width - offset;
                final int trY = offset + idx;

                final int blX = offset;
                final int blY = height - offset - idx;

                final int brX = width - offset - idx;
                final int brY = height - offset;

                final T tl = values[tlY][tlX];
                final T tr = values[trY][trX];
                final T bl = values[blY][blX];
                final T br = values[brY][brX];

                // copy around
                values[trY][trX] = tl;
                values[brY][brX] = tr;
                values[blY][blX] = br;
                values[tlY][tlX] = bl;
            }

            offset++;
        }
    }

    static <T> void rotateInplaceRecursive(final T[][] values)
    {
        rotateInplaceRecursive(values, 0, values.length - 1);
    }

    static <T> void rotateInplaceRecursive(final T[][] values, final int left, final int right) {
        if (left >= right)
            return;

        final int rotCount = right - left;
        for (int i = 0; i < rotCount; i++) {
            final T tl = values[left + i][left];
            final T tr = values[right][left + i];
            final T bl = values[left][right - i];
            final T br = values[right - i][right];

            values[left + i][left] = tr;
            values[right][left + i] = br;
            values[right - i][right] = bl;
            values[left][right - i] = tl;
        }
        rotateInplaceRecursive(values, left + 1, right - 1);
    }

    static <T> void rotateInplaceV2(final T[][] array)
    {
        int sideLength = array.length;
        int start = 0;
        while (sideLength > 0)
        {
            for (int i = 0; i < sideLength - 1; i++)
            {
                rotateElements(array, start, sideLength, i);
            }
            sideLength = sideLength - 2;
            start++;
        }
    }

    static <T> void rotateElements(final T[][] array, final int start, final int len, final int i)
    {
        final int end = start + len - 1;
        final T tmp = array[start][start + i];
        array[start][start + i] = array[end - i][start];
        array[end - i][start] = array[end][end - i];
        array[end][end - i] = array[start + i][end];
        array[start + i][end] = tmp;
    }

}
