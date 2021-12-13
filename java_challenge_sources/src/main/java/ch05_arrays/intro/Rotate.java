package ch05_arrays.intro;

import java.lang.reflect.Array;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Rotate {

    public static void main(final String[] args)
    {
        final String[][] chars = {
                                  { "A", "B", "C", "D"},
                                  { "E", "F", "G", "H" }
        };
        System.out.println("Original");
        printArray(chars);
        System.out.println("-----------------");
        Object[][] rotatedArrayL = rotate(chars, RotationDirection.LEFT_90);
        printArray(rotatedArrayL);
        Object[][] rotatedArrayR = rotate(chars, RotationDirection.RIGHT_90);
        printArray(rotatedArrayR);

        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");

        // Special case odd length
        final Integer[][] numbersHor2 = {
                                         { 1, 1, 7, 2, 2},
                                         { 1, 1, 7, 2, 2},
                                         { 1, 1, 7, 2, 2},
                                         { 1, 1, 7, 2, 2},
        };
        printArray(numbersHor2);
        System.out.println("-----------------");
        Object[][] rotatedArrayLeft = rotate(numbersHor2, RotationDirection.LEFT_90);
        printArray(rotatedArrayLeft);
        System.out.println("-----------------");
        Object[][] rotatedArrayRight = rotate(numbersHor2, RotationDirection.RIGHT_90);
        printArray(rotatedArrayRight);


        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");


        final Integer[][] numbers2 = {
                                      { 1, 1, 1, 1, 1, 1},
                                      { 2, 2, 2, 2, 2, 2},
                                      { 3, 3, 3, 3, 3, 3},
                                      { 4, 4, 4, 4, 4, 4},
                                      { 5, 5, 5, 5, 5, 5},
                                      { 6, 6, 6, 6, 6, 6},
        };
        printArray(numbers2);
        System.out.println("-----------------");
        Object[][] rotatedArray90 = rotate(numbers2, RotationDirection.LEFT_90);
        printArray(rotatedArray90);
        System.out.println("-----------------");
        Object[][] rotatedArray180 = rotate(rotatedArray90, RotationDirection.LEFT_90);
        printArray(rotatedArray180);
        System.out.println("-----------------");
        Object[][] rotatedArray270 = rotate(rotatedArray180, RotationDirection.LEFT_90);
        printArray(rotatedArray270);
    }


    enum RotationDirection { LEFT_90, RIGHT_90 };

    static <T> T[][] rotate(final T[][] values, final RotationDirection dir)
    {
        final int origLengthX = values[0].length;
        final int origLengthY = values.length;

        final Class<?> plainType = values.getClass().componentType().componentType();
        final T[][] rotatedArray = (T[][]) Array.newInstance(plainType,
                                                             origLengthX, origLengthY);
        final int maxX = origLengthX - 1;
        final int maxY = origLengthY - 1;

        for (int y = 0; y < origLengthY; y++)
        {
            for (int x = 0; x < origLengthX; x++)
            {
                final T origValue = values[y][x];

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

    static <T> T getAt(final T[][] values, final int x, final int y)
    {
        return values[y][x];
    }

    static <T> void printArray(final T[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final T value = values[y][x];
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
