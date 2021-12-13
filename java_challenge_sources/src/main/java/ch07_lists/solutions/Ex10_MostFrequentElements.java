package ch07_lists.solutions;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_MostFrequentElements
{
    private Ex10_MostFrequentElements()
    {
    }

    static Map<Integer, Long> valueCount(final List<Integer> values)
    {
        final Map<Integer, Long> valueToCount = new TreeMap<>();

        values.forEach(value -> {
            valueToCount.putIfAbsent(value, 0L);
            valueToCount.computeIfPresent(value, (orig, count) -> ++count);
        });
        return valueToCount;
    }

    static Map<Integer, Long> valueCountV2(final List<Integer> values)
    {
        return values.stream().collect(groupingBy(Integer::valueOf, counting()));
    }

    public static Map<Integer, Long> sortByValue(final Map<Integer, Long> counts)
    {
        return counts.entrySet().stream().sorted(Map.Entry.<Integer, Long> comparingByValue().reversed())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                                                  LinkedHashMap::new));
    }

    static Map<Object, Long> valueCountWrong(final List<Integer> values)
    {
        return values.stream().collect(Collectors.groupingBy(n -> n,
                                                             Collectors.counting()));
    }
}
