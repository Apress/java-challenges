package ch07_lists.solutions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex14_ExcelMagicSelection
{
    public static void main(final String[] args)
    {
        final List<Integer> nextValues1 = generateFollowingValues(2, 7);
        System.out.println(nextValues1);

        final List<Integer> nextValues1b = generateFollowingValues(2, 7);
        System.out.println(nextValues1b);

        final List<LocalDate> nextValues2 = generateFollowingValuesV2(LocalDate.of(2019, 1, 1), 7);
        System.out.println(nextValues2);

        final List<DayOfWeek> nextValues3 = generateFollowingValues(DayOfWeek.WEDNESDAY, 7);
        System.out.println(nextValues3);

        final List<DayOfWeek> nextValues4 = generateFollowingValues(DayOfWeek.WEDNESDAY, 7);
        System.out.println(nextValues4);
    }


    // with out stream API

    // on your own
    static List<Integer> generateFollowingValues(int currentValue, int sequenceLength)
    {
        final List<Integer> result = new ArrayList<>();

        while (sequenceLength-- > 0)
        {
            result.add(currentValue);
            currentValue++;
        }

        return result;
    }

    static List<DayOfWeek> generateFollowingValues(final DayOfWeek startDay, int sequenceLength)
    {
        final DayOfWeek[] allWeekDays = DayOfWeek.values();
        int currentPos = find(allWeekDays, startDay);

        final List<DayOfWeek> result = new ArrayList<>();

        DayOfWeek nextDay = startDay;
        while (sequenceLength-- > 0)
        {
            result.add(nextDay);
            nextDay = nextCyclic(allWeekDays, currentPos);
            currentPos++;
        }

        return result;
    }

    static <T> int find(final T[] values, final T searchFor)
    {
        for (int i = 0; i < values.length; i++)
        {
            if (values[i].equals(searchFor))
                return i;
        }

        return -1;
    }

    static <T> T nextCyclic(final T[] values, final int currentPos)
    {
        final int nextPos = (currentPos + 1) % values.length;

        return values[nextPos];
    }

    static List<DayOfWeek> generateFollowingValuesShorter(final DayOfWeek startDay, int sequenceLength)
    {
        final DayOfWeek[] allWeekDays = DayOfWeek.values();
        int currentPos = startDay.getValue() - 1;

        final List<DayOfWeek> result = new ArrayList<>();

        DayOfWeek nextDay = startDay;
        while (sequenceLength-- > 0)
        {
            result.add(nextDay);
            nextDay = nextCyclic(allWeekDays, currentPos);
            currentPos++;
        }

        return result;
    }

    static List<DayOfWeek> generateFollowingValuesSimpler(final DayOfWeek startDay, int sequenceLength)
    {
        final List<DayOfWeek> result = new ArrayList<>();

        DayOfWeek nextDay = startDay;
        while (sequenceLength > 0)
        {
            result.add(nextDay);
            nextDay = nextDay.plus(1);
            sequenceLength--;
        }

        return result;
    }

    // easy with Stream-API

    static List<Integer> generateFollowingValuesV2(final int startValue, final int sequenceLength)
    {
        return IntStream.iterate(startValue, n -> n + 1).limit(sequenceLength).boxed().collect(Collectors.toList());
    }

    static List<LocalDate> generateFollowingValuesV2(final LocalDate startValue, final int sequenceLength)
    {
        return Stream.iterate(startValue, day -> day.plusDays(1)). // Attention: startValue.plusDays(1) => counts up only once
                        limit(sequenceLength).collect(Collectors.toList());
    }

    // simple
    static List<DayOfWeek> generateFollowingValuesV2(final DayOfWeek startDay, final int sequenceLength)
    {
        return Stream.iterate(startDay, day -> day.plus(1)).limit(sequenceLength).collect(Collectors.toList());
    }
}
