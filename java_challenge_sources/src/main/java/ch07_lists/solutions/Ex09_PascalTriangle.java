package ch07_lists.solutions;

import java.util.ArrayList;
import java.util.List;

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

    static List<List<Integer>> pascal(final int n)
    {
        final List<List<Integer>> result = new ArrayList<>();
        pascal(n, result);
        return result;
    }

    private static List<Integer> pascal(final int n, final List<List<Integer>> results)
    {
        if (n == 1)
        {
            results.add(List.of(1));
        }
        else
        {
            // calculate based on line before
            final List<Integer> previousLine = pascal(n - 1, results);

            // each line is calculated from the values of the line above it, flanked by a 1 in each case
            final List<Integer> currentLine = calcLine(previousLine);

            results.add(currentLine);
        }

        return results.get(n - 1);
    }

    private static List<Integer> calcLine(final List<Integer> previousLine)
    {
        final List<Integer> currentLine = new ArrayList<>();
        currentLine.add(1);

        for (int i = 0; i < previousLine.size() - 1; i++)
        {
            final int newValue = previousLine.get(i) + previousLine.get(i + 1);
            currentLine.add(newValue);
        }

        currentLine.add(1);
        return currentLine;
    }
}