package ch05_arrays.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class TwoDimArrayExample
{
    public static void main(final String[] args)
    {
        var inputArray = new Object[][] { { "A", "B", "C", "D" }, { "E", "F", "G", "H" }, };

        printArray(inputArray);
        printArray(rotate(inputArray, RotationDirection.LEFT_90));
        printArray(rotate(inputArray, RotationDirection.RIGHT_90));

        var inputArray2 = new int[][] { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, };
        printArray(rotate(inputArray2, RotationDirection.RIGHT_90));
        printArray(rotate(rotate(inputArray2, RotationDirection.RIGHT_90), RotationDirection.RIGHT_90));
    }

    public static Object[][] rotate(final Object[][] values, final RotationDirection dir)
    {
        final int origLengthX = values[0].length;
        final int origLengthY = values.length;

        final Object[][] rotatedArray = new Object[origLengthX][origLengthY];

        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[0].length; x++)
            {
                final int maxX = values[0].length - 1;
                final int maxY = values.length - 1;

                final Object origValue = values[y][x];

                if (dir == RotationDirection.LEFT_90)
                {
                    final int newX = y;
                    final int newY = maxX - x;

                    rotatedArray[newY][newX] = origValue;
                }
                if (dir == RotationDirection.RIGHT_90)
                {
                    final int newX = maxY - y;
                    final int newY = x;

                    rotatedArray[newY][newX] = origValue;
                }
            }
        }

        return rotatedArray;
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

    enum RotationDirection {
        LEFT_90, RIGHT_90
    };

    public static int[][] rotate(final int[][] values, final RotationDirection dir)
    {
        final int[][] rotatedArray = new int[values[0].length][values.length];

        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[0].length; x++)
            {
                final int maxX = values[0].length - 1;
                final int maxY = values.length - 1;

                final int origValue = values[y][x];

                if (dir == RotationDirection.LEFT_90)
                {
                    final int newX = y;
                    final int newY = maxX - x;

                    rotatedArray[newY][newX] = origValue;
                }
                if (dir == RotationDirection.RIGHT_90)
                {
                    final int newX = maxY - y;
                    final int newY = x;

                    rotatedArray[newY][newX] = origValue;
                }
            }
        }

        return rotatedArray;
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

}
