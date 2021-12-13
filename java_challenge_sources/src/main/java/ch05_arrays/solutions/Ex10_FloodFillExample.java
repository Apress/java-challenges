package ch05_arrays.solutions;

import java.util.EnumSet;

import ch05_arrays.intro.Direction;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_FloodFillExample
{
    private Ex10_FloodFillExample()
    {
    }

    static void floodFill(final char[][] values, final int x, final int y)
    {
        if (x < 0 || y < 0)
            return;

        if (y >= values.length || x >= values[y].length)
            return;

        if (values[y][x] == ' ')
        {
            values[y][x] = '*';

            // fill in all 4 dirs
            floodFill(values, x, y - 1);
            floodFill(values, x + 1, y);
            floodFill(values, x, y + 1);
            floodFill(values, x - 1, y);
        }
    }

    static void floodFillV2(final char[][] values, final int x, final int y)
    {
        if (x <0 || y < 0)
            return;

        final int maxY = values.length;
        final int maxX = values[0].length;

        if (x >= maxX || y >= maxY)
            return;

        if (values[y][x] == ' ')
        {
            values[y][x] = '*';

            // fill in all 4 dirs
            final EnumSet<Direction> directions = EnumSet.of(Direction.N,
                                                             Direction.E,
                                                             Direction.S,
                                                             Direction.W);

            for (final Direction dir : directions)
            {
                floodFillV2(values, x + dir.dx, y + dir.dy);
            }
        }
    }
}
