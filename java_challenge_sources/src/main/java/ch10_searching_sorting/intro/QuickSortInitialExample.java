package ch10_searching_sorting.intro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class QuickSortInitialExample
{
    private QuickSortInitialExample()
    {
    }

    public static void main(final String[] args)
    {
        final List<Integer> values1 = List.of(5, 2, 7, 1, 3, 6, 4, 8);
        final List<Integer> values2 = List.of(5, 2, 7, 9, 1, 6, 3, 4, 8);

        System.out.println(quickSort(values1));
        System.out.println(quickSort(values2));

        final List<Integer> values11 = List.of(5, 2, 7, 3, 1, 3, 6, 4, 8);
        final List<Integer> values22 = List.of(5, 2, 7, 9, 3, 1, 6, 3, 4, 8);

        System.out.println(quickSort(values11));
        System.out.println(quickSort(values22));

        final List<Integer> values7 = List.of(9, 7, 8);
        final List<Integer> values7b = List.of(9, 8, 7);
        final List<Integer> values8 = List.of(7, 8, 9);
        System.out.println(quickSort(values7));
        System.out.println(quickSort(values7b));
        System.out.println(quickSort(values8));

    }

    static List<Integer> quickSort(final List<Integer> values)
    {
        if (values.size() <= 1)
            return values;

        // collect all below / above pivot
        final Integer pivot = values.get(0);
        final List<Integer> belowOrEquals = collectAll(values.stream().skip(1),
                                                       cur -> cur <= pivot);
        final List<Integer> aboves = collectAll(values.stream().skip(1),
                                                cur -> cur > pivot);

        // recursive descent
        final List<Integer> sortedLowersPart = quickSort(belowOrEquals);
        final List<Integer> sortedUppersPart = quickSort(aboves);

        final List<Integer> result = new ArrayList<>();
        result.addAll(sortedLowersPart);
        result.add(pivot);
        result.addAll(sortedUppersPart);

        return result;
    }

    static List<Integer> collectAll(final Stream<Integer> values,
                                    final Predicate<Integer> condition)
    {
        return values.filter(condition).toList();
    }
}