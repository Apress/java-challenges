package ch10_searching_sorting.intro;

import java.util.Arrays;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class InsertionSortExample
{
    private InsertionSortExample()
    {
    }

    public static void main(final String[] args)
    {
        final int[] values1 = { 5, 2, 9, 1, 3, 7 };
        final int[] values2 = { 7, 2, 5, 1, 6, 8, 9, 4, 3 };

        insertionSort(values1);
        insertionSort(values2);
        System.out.println(Arrays.toString(values1));
        System.out.println(Arrays.toString(values2));

        final int[] numbers = { 5, 7, 2, 1, 4 };
        insertionSort(numbers);
        System.out.println("1: " + Arrays.toString(numbers));

        final int[] numbers3 = { 5, 7, 2, 1, 4 };
        insertionSort(numbers3);
        System.out.println("2: " + Arrays.toString(numbers3));

        final int[] numbersA = { 4, 2, 7, 9, 1 };
        insertionSort(numbersA);
        System.out.println("3: " + Arrays.toString(numbersA));
    }

    static void insertionSort(final int[] numbers)
    {
        for (int currentPos = 1; currentPos < numbers.length; currentPos++)
        {
            final int currentVal = numbers[currentPos];
            final int insertPos = findInsertPosFromCurrent(numbers, currentPos);

            moveRight(numbers, currentPos, insertPos);

            numbers[insertPos] = currentVal;
        }
    }

    static void moveRight(final int[] numbers, final int currentPos, final int insertPos)
    {
        int movePos = currentPos;
        while (movePos > insertPos)
        {
            numbers[movePos] = numbers[movePos - 1];
            movePos--;
        }
    }

    private static int findInsertPosFromCurrent(final int[] numbers, final int current)
    {
        int insertPos = current;
        while (insertPos > 0 && numbers[insertPos - 1] > numbers[current])
        {
            insertPos--;
        }
        return insertPos;
    }

    private static int findInsertPosFromStart(final int[] numbers, final int current)
    {
        int insertPos = 0;
        while (insertPos < current && numbers[insertPos] < numbers[current])
        {
            insertPos++;
        }
        return insertPos;
    }
}
