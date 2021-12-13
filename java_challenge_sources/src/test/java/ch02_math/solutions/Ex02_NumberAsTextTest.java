package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
public class Ex02_NumberAsTextTest
{
    @ParameterizedTest
    @CsvSource({ "7, SEVEN", "42, FOUR TWO",
        "7271, SEVEN TWO SEVEN ONE",
        "24680, TWO FOUR SIX EIGHT ZERO",
                 "13579, ONE THREE FIVE SEVEN NINE" })
    public void numberAsText(final int number, final String expected)
    {
        final String result = Ex02_NumberAsText.numberAsText(number);

        assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource({"0, ZERO", "1, ONE", "2, TWO", "3, THREE", "4, FOUR",
        "5, FIVE", "6, SIX", "7, SEVEN", "8, EIGHT", "9, NINE"})
    public void digitAsText(final int number, final String expected)
    {
        final String result = Ex02_NumberAsText.digitAsText(number);

        assertEquals(expected, result);
    }

    // Variant, if the map is more extensive
    @ParameterizedTest
    @MethodSource("argumentProvider")
    public void digitAsText2(final int number, final String expected)
    {
        final String result = Ex02_NumberAsText.digitAsText(number);

        assertEquals(expected, result);
    }

    static Map<Integer, String> valueToTextMap = Map.of(0, "ZERO",
                                                        1, "ONE", 2, "TWO", 3, "THREE", 4, "FOUR", 5, "FIVE",
                                                        6, "SIX", 7, "SEVEN", 8, "EIGHT", 9, "NINE");

    static Stream<Arguments> argumentProvider()
    {
        final List<Arguments> arguments = new ArrayList<>();

        valueToTextMap.forEach((key, value) -> arguments.add(Arguments.of(key, value)));
        System.out.println(arguments);
        return arguments.stream();
    }
}
