package ch05_arrays.solutions;

import static org.junit.Assert.assertArrayEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex14_MinesweeperTest
{
    @ParameterizedTest
    @MethodSource("createBombArrayAndExpected")
    public void calcBombCount(boolean[][] bombs, int[][] expecteds)
    {
        int[][] result = Ex14_Minesweeper.calcBombCount(bombs);

        assertArrayEquals(expecteds, result);
    }

    @ParameterizedTest
    @MethodSource("createBombArrayAndExpected")
    public void calcBombCountV1(boolean[][] bombs, int[][] expecteds)
    {
        int[][] result = Ex14_Minesweeper.calcBombCountV1(bombs);

        assertArrayEquals(expecteds, result);
    }

    private static Stream<Arguments> createBombArrayAndExpected()
    {
        String[] bombs1 = { "*..", "..*", "..*" };

        String[] result1 = { "B21", "13B", "02B" };

        String[] bombs2 = { ".**..", "*.**.", "**...", "*..*.", "***.." };

        String[] result2 = { "2BB31", "B6BB1", "BB432", "B64B1", "BBB21" };

        return Stream.of(Arguments.of(toBoolArray(bombs1), toIntArray(result1)),
                         Arguments.of(toBoolArray(bombs2), toIntArray(result2)));
    }

    // Hiding the border field logic and conversion
    static boolean[][] toBoolArray(final String[] bombs)
    {
        final int width = bombs[0].length();
        final int height = bombs.length;

        final boolean[][] result = new boolean[height + 2][width + 2];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                if (bombs[y].charAt(x) == '*')
                    result[y + 1][x + 1] = true;
            }
        }

        return result;
    }

    static int[][] toIntArray(final String[] values)
    {
        final int width = values[0].length();
        final int height = values.length;

        final int[][] result = new int[height + 2][width + 2];

        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                final char currentChar = values[y].charAt(x);
                if (currentChar == 'B')
                    result[y + 1][x + 1] = 9;
                else
                    result[y + 1][x + 1] = Character.getNumericValue(currentChar);
            }
        }

        return result;
    }
}
