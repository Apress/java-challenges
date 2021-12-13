package ch05_arrays.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_SpiralTraversal
{
    private Ex07_SpiralTraversal()
    {
    }

    static <T> List<T> spiralTraversal(final T[][] values)
    {
        int posX = 0;
        int posY = 0;

        int minX = 0;
        int maxX = values[0].length;
        int minY = 1;
        int maxY = values.length;

        final List<T> results = new ArrayList<>();

        Direction dir = Direction.RIGHT;
        int steps = 0;
        final int allSteps = maxY * maxX;
        while (steps < allSteps)
        {
            // action
            results.add(values[posY][posX]);

            if (dir == Direction.RIGHT)
            {
                if (posX < maxX - 1)
                    posX++;
                else
                {
                    dir = Direction.DOWN;
                    maxX--;
                }
            }
            if (dir == Direction.DOWN)
            {
                if (posY < maxY - 1)
                    posY++;
                else
                {
                    dir = Direction.LEFT;
                    maxY--;
                }
            }
            if (dir == Direction.LEFT)
            {
                if (posX > minX)
                    posX--;
                else
                {
                    dir = Direction.UP;
                    minX++;
                }
            }
            if (dir == Direction.UP)
            {
                if (posY > minY)
                    posY--;
                else
                {
                    dir = Direction.RIGHT;
                    minY++;
                    // Possible error: you must now start one further to the right!
                    posX++;
                }
            }

            steps++;
        }

        return results;
    }

    enum Direction {
        RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0), UP(0, -1);

        int dx;
        int dy;

        Direction(final int dx, final int dy)
        {
            this.dx = dx;
            this.dy = dy;
        }

        Direction next()
        {
            return values()[(this.ordinal() + 1) % 4];
        }
    }

    static <T> List<T> spiralTraversalOptimized(final T[][] board)
    {
        int minX = 0;
        int maxX = board[0].length;
        int minY = 0;
        int maxY = board.length;

        int x = 0;
        int y = 0;
        Direction dir = Direction.RIGHT;

        final List<T> result = new ArrayList<>();

        int steps = 0;
        final int allSteps = maxX * maxY;
        while (steps < allSteps)
        {
            result.add(board[y][x]);

            if (isOutside(x + dir.dx, y + dir.dy, minX, maxX, minY, maxY))
            {
                switch (dir)
                {
                    case RIGHT -> minY++;
                    case DOWN -> maxX--;
                    case LEFT -> maxY--;
                    case UP -> minX++;
                }
                dir = dir.next();
            }

            x += dir.dx;
            y += dir.dy;
            steps++;
        }

        return result;
    }

    private static boolean isOutside(final int x, final int y, final int minX, final int maxX, final int minY,
                                     final int maxY)
    {
        return !(x >= minX && x < maxX && y >= minY && y < maxY);
    }
}
