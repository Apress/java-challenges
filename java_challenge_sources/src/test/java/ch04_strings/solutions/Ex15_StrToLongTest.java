package ch04_strings.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
public class Ex15_StrToLongTest
{
    @ParameterizedTest
    @CsvSource({ "+123, 123", "-123, -123", "123, 123", "7271, 7271" })
    public void testStrToLongV1(String number, long expected)
    {
        long result = Ex15_StrToLong.strToLongV1(number);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "strToLongV2(\"{0}\") => {1}")
    @CsvSource({ "+123, 123", "-123, -123", "123, 123", "7271, 7271" })
    void testStrToLongV2(String number, long expected)
    {
        long result = Ex15_StrToLong.strToLongV2(number);

        assertEquals(expected, result);
    }

    @Test
    public void testStrToLongV2Error()
    {
        assertThrows(IllegalArgumentException.class,
                     () -> Ex15_StrToLong.strToLongV2("ABC"));
    }

    @ParameterizedTest(name = "strToLongBonus(\"{0}\") => {1}")
    @CsvSource({ "+123, 123", "-123, -123", "123, 123", "7271, 7271",
        "+077, 63", "-077, -63", "077, 63",
        "+0123, 83", "-0123, -83",  "0123, 83" })
    void testStrToLongBonus(String number, long expected)
    {
        long result = Ex15_StrToLong.strToLongBonus(number);

        assertEquals(expected, result);
    }

    @Test
    public void testStrToLongBonusError()
    {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                                                   () -> Ex15_StrToLong.strToLongBonus("0128"));

        assertTrue(ex.getMessage().contains("found digit >= 8"));
    }
}
