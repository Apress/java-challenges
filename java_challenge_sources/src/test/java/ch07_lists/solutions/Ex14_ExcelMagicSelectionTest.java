package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex14_ExcelMagicSelectionTest
{
    @ParameterizedTest(name = "generateFollowingValues({0}, {1}) = {2}")
    @MethodSource("simpleInputs")
    void generateFollowingValues(final int startValue, final int sequenceLength, final List<Integer> expected)
    {
        final var result =
                        Ex14_ExcelMagicSelection.generateFollowingValues(startValue, sequenceLength);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "generateFollowingValuesOwn({0}, {1}) = {2}")
    @MethodSource("enumInputs")
    void generateFollowingValues(final DayOfWeek startValue,
                                 final int sequenceLength,
                                 final List<DayOfWeek> expected)
    {
        final var result =
                        Ex14_ExcelMagicSelection.generateFollowingValues(startValue,
                                                                         sequenceLength);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "generateFollowingValuesEnum({0}, {1}) = {2}")
    @MethodSource("enumInputs")
    void generateFollowingValuesEnum(final DayOfWeek startValue, final int sequenceLength,
                                     final List<DayOfWeek> expected)
    {
        final List<DayOfWeek> result =
                        Ex14_ExcelMagicSelection.generateFollowingValues(startValue,
                                                                         sequenceLength);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "generateFollowingValuesLocalDate({0}, {1}) " +
                    "last day should be {2}")
    @CsvSource( { "2020-03-13, 8, 2020-03-20", "2010-01-01, 38, 2010-02-07",
    "2010-02-07, 366, 2011-02-07" } )
    void generateFollowingValuesLocalDate(final LocalDate startValue,
                                          final int sequenceLength,
                                          final LocalDate expectedEndDate)
    {
        final var expected =
                        startValue.datesUntil(startValue.plusDays(sequenceLength)).
                        collect(Collectors.toList());

        final var result =
                        Ex14_ExcelMagicSelection.generateFollowingValuesV2(startValue,
                                                                           sequenceLength);

        assertAll(() -> assertEquals(expected, result),
                  () -> assertEquals(expectedEndDate,
                                     result.get(result.size()-1)));
    }


    static Stream<Arguments> simpleInputs()
    {
        return Stream.of(Arguments.of(1, 7, List.of(1, 2, 3, 4, 5, 6, 7)),
                         Arguments.of(5, 4, List.of(5, 6, 7, 8)));
    }

    static Stream<Arguments> enumInputs()
    {
        return Stream.of(Arguments.of(DayOfWeek.MONDAY, 3,
                                      List.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                                              DayOfWeek.WEDNESDAY)),
                         Arguments.of(DayOfWeek.FRIDAY, 8,
                                      List.of(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                                              DayOfWeek.SUNDAY, DayOfWeek.MONDAY,
                                              DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                                              DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)));
    }
}
