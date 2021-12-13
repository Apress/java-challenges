package ch08_recursion_advanced.intro;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class MemoizationExamples
{
    private MemoizationExamples()
    {
    }

    public static void main(final String[] args)
    {
        final long start = System.currentTimeMillis();
        final long result = fibRec(47);
        final long end = System.currentTimeMillis();
        System.out.println("fibRec(47)=" + result);
        System.out.println("took " + (end-start) + " ms");

        final long start2 = System.currentTimeMillis();
        final long result2 = fibonacciOptimized(47);
        System.out.println("fibonacciOpt(47)=" + result2);
        final long end2 = System.currentTimeMillis();
        System.out.println("took " + (end2-start2) + " ms");



        final long start3 = System.currentTimeMillis();
        final long result3 = pascalRec(42, 15);
        System.out.println("calcPascal(42, 15)=" + result3);
        final long end3 = System.currentTimeMillis();
        System.out.println("took " + (end3-start3) + " ms");

        final long start4 = System.currentTimeMillis();
        final long result4 = pascalOptimized(42, 15);
        System.out.println("calcPascalOpt(42, 15)=" + result4);
        final long end4 = System.currentTimeMillis();
        System.out.println("took " + (end4-start4) + " ms");
    }

    public static long fibRec(final int n)
    {
        if (n <= 0)
            throw new IllegalArgumentException("n must be >= 1");

        // recursive termination
        if (n == 1 || n == 2)
            return 1;

        // recursive descent
        return fibRec(n - 1) + fibRec(n - 2);
    }

    static long fibonacciOptimized(final int n)
    {
        return fibonacciMemo(n, new HashMap<>());
    }

    static long fibonacciMemo(final int n,
                              final Map<Integer, Long> lookupMap)
    {
        if (n <= 0)
            throw new IllegalArgumentException("must be > 0");

        // MEMOIZATION: check if precalculated result
        if (lookupMap.containsKey(n))
        {
            return lookupMap.get(n);
        }

        // normal algorithm with auxiliary variable for result
        long result = 0;
        if (n == 1)
            result = 1;
        else if (n == 2)
            result = 1;
        else
            result = fibonacciMemo(n - 1, lookupMap) +
            fibonacciMemo(n - 2, lookupMap);

        // MEMOIZATION: store calculated result
        lookupMap.put(n, result);

        return result;
    }

    // -----------------------------------

    public static int pascalRec(final int row, final int col)
    {
        // recursive termination: top
        if (col == 1 && row == 1)
            return 1;

        // recursive termination: borders
        if (col == 1 || col == row)
            return 1;

        // recursive descent
        return pascalRec(row - 1, col) + pascalRec(row - 1, col - 1);
    }

    public static int pascalOptimized(final int row, final int col)
    {
        return calcPascalMemo(row, col, new HashMap<>());
    }

    public static int calcPascalMemo(final int row, final int col,
                                     final Map<IntIntKey, Integer> lookupMap)
    {
        // MEMOIZATION
        final IntIntKey key = new IntIntKey(row, col);
        if (lookupMap.containsKey(key))
        {
            return lookupMap.get(key);
        }

        int result;
        // recursive termination: top
        if (col == 1 && row == 1)
            result = 1;

        // recursive termination: borders
        else if (col == 1 || col == row)
            result = 1;

        else
            // recursive descent
            result = calcPascalMemo(row - 1, col, lookupMap) +
            calcPascalMemo(row - 1, col - 1, lookupMap);

        // MEMOIZATION
        lookupMap.put(key, result);

        return result;
    }

    static record IntIntKey(int value1, int value2)
    {
    }

    static class IntIntKey2
    {
        int value1;
        int value2;

        public IntIntKey2(final int value1, final int value2)
        {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(value1, value2);
        }

        @Override
        public boolean equals(final Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            final IntIntKey2 other = (IntIntKey2) obj;

            return value1 == other.value1 && value2 == other.value2;
        }
    }
}
