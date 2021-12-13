package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

/**
/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_Friday13thExampleTest
{
    @Test
    void testAllFriday13th()
    {
        final LocalDate start = LocalDate.of(2013, 1, 1);
        final LocalDate end = LocalDate.of(2016, 1, 1);

        final var result = Ex06_Friday13thExample.allFriday13th(start, end);

        // Trick: Use Stream.of() and map() to have less typing work
        final var expected  =  Stream.of("2013-09-13", "2013-12-13", "2014-06-13",
                                         "2015-02-13", "2015-03-13", "2015-11-13")
                        .
                        map(str -> LocalDate.parse(str)).
                        collect(Collectors.toList());
        assertEquals(expected, result);
    }

    @Test
    void testFriday13thGrouped()
    {
        final LocalDate start = LocalDate.of(2013, 1, 1);
        final LocalDate end = LocalDate.of(2016, 1, 1);

        final var result = Ex06_Friday13thExample.friday13thGrouped(start, end);

        final var expected = Map.of(2013, List.of(LocalDate.parse("2013-09-13"),
                                                  LocalDate.parse("2013-12-13")),
                                    2014, List.of(LocalDate.parse("2014-06-13")),
                                    2015, List.of(LocalDate.parse("2015-02-13"),
                                                  LocalDate.parse("2015-03-13"),
                                                  LocalDate.parse("2015-11-13")));

        assertEquals(expected, result);
    }
}
