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
public class Ex13_ListMerger
{
    private Ex13_ListMerger()
    {
    }

    private static List<Integer> mergeFirstTry(final List<Integer> values1, final List<Integer> values2)
    {
        final List<Integer> result = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < values1.size() && idx2 < values2.size())
        {
            // Another problem when list of length reaches 0!!! or end of list ...
            final int value1 = values1.get(idx1);
            final int value2 = values2.get(idx2);

            if (value1 < value2)
            {
                result.add(value1);
                idx1++;
            }
            else
            {
                result.add(value2);
                idx2++;
            }
        }

        return result;
    }

    static List<Integer> merge(final List<Integer> inputs1, final List<Integer> inputs2)
    {
        final List<Integer> result = new ArrayList<>();

        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < inputs1.size() && idx2 < inputs2.size())
        {
            // One must note when list of length reaches 0!!! or end of list ...
            final int value1 = inputs1.get(idx1);
            final int value2 = inputs2.get(idx2);

            if (value1 < value2)
            {
                result.add(value1);
                idx1++;
            }
            else
            {
                result.add(value2);
                idx2++;
            }
        }

        addRemaining(inputs1, result, idx1);
        addRemaining(inputs2, result, idx2);

        return result;
    }

    static void addRemaining(final List<Integer> inputs, final List<Integer> result, final int idx)
    {
        for (int i = idx; i < inputs.size(); i++)
        {
            final int value = inputs.get(i);
            result.add(value);
        }
    }
}
