package ch05_arrays.solutions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_FloodFillExampleTest
{
    @ParameterizedTest(name = "{0}, {4}")
    @MethodSource("createWorldAndExpectedFills")
    public void floodFill(final char[][] world, final char[][] expected, final int startX, final int startY,
                          final String hint)
    {
        Ex10_FloodFillExample.floodFill(world, startX, startY);
        ArrayUtils.printArray(world);

        assertArrayEquals(expected, world);
    }

    @ParameterizedTest(name = "{0}, {4}")
    @MethodSource("createWorldAndExpectedFills")
    public void floodFillV2(final char[][] world, final char[][] expected, final int startX, final int startY,
                            final String hint)
    {
        Ex10_FloodFillExample.floodFillV2(world, startX, startY);
        ArrayUtils.printArray(world);

        assertArrayEquals(expected, world);
    }

    private static Stream<Arguments> createWorldAndExpectedFills()
    {
        return Stream.of(Arguments.of(firstWorld(), firstFilled(), 0, 0, "rect"),
                         Arguments.of(nonRectWorld(), nonRectFilled(), 4, 4, "no rect"));
    }

    private static char[][] firstWorld()
    {
        return new char[][] { "   #  ".toCharArray(),
            "    # ".toCharArray(),
            "#   # ".toCharArray(),
            " # #  ".toCharArray(),
            "  #   ".toCharArray()};
    }

    private static char[][] firstFilled()
    {
        return new char[][] { "***#  ".toCharArray(),
            "****# ".toCharArray(),
            "#***# ".toCharArray(),
            " #*#  ".toCharArray(),
            "  #   ".toCharArray()};
    }

    private static char[][] nonRectWorld()
    {
        return new char[][] { "   #      #".toCharArray(),
            "    #      #".toCharArray(),
            "#   #     #".toCharArray(),
            " # #     #".toCharArray(),
            "  #     #".toCharArray()};
    }

    private static char[][] nonRectFilled()
    {
        return new char[][] { "   #******#".toCharArray(),
            "    #******#".toCharArray(),
            "#   #*****#".toCharArray(),
            " # #*****#".toCharArray(),
            "  #*****#".toCharArray()};
    }
}
