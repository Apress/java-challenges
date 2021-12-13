package ch04_strings.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_CapitalizeTest
{
    @ParameterizedTest(name = "capitalize({0}) => {1}")
    @CsvSource({ "this is a very special title, This Is A Very Special Title",
    "effective java is great, Effective Java Is Great" })
    void capitalize(String input, String expected)
    {
        var result = Ex07_Capitalize.capitalize(input);

        assertEquals(expected, result);
    }

    @Test
    void capitalizeWIthList()
    {
        List<String> input = List.of("this", "is", "a", "special", "title");

        var result = Ex07_Capitalize.capitalize(input);

        assertEquals(List.of("This", "Is", "A", "Special", "Title"), result);
    }

    @Test
    void capitalizeWIthListAndStream()
    {
        List<String> input = List.of("this", "is", "a", "special", "title");

        var result = Ex07_Capitalize.capitalizeWithStream(input);

        assertEquals(List.of("This", "Is", "A", "Special", "Title"), result);
    }

    @Test
    void capitalizeSpecial()
    {
        List<String> input = List.of("this", "is", "a", "special", "title");

        var result = Ex07_Capitalize.capitalizeSpecial(input, List.of("is", "a"));

        assertEquals(List.of("This", "is", "a", "Special", "Title"), result);
    }

    @Test
    void capitalizeSpecial2()
    {
        List<String> input = List.of("effective", "java", "is", "great");

        var result = Ex07_Capitalize.capitalizeSpecial(input, List.of("is", "a"));

        assertEquals(List.of("Effective", "Java", "is", "Great"), result);
    }
}
