package ch05_arrays.solutions;

import java.util.EnumSet;

import ch05_arrays.intro.Direction;
import ch05_arrays.util.ArrayUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_FllodFillExampleWithPattern
{
    public static void main(final String[] args)
    {
        System.out.println("World Pos 1");
        final char[][] world1 = generateBigWorld();
        final char[][] pattern = generatePattern();
        ArrayUtils.printArray(world1);
        floodFill(world1,1,1, pattern);
        System.out.println("------------");
        ArrayUtils.printArray(world1);

        System.out.println("World1 Pos2");
        final char[][] world2 = generateBigWorld();
        final char[][] pattern2 = generatePattern2();
        floodFill(world2, 9, 5, pattern2);
        System.out.println("------------");
        ArrayUtils.printArray(world2);

    }

    private static char[][] generateBigWorld()
    {
        return new char[][] { "           #   |".toCharArray(), "       ##   #   |".toCharArray(),
            "    #####    #   __".toCharArray(), "       ###   #     |".toCharArray(),
            " ###    #    #      |".toCharArray(), "    #   #    #     |".toCharArray(),
            "     # #    #    --".toCharArray(), "      #    #    |".toCharArray(), };
    }

    private static char[][] generatePattern()
    {
        return new char[][] { ".||.".toCharArray(), "-/\\-".toCharArray(), "-\\/-".toCharArray(),
            ".||.".toCharArray(), };
    }


    private static char[][] generatePattern2()
    {
        return new char[][] { ".|.".toCharArray(), "-*-".toCharArray(), ".|.".toCharArray(), };
    }

    //

    static void floodFill(final char[][] values, final int x, final int y,
                          final char[][] pattern)
    {
        if (x < 0 || y < 0 || y >= values.length || x >= values[y].length)
            return;

        if (values[y][x] == ' ')
        {
            values[y][x] = findFillChar(x, y, pattern);

            final EnumSet<Direction> directions = EnumSet.of(Direction.N,
                                                             Direction.E,
                                                             Direction.S,
                                                             Direction.W);

            for (final Direction dir : directions)
            {
                floodFill(values, x + dir.dx, y + dir.dy, pattern);
            }
        }
    }

    private static char findFillChar(final int x, final int y, final char[][] pattern)
    {
        final int maxY = pattern.length;
        final int maxX = pattern[0].length;

        final int adjustedX = x % maxX;
        final int adjustedY = y % maxY;

        return pattern[adjustedY][adjustedX];
    }

    private static void setAt(final char[][] values, final int x, final int y, final char value)
    {
        values[y][x] = value;
    }
}
