package ch05_arrays.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex14_Minesweeper
{
    private Ex14_Minesweeper()
    {
    }

    static boolean[][] placeBombsRandomly(final int width, final int height, final double probability)
    {
        final boolean[][] bombs = new boolean[height + 2][width + 2];

        for (int i = 1; i < bombs.length - 1; i++)
        {
            for (int j = 1; j < bombs[0].length - 1; j++)
            {
                bombs[i][j] = Math.random() < probability;
            }
        }

        return bombs;
    }

    static int[][] calcBombCountV1(final boolean[][] bombs)
    {
        final int[][] bombCounts = new int[bombs.length][bombs[0].length];

        for (int y = 1; y < bombs.length - 1; y++)
        {
            for (int x = 1; x < bombs[0].length - 1; x++)
            {
                if (!bombs[y][x])
                {
                    // 3 x 3 grid of all neighbors
                    for (int subY = y - 1; subY <= y + 1; subY++)
                    {
                        for (int subX = x - 1; subX <= x + 1; subX++)
                        {
                            if (bombs[subY][subX])
                            {
                                bombCounts[y][x]++;
                            }
                        }
                    }
                }
                else
                {
                    bombCounts[y][x] = 9;
                }
            }
        }
        return bombCounts;
    }

    static int[][] calcBombCount(final boolean[][] bombs)
    {
        final int[][] bombCounts = new int[bombs.length][bombs[0].length];

        for (int y = 1; y < bombs.length - 1; y++)
        {
            for (int x = 1; x < bombs[0].length - 1; x++)
            {
                if (!bombs[y][x])
                {
                    for (final Direction currentDir : Direction.values())
                    {
                        if (bombs[y + currentDir.dy][x + currentDir.dx])
                        {
                            bombCounts[y][x]++;
                        }
                    }
                }
                else
                {
                    bombCounts[y][x] = 9;
                }
            }
        }

        return bombCounts;
    }

    enum Direction {
        N(0, -1), NE(1, -1), E(1, 0), SE(1, 1), S(0, 1), SW(-1, 1), W(-1, 0), NW(-1, -1);

        int dx;

        int dy;

        private Direction(final int dx, final int dy)
        {
            this.dx = dx;
            this.dy = dy;
        }
    }

    static void printBoard(final boolean[][] bombs, final char bombSymbol, final int[][] solution)
    {
        for (int y = 1; y < bombs.length - 1; y++)
        {
            for (int x = 1; x < bombs[0].length - 1; x++)
            {
                if (bombs[y][x])
                    System.out.print(bombSymbol + " ");
                else if (solution != null && solution.length != 0)
                {
                    System.out.print(solution[y][x] + " ");
                }
                else
                {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}