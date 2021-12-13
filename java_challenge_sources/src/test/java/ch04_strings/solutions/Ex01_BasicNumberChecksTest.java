package ch04_strings.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_BasicNumberChecksTest
{
    @ParameterizedTest(name = "isBinaryNumber({0}) => {1}")
    @CsvSource({ "10101, true", "222, false", "12345, false" })
    public void isBinaryNumber(String value, boolean expected)
    {
        boolean result = Ex01_BasicNumberChecks.isBinaryNumber(value);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "binaryToDecimal({0}) => {1}")
    @CsvSource({ "111, 7", "1010, 10", "1111, 15", "10000, 16" })
    public void binaryToDecimal(String value, int expected)
    {
        int result = Ex01_BasicNumberChecks.binaryToDecimal(value);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "hexToDecimal({0}) => {1}")
    @CsvSource({ "7, 7", "A, 10", "F, 15", "10, 16" })
    public void hexToDecimal(String value, int expected)
    {
        int result = Ex01_BasicNumberChecks.hexToDecimal(value);

        assertEquals(expected, result);
    }
}
