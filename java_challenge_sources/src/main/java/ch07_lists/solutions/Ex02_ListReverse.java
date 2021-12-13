package ch07_lists.solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_ListReverse
{
    private Ex02_ListReverse()
    {
    }

    // Assumption: Indexed access with O(1)
    static <T> List<T> listReverse(final List<T> inputs)
    {
        final List<T> result = new ArrayList<>();

        for (int i = inputs.size() - 1; i >= 0; i--)
        {
            final T origValue = inputs.get(i);
            result.add(origValue);
        }
        return result;
    }

    static <T> List<T> listReverseWithListIterator(final List<T> inputs)
    {
        final List<T> result = new ArrayList<>();

        final ListIterator<T> it = inputs.listIterator(inputs.size());
        while (it.hasPrevious())
        {
            final T origValue = it.previous();
            result.add(origValue);
        }

        return result;
    }

    // Assumption: Indexed access with O(1)
    static <T> void listReverseInplace(final List<T> inputs)
    {
        // run from left and right, swap the elements respectively
        int left = 0;
        int right = inputs.size() - 1;

        while (left < right)
        {
            final T leftValue = inputs.get(left);
            final T rightValue = inputs.get(right);

            inputs.set(left, rightValue);
            inputs.set(right, leftValue);

            left++;
            right--;
        }
    }

    static <T> List<T> listReverseWithStack(final List<T> inputs)
    {
        // Idea: Loop through the list from front to back (performant) and fill a stack
        final Stack<T> allValues = new Stack<>();
        final Iterator<T> it = inputs.iterator();
        while (it.hasNext())
        {
            allValues.push(it.next());
        }

        // Empty the stack and fill a new list
        final List<T> result = new ArrayList<>();
        while (!allValues.isEmpty())
        {
            final T value = allValues.pop();
            result.add(value);
        }
        return result;
    }
}
