package ch05_arrays.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class TwoDimArrayWorldExample
{
    public static void main(final String[] args)
    {
        final char[][] world =
                    {
                     "################".toCharArray(),
                     "##  P         ##".toCharArray(),
                     "####   $ X  ####".toCharArray(),
                     "###### $  ######".toCharArray(),
                     "####   $ X  ####".toCharArray(),
                     "################".toCharArray(),
                    };

        printArray(world);
    }

    public static void printArray(final char[][] values)
    {
        for (int y= 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final char value = getAt(values, x, y);
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static char getAt(final char[][] values, int x, int y)
    {
        return values[y][x];
    }
}
