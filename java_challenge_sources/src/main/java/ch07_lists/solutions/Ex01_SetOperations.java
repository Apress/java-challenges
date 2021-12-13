package ch07_lists.solutions;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_SetOperations
{
    private Ex01_SetOperations()
    {
    }

    public static void main(final String[] args)
    {
        System.out.println(findCommon(List.of(1, 2, 4, 7, 8), List.of(2, 3, 7, 9)));
        System.out.println(findCommon(List.of(2, 4, 6, 8), List.of(1, 3, 5, 7, 9)));
        System.out.println(findCommon(List.of(1, 2, 7, 4, 7, 8), List.of(7, 7, 3, 2, 9)));

        System.out.println(findCommonNoJdk(List.of(1, 2, 4, 7, 8), List.of(2, 3, 7, 9)));
        System.out.println(findCommonNoJdk(List.of(2, 4, 6, 8), List.of(1, 3, 5, 7, 9)));
        System.out.println(findCommonNoJdk(List.of(1, 2, 7, 4, 7, 8), List.of(7, 7, 3, 2, 9)));

        performSetOperations(List.of(1, 2, 3, 4, 5), List.of(2, 4, 6, 7, 8));

        performSetOperations(List.of(2, 4, 6, 8), List.of(1, 3, 5, 7));
    }

    static void performSetOperations(final Collection<Integer> colA, final Collection<Integer> colB)
    {
        System.out.println("A: " + colA);
        System.out.println("B: " + colB);
        System.out.println("dif A-B: " + difference(colA, colB));
        System.out.println("dif B-A: " + difference(colB, colA));
        System.out.println("uni A+B: " + union(colA, colB));
        System.out.println("sec A+B: " + intersection(colA, colB));
        System.out.println();
    }

    static <T> Set<T> difference(final Collection<T> collection1, final Collection<T> collection2)
    {
        // needed, because List.of() unmodifiable
        final Set<T> results = new HashSet<>(collection1);
        results.removeAll(collection2);

        return results;
    }

    static <T> Set<T> union(final Collection<T> collection1, final Collection<T> collection2)
    {
        // needed, because List.of() unmodifiable
        final Set<T> results = new HashSet<>(collection1);
        results.addAll(collection2);

        return results;
    }

    static <T> Set<T> intersection(final Collection<T> collection1, final Collection<T> collection2)
    {
        // needed, because List.of() unmodifiable
        final Set<T> results = new HashSet<>(collection1);
        results.retainAll(collection2);

        return results;
    }

    //

    static <T> Set<T> differenceV2(final Collection<T> collection1, final Collection<T> collection2)
    {
        return collection1.stream().filter(element -> !collection2.contains(element)).collect(Collectors.toSet());
    }

    static <T> Set<T> unionV2(final Collection<T> collection1, final Collection<T> collection2)
    {
        return Stream.concat(collection1.stream(), collection2.stream()).collect(Collectors.toSet());
    }

    static <T> Set<T> intersectionV2(final Collection<T> collection1, final Collection<T> collection2)
    {
        return collection1.stream().filter(element -> collection2.contains(element)).collect(Collectors.toSet());
    }

    //

    static <T> Set<T> findCommon(final Collection<T> collection1, final Collection<T> collection2)
    {
        final Set<T> results = new HashSet<>(collection1);
        results.retainAll(collection2);

        return results;
    }

    static <T> Set<T> findCommonNoJdk(final Collection<T> collection1, final Collection<T> collection2)
    {
        final Map<T, Long> results = new HashMap<>();

        populateFromCollection1(collection1, results);
        markIfAlsoInSecond(collection2, results);

        return removeAllJustInOneCollection(results);
    }

    static <T> void populateFromCollection1(final Collection<T> collection1, final Map<T, Long> results)
    {
        for (final T elem1 : collection1)
        {
            results.put(elem1, 1L);
        }
    }

    static <T> void markIfAlsoInSecond(final Collection<T> collection2, final Map<T, Long> results)
    {
        for (final T elem2 : collection2)
        {
            results.computeIfPresent(elem2, (key, value) -> value + 1);
        }
    }

    static <T> Set<T> removeAllJustInOneCollection(final Map<T, Long> results)
    {
        return results.entrySet().stream().filter(entry -> entry.getValue() >= 2).map(entry -> entry.getKey())
                        .collect(Collectors.toSet());
    }

    static <T> Set<T> findCommonTwoLoops(final Collection<T> collection1, final Collection<T> collection2)
    {
        final Set<T> results = new HashSet<>();

        for (T elem1 : collection1)
        {
            for (T elem2 : collection2)
            {
                if (elem1.equals(elem2))
                    results.add(elem1);
            }
        }

        return results;
    }
}
