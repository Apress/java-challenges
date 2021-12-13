package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class Ex01_BasiscsTest
{
    @ParameterizedTest
    @CsvSource({ "6, 7, 0", "3, 4, 6", "5, 5, 5" })
    void calc(int m, int n, int expected)
    {
        int result = Ex01_Basiscs.calc(m, n);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "sum and count for {0} = {1}")
    @MethodSource("argumentProvider")
    public void calcSumAndCountAllNumbersDivBy_2_Or_7(int max,
                                                      Map<Ex01_Basiscs.ReturnCode, Integer> expected)
    {
        var result = Ex01_Basiscs.calcSumAndCountAllNumbersDivBy_2_Or_7(max);

        assertEquals(expected, result);
    }

    static Stream<Arguments> argumentProvider()
    {
        return Stream.of(Arguments.of(3, Map.of(Ex01_Basiscs.ReturnCode.SUM, 2,
                                                Ex01_Basiscs.ReturnCode.COUNT, 1)),
                         Arguments.of(8, Map.of(Ex01_Basiscs.ReturnCode.SUM, 19,
                                                Ex01_Basiscs.ReturnCode.COUNT, 4)),
                         Arguments.of(15, Map.of(Ex01_Basiscs.ReturnCode.SUM, 63,
                                                 Ex01_Basiscs.ReturnCode.COUNT, 8)));
    }

    @ParameterizedTest
    @CsvSource({ "2, true, 3, false, 4, true" })
    void evenOddTest(int n, boolean expected)
    {
        boolean resultEven = Ex01_Basiscs.isEven(n);
        boolean resultOdd = Ex01_Basiscs.isOdd(n);

        assertAll(() -> assertEquals(expected, resultEven),
                  () -> assertEquals(expected, !resultOdd));
    }
}