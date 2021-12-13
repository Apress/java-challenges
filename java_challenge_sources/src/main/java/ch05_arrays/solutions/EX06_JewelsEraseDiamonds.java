package ch05_arrays.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import ch05_arrays.intro.Direction;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class EX06_JewelsEraseDiamonds
{
    private EX06_JewelsEraseDiamonds()
    {
    }

    public static boolean eraseChains(final int[][] values)
    {
        markElementsForRemoval(values);

        return eraseAllMarked(values);
    }

    static void markElementsForRemoval(final int[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final List<Direction> dirsWithChains = findChains(values, x, y);

                markDirectionsForRemoval(values, x, y, dirsWithChains);
            }
        }
    }

    private static boolean isMarkedForRemoval(final int value)
    {
        return value < 0;
    }

    static boolean eraseAllMarked(final int[][] values)
    {
        boolean erasedSomething = false;

        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                if (isMarkedForRemoval(values[y][x]))
                {
                    values[y][x] = 0;
                    erasedSomething = true;
                }
            }
        }

        return erasedSomething;
    }

    static List<Direction> findChains(final int[][] values, final int startX, final int startY)
    {
        final int origValue = values[startY][startX];
        if (origValue == 0) // ATTENTION to think of such special cases
            return Collections.emptyList();

        final List<Direction> dirsWithChains = new ArrayList<>();

        final var relevantDirs = EnumSet.of(Direction.S, Direction.SW, Direction.E, Direction.SE);
        for (final Direction currentDir : relevantDirs)
        {
            int length = 1;

            // check next position
            int nextPosX = startX + currentDir.dx;
            int nextPosY = startY + currentDir.dy;

            while (isOnBoard(values, nextPosX, nextPosY) && isSame(origValue, values[nextPosY][nextPosX]))
            {
                length++;

                nextPosX += currentDir.dx;
                nextPosY += currentDir.dy;
            }

            if (length >= 3)
            {
                dirsWithChains.add(currentDir);
            }
        }

        return dirsWithChains;
    }

    static boolean isOnBoard(final int[][] values, final int nextPosX, final int nextPosY)
    {
        // Assumption: Rectangular array => should be clarified by question
        return nextPosX >= 0 && nextPosY >= 0 && nextPosX < values[0].length && nextPosY < values.length;
    }

    static boolean isSame(final int val1, final int val2)
    {
        return Math.abs(val1) == Math.abs(val2);
    }

    static void markDirectionsForRemoval(final int[][] values, final int startX, final int startY,
                                         final List<Direction> dirsWithChains)
    {
        final int origValue = values[startY][startX];

        for (final Direction currentDir : dirsWithChains)
        {
            int nextPosX = startX;
            int nextPosY = startY;

            while (isOnBoard(values, nextPosX, nextPosY) && isSame(origValue, values[nextPosY][nextPosX]))
            {
                values[nextPosY][nextPosX] = markForRemoval(origValue);

                nextPosX += currentDir.dx;
                nextPosY += currentDir.dy;
            }
        }
    }

    static int markForRemoval(final int value)
    {
        return value > 0 ? -value : value;
    }

    private static boolean isBlank(final int value)
    {
        return value == 0;
    }

    static void fallDown(final int[][] values)
    {
        for (int x = 0; x < values[0].length; x++)
        {
            for (int y = values.length - 1; y > 0; y--)
            {
                int currentY = y;
                // fall down until there is no more empty space below it
                while (currentY < values.length && isBlank(values[currentY][x]))
                {
                    // fall down
                    values[currentY][x] = values[currentY - 1][x];
                    values[currentY - 1][x] = 0;

                    currentY++;
                }
            }
        }
    }


    // Variant for char
    // ################

    public static boolean eraseChains(final char[][] values)
    {
        markForRemoval(values);

        return eraseAllMarked(values);
    }

    static void markForRemoval(final char[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final List<Direction> dirsWithChains = findChains(values, x, y);

                markDirectionForRemoval(values, x, y, dirsWithChains);
            }
        }
    }

    static List<Direction> findChains(final char[][] values, final int startX, final int startY)
    {
        final EnumSet<Direction> relevantDirs = EnumSet.of(Direction.S, Direction.SW, Direction.E, Direction.SE);

        final char origValue = values[startY][startX];
        if (isBlank(origValue)) // ATTENTION to think of such special cases
            return Collections.emptyList();

        final List<Direction> dirsWithChains = new ArrayList<>();

        for (final Direction currentDir : relevantDirs)
        {
            int length = 1;

            // check next position
            int nextPosX = startX + currentDir.dx;
            int nextPosY = startY + currentDir.dy;

            while (isOnBoard(values, nextPosX, nextPosY) && isSame(origValue, values[nextPosY][nextPosX]))
            {
                length++;

                nextPosX += currentDir.dx;
                nextPosY += currentDir.dy;
            }

            if (length >= 3)
            {
                dirsWithChains.add(currentDir);
            }
        }

        return dirsWithChains;
    }

    static void markDirectionForRemoval(final char[][] values, final int startX, final int startY,
                                        final List<Direction> dirsWithChains)
    {
        final char origValue = values[startY][startX];

        for (final Direction currentDir : dirsWithChains)
        {
            int nextPosX = startX;
            int nextPosY = startY;

            while (isOnBoard(values, nextPosX, nextPosY) && isSame(origValue, values[nextPosY][nextPosX]))
            {
                values[nextPosY][nextPosX] = markForRemoval(origValue);

                nextPosX += currentDir.dx;
                nextPosY += currentDir.dy;
            }
        }
    }

    static char markForRemoval(final char value)
    {
        return Character.toLowerCase(value);
    }

    static boolean eraseAllMarked(final char[][] values)
    {
        boolean erasedSomething = false;

        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                if (isMarkedForRemoval(values[y][x]))
                {
                    values[y][x] = ' ';
                    erasedSomething = true;
                }
            }
        }

        return erasedSomething;
    }

    static boolean isOnBoard(final char[][] values, final int nextPosX, final int nextPosY)
    {
        // Assumption: Rectangular array => should be clarified by question
        return nextPosX >= 0 && nextPosY >= 0 && nextPosX < values[0].length && nextPosY < values.length;
    }

    static boolean isSame(final char char1, final char char2)
    {
        return Character.toLowerCase(char1) == Character.toLowerCase(char2);
    }

    static boolean isMarkedForRemoval(final char value)
    {
        return Character.isLowerCase(value);
    }

    static boolean isBlank(final char value)
    {
        return value == '_' || value == ' ';
    }

    // always move all values completely per column
    static char[][] fallDown(final char[][] values)
    {
        for (int y = values.length - 1; y > 0; y--)
        {
            for (int x = 0; x < values[0].length; x++)
            {

                int currentY = y;
                // keep on falling, if elements below are empty
                while (currentY < values.length && isBlank(values[currentY][x]))
                {
                    // fall down
                    values[currentY][x] = values[currentY - 1][x];
                    values[currentY - 1][x] = '_';

                    currentY++;
                }
            }
        }
        return values;
    }
}
