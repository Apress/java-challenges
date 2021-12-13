package ch03_recursion.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_PascalTriangle
{
    private Ex09_PascalTriangle()
    {
    }

    public static int calcPascal(final int row, final int col)
    {
        // recursive termination: top
        if (col == 1 || row == 1)
            return 1;

        // recursive termination: border
        if (col == 1 || col == row)
            return 1;

        // recursive descent
        return calcPascal(row - 1, col) + calcPascal(row - 1, col - 1);
    }

    public static void printPascalFirstTry(final int n)
    {
        for (int row = 1; row <= n; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                System.out.print(calcPascal(row, col) + " ");
            }

            System.out.println();
        }
    }

    // ----------------------------

    static List<Integer> calcPascal(final int n, final Consumer<List<Integer>> action)
    {
        if (n == 1)
        {
            action.accept(List.of(1));
            return List.of(1);
        }
        else
        {
            // recursive descent
            final List<Integer> previousLineValues = calcPascal(n - 1, action);

            final List<Integer> newLine = calcLine(previousLineValues);

            action.accept(newLine);
            return newLine;
        }
    }

    public static List<Integer> printPascal(final int n)
    {
        if (n == 1)
        {
            System.out.println("[1]");
            return List.of(1);
        }
        else
        {
            // recursive descent
            final List<Integer> previousLineValues = printPascal(n - 1);
            final List<Integer> newLine = calcLine(previousLineValues);

            System.out.println(newLine);
            return newLine;
        }
    }

    private static List<Integer> calcLine(final List<Integer> previousLine)
    {
        final List<Integer> newValues = new ArrayList<>();
        newValues.add(1);

        // calc line depending on sum of previous line
        final int count = previousLine.size();
        if (count > 1)
        {
            for (int i = 0; i < count - 1; i++)
            {
                final int first = previousLine.get(i);
                final int second = previousLine.get(i + 1);

                newValues.add(first + second);
            }
        }

        newValues.add(1);
        return newValues;
    }
}
