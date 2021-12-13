package ch07_lists.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_RemoveDuplicates
{
    private Ex03_RemoveDuplicates()
    {
    }

    static <T> List<T> removeDuplicates(final List<T> inputs)
    {
        final List<T> result = new ArrayList<>(inputs);
        final Set<T> numbers = new HashSet<>();

        final Iterator<T> it = result.iterator();
        while (it.hasNext())
        {
            final T elem = it.next();

            // check for duplicate
            if (numbers.contains(elem))
                it.remove();
            else
                numbers.add(elem);
        }

        return result;
    }

    static <T> List<T> removeDuplicatesV2(final List<T> inputs)
    {
        return new ArrayList<>(new LinkedHashSet<>(inputs));
    }

    static <T> List<T> removeDuplicatesV3(final List<T> inputs)
    {
        return inputs.stream().distinct().toList();
    }
}
