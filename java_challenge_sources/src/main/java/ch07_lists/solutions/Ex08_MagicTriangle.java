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
public class Ex08_MagicTriangle
{
    private Ex08_MagicTriangle()
    {
    }

    static boolean isMagic6(final List<Integer> values)
    {
        // indexes 0..3; 2..5; 4..6, but then add 0-th element
        final List<Integer> side1 = values.subList(0, 3);
        final List<Integer> side2 = values.subList(2, 5);
        final List<Integer> side3 = new ArrayList<>(values.subList(4, 6)); // supplies immutable
        side3.add(side1.get(0)); // Error when only subList()

        return compareSumOfSides(side1, side2, side3);
    }

    private static boolean compareSumOfSides(final List<Integer> side1, final List<Integer> side2,
                                             final List<Integer> side3)
    {
        final int sum1 = sum(side1);
        final int sum2 = sum(side2);
        final int sum3 = sum(side3);

        return sum1 == sum2 && sum2 == sum3;
    }

    static boolean isMagic6_V2(final List<Integer> values)
    {
        final List<Integer> valuesWithLoop = new ArrayList<>(values);
        // close the triangle
        valuesWithLoop.add(values.get(0));

        // indexes 0..3; 2..5; 4..7, but then add 0-th element
        final List<Integer> side1 = valuesWithLoop.subList(0, 3);
        final List<Integer> side2 = valuesWithLoop.subList(2, 5);
        final List<Integer> side3 = valuesWithLoop.subList(4, 7);

        return compareSumOfSides(side1, side2, side3);
    }

    private static int sum(final List<Integer> values)
    {
        return values.stream().mapToInt(n -> n).sum();
    }

    // Generalization with sideLength
    static boolean isMagic(final List<Integer> values)
    {
        if (values.size() % 3 != 0)
            throw new IllegalArgumentException("Not a triangle: " + values.size());

        final int sideLength = 1 + values.size() / 3;

        final List<Integer> valuesWithLoop = new ArrayList<>(values);
        // close the triangle
        valuesWithLoop.add(values.get(0));

        // e.g. indexes 0..4; 3..7; 6..10
        final List<Integer> side1 = valuesWithLoop.subList(0, sideLength);
        final List<Integer> side2 = valuesWithLoop.subList(sideLength - 1, sideLength * 2 - 1);
        final List<Integer> side3 = valuesWithLoop.subList((sideLength - 1) * 2, sideLength * 3 - 2);

        return compareSumOfSides(side1, side2, side3);
    }

    static boolean isMagicV2(final List<Integer> values)
    {
        if (values.size() % 3 != 0)
            throw new IllegalArgumentException("Not a triangle: " + values.size());

        final int[] sumOfSides = new int[3];

        final int sideLength = values.size() / 3 + 1;
        int pos = 0;
        for (int currentSide = 0; currentSide < 3; currentSide++)
        {
            for (int i = 0; i < sideLength; i++)
            {
                sumOfSides[currentSide] += values.get(pos);

                // Trick 1: With modulo => no special treatment for last value
                pos = (pos + 1) % values.size();
            }

            // Trick 2: The sides overlap, end field = next start field
            pos--;
        }

        return sumOfSides[0] == sumOfSides[1] && sumOfSides[1] == sumOfSides[2];
    }
}
