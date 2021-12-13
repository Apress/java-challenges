package ch05_arrays.solutions;

import java.util.Arrays;

import ch02_math.util.MathUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_OrderEvenOdd
{
    private Ex01_OrderEvenOdd()
    {
    }

    public static void main(final String[] args)
    {
        final int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        orderEvenBeforeOdd(numbers);
        System.out.println(Arrays.toString(numbers));

        final int[] numbers0 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        orderEvenBeforeOddOptimizedV2(numbers0);
        System.out.println("Better: " + Arrays.toString(numbers0));

        final int[] numbers1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        orderOddBeforeEven(numbers1);
        System.out.println(Arrays.toString(numbers1));

        final int[] numbers2 = { 2, 4, 5, 7, 8, 9, 10 };
        orderEvenBeforeOdd(numbers2);
        System.out.println(Arrays.toString(numbers2));
    }

    static void orderEvenBeforeOdd(final int[] numbers)
    {
        int i = 0;
        while (i < numbers.length)
        {
            final int value = numbers[i];
            if (MathUtils.isEven(value))
            {
                // even number, so continue with next number
            }
            else
            {
                // odd number, jump over all odd ones, until the first even one
                int j = i + 1;
                while (j < numbers.length && !MathUtils.isEven(numbers[j]))
                {
                    j++;
                }

                if (j < numbers.length)
                    swap(numbers, i, j);
                else
                    break; // no more numbers
            }

            i++;
        }
    }

    private static void orderOddBeforeEven(final int[] numbers)
    {
        int i = 0;
        while (i < numbers.length)
        {
            final int value = numbers[i];
            if (!MathUtils.isEven(value))
            {
                // next number
            }
            else
            {
                int j = i + 1;
                while (j < numbers.length && MathUtils.isEven(numbers[j]))
                {
                    j++;
                }

                if (j < numbers.length)
                {
                    swap(numbers, i, j);
                }
            }

            i++;
        }
    }

    static void swap(final int[] number, final int pos1, final int pos2)
    {
        final int temp = number[pos1];

        number[pos1] = number[pos2];
        number[pos2] = temp;
    }

    void orderEvenBeforeOddOptimized(final int[] numbers)
    {
        int nextEven = 0;
        int nextOdd = numbers.length - 1;

        while (nextEven < nextOdd)
        {
            final int currentValue = numbers[nextEven];
            if (MathUtils.isEven(currentValue))
            {
                nextEven++;
            }
            else
            {
                swap(numbers, nextEven, nextOdd);

                nextOdd--;
            }
        }
    }

    static void orderEvenBeforeOddOptimizedV2(final int[] numbers)
    {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right)
        {
            // run to the first odd number or array end
            while (left < numbers.length && numbers[left] % 2 == 0)
                left++;
            // run to the first even number or start of array
            while (right >= 0 && numbers[right] % 2 != 0)
                right--;

            if (left < right)
            {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }
    }
}
