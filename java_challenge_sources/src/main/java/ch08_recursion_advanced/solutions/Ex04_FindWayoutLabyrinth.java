package ch08_recursion_advanced.solutions;

import java.lang.reflect.Array;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_FindWayoutLabyrinth
{
    private Ex04_FindWayoutLabyrinth()
    {
    }

    public static void main(final String[] args)
    {
        final char[][] world_old = { "#################".toCharArray(), "# #X        #  ##".toCharArray(),
                                     "#  ##### ####  ##".toCharArray(), "#  ##  #    #  ##".toCharArray(),
                                     "#    #  ###  # ##".toCharArray(), "# #  #     # # ##".toCharArray(),
                                     "# #   ####     ##".toCharArray(), "####   #     ####".toCharArray(),
                                     "######   ########".toCharArray(), "##     #     ####".toCharArray(),
                                     "#################".toCharArray(), };

        final char[][] world_with_loop = { "#################".toCharArray(), "# #         #  ##".toCharArray(),
                                           "#  ##### ####  ##".toCharArray(), "#  ## X      # ##".toCharArray(),
                                           "#    #  ###  # ##".toCharArray(), "# #  #       # ##".toCharArray(),
                                           "# #   ####     ##".toCharArray(), "####   #     ####".toCharArray(),
                                           "######   ########".toCharArray(), "##     #     ####".toCharArray(),
                                           "#################".toCharArray(), };

        final char[][] world_NO_WAY_OUT = { "##################################".toCharArray(),
                                            "# #         #    #     #  #   X# #".toCharArray(),
                                            "#  ##### #### ##   ##  #  # ###  #".toCharArray(),
                                            "#  ##  #    #  ## ##  #  #     # #".toCharArray(),
                                            "#    #  ###  # ## ##   #  #### # #".toCharArray(),
                                            "# #  #     # # ## ## ##  # ### # #".toCharArray(),
                                            "# #   ####     ## ##    # ###  # #".toCharArray(),
                                            "####   #     ####  ####  # ###  ##".toCharArray(),
                                            "######   #########   ##   # ###  #".toCharArray(),
                                            "##     #     ####  #  #  # ###  ##".toCharArray(),
                                            "##################################".toCharArray(), };

        final char[][] world_big = { "##################################".toCharArray(),
                                     "# #         #    #     #  #   X#X#".toCharArray(),
                                     "#  ##### #### ##   ##  #  # ###  #".toCharArray(),
                                     "#  ##  #    #  ## ##  #  #     # #".toCharArray(),
                                     "#    #  ###  # ## ##   #   ### # #".toCharArray(),
                                     "# #   ####     ##  ##     ###  # #".toCharArray(),
                                     "####   #     ####     #  # ####  #".toCharArray(),
                                     "######   #########   ##   # ###  #".toCharArray(),
                                     "##     #  X X####X #  #  # ###  ##".toCharArray(),
                                     "##################################".toCharArray() };

        final char[][][] worlds = { world_old, world_with_loop, world_NO_WAY_OUT, world_big };

        for (int i = 0; i < worlds.length; i++)
        {
            System.out.println("findWayOut");
            final char[][] world = deepCopyOf(worlds[i]);
            printArray(world);

            if (findWayOut(world, 1, 1))
                printArray(world);
            else
                System.out.println("NO WAY OUT");

            System.out.println("findWayOutWithResultSet");
            final char[][] world1 = deepCopyOf(worlds[i]);
            printArray(world1);

            final Set<String> results = findWayOutWithResultSet(world1, 1, 1);
            if (!results.isEmpty())
            {
                System.out.println(results);
                printArray(world1);
            }
            else
                System.out.println("NO WAY OUT 1");

            System.out.println("findWayOutV2");
            final char[][] world2 = deepCopyOf(worlds[i]);
            printArray(world2);

            if (findWayOutV2(world2, 1, 1))
                printArray(world2);
            else
                System.out.println("NO WAY OUT 2");
        }
    }

    static boolean findWayOut(final char[][] values, final int x, final int y)
    {
        if (x < 0 || y < 0 || x > values[0].length || y >= values.length)
            return false;

        if (values[y][x] == 'X')
        {
            System.out.println(String.format("FOUND EXIT: x: %d, y: %d", x, y));
            return true;
        }
        if (values[y][x] == '#')
            return false;

        // already visited
        if (values[y][x] == '.')
            return false;

        if (values[y][x] == ' ')
        {
            // mark as visitied
            values[y][x] = '.';

            // try up. left, down, right
            final boolean up = findWayOut(values, x, y - 1);
            final boolean left = findWayOut(values, x + 1, y);
            final boolean down = findWayOut(values, x, y + 1);
            final boolean right = findWayOut(values, x - 1, y);

            final boolean foundAWay = up || left || down || right;
            if (!foundAWay)
            {
                // wrong path, thus delete field marker
                values[y][x] = ' ';
            }
            return up || left || down || right;
        }

        throw new IllegalStateException("wrong char in labyrinth");
    }

    static boolean findWayOutV2(final char[][] board, final int x, final int y)
    {
        if (board[y][x] == '#')
            return false;

        boolean found = board[y][x] == 'X';
        if (found)
            System.out.printf("FOUND EXIT: x: %d, y: %d%n", x, y);

        board[y][x] = '#';
        found = found | findWayOutV2(board, x + 1, y);
        found = found | findWayOutV2(board, x - 1, y);
        found = found | findWayOutV2(board, x, y + 1);
        found = found | findWayOutV2(board, x, y - 1);
        return found;
    }

    static Set<String> findWayOutWithResultSet(final char[][] values, final int x, final int y)
    {
        final Set<String> results = new TreeSet<>();
        findWayOutWithResultSet(values, x, y, results);
        return results;
    }

    static boolean findWayOutWithResultSet(final char[][] values, final int x, final int y, final Set<String> results)
    {
        if (x < 0 || y < 0 || x > values[0].length || y >= values.length)
            return false;

        if (values[y][x] == 'X')
        {
            results.add(String.format("FOUND EXIT: x: %d, y: %d", x, y));
            return true;
        }
        if (values[y][x] == '#')
            return false;

        // already visited
        if (values[y][x] == '.')
            return false;

        if (values[y][x] == ' ')
        {
            // mark as visitied
            values[y][x] = '.';

            // try up. left, down, right
            final boolean up = findWayOutWithResultSet(values, x, y - 1, results);
            final boolean left = findWayOutWithResultSet(values, x + 1, y, results);
            final boolean down = findWayOutWithResultSet(values, x, y + 1, results);
            final boolean right = findWayOutWithResultSet(values, x - 1, y, results);

            final boolean foundAWay = up || left || down || right;
            if (!foundAWay)
            {
                // wrong path, thus delete field marker
                values[y][x] = ' ';
            }
            return up || left || down || right;
        }

        throw new IllegalStateException("wrong char in labyrinth");
    }

    public static void printArray(final char[][] values)
    {
        for (int y = 0; y < values.length; y++)
        {
            for (int x = 0; x < values[y].length; x++)
            {
                final char value = getAt(values, x, y);
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static char getAt(final char[][] values, final int x, final int y)
    {
        return values[y][x];
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] deepCopyOf(final T[] array)
    {
        if (array.length == 0)
            return array;

        return (T[]) deepCopyOf(array, Array.newInstance(array[0].getClass(), array.length), 0);
    }

    private static Object deepCopyOf(final Object array, final Object copiedArray, int index)
    {
        // recursive termination
        if (index >= Array.getLength(array))
            return copiedArray;

        final Object element = Array.get(array, index);

        //
        if (element.getClass().isArray())
        {
            // recursive descent => nested array
            Array.set(copiedArray, index,
                      deepCopyOf(element,
                                 Array.newInstance(element.getClass().getComponentType(), Array.getLength(element)),
                                 0));
        }
        else
        {
            Array.set(copiedArray, index, element);
        }

        // recursive descent => next position
        return deepCopyOf(array, copiedArray, index + 1);
    }
}
