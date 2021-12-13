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
public class Ex11_ListAdder
{
    private Ex11_ListAdder()
    {
    }

    // simplification1: same length
    static List<Integer> listAdd(final List<Integer> inputs1,
                                 final List<Integer> inputs2)
    {
        final List<Integer> result = new ArrayList<>();

        int carry = 0;
        for (int i = inputs1.size() - 1; i >= 0; i--)
        {
            final int value1 = inputs1.get(i);
            final int value2 = inputs2.get(i);

            final int sum = value1 + value2 + carry;
            result.add(0, sum % 10);

            carry = sum >= 10 ? 1 : 0;
        }

        // In the case of a carryover, add a 1 at the front
        if (carry == 1)
        {
            result.add(0, 1);
        }

        return result;
    }

    static List<Integer> listAddImproved(final List<Integer> inputs1,
                                         final List<Integer> inputs2)
    {
        if (inputs1.isEmpty() || inputs2.isEmpty())
            throw new IllegalStateException("list mus contain at least one digit");


        final List<Integer> result = new ArrayList<>();

        int carry = 0;
        int idx1 = inputs1.size() - 1;
        int idx2 = inputs2.size() - 1;

        while(idx1 >= 0 || idx2 >= 0)
        {
            final int value1 = safeGetAt(inputs1, idx1);
            final int value2 = safeGetAt(inputs2, idx2);

            final int sum = value1 + value2 + carry;
            result.add(0, sum % 10);

            carry = sum >= 10 ? 1 : 0;

            idx1--;
            idx2--;
        }

        // In the case of a carryover, add a 1 at the front
        if (carry == 1)
        {
            result.add(0, 1);
        }

        return result;
    }

    static int safeGetAt(final List<Integer> inputs, final int pos)
    {
        if (pos >=0 && pos < inputs.size())
            return inputs.get(pos);

        return 0;
    }

    static List<Integer> listAddInvers(final List<Integer> inputs1, final List<Integer> inputs2)
    {
        final List<Integer> result = new ArrayList<>();

        int carry = 0;
        for (int i = 0; i < inputs1.size() || i < inputs2.size(); i++)
        {
            final int value1 = safeGetAt(inputs1, i);
            final int value2 = safeGetAt(inputs2, i);

            final int sum = value1 + value2 + carry;
            result.add(sum % 10);

            carry = sum >= 10 ? 1 : 0;
        }

        // In the case of a carryover, add a 1 at the "front"
        if (carry == 1)
        {
            result.add(1);
        }

        return result;
    }
}
