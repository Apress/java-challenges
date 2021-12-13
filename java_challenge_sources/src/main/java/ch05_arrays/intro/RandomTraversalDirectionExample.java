package ch05_arrays.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class RandomTraversalDirectionExample
{
    public static void main(final String[] args)
    {
        final char[][] world =
                    {
                     "ABCDEf".toCharArray(),
                     "GHIJKL".toCharArray(),
                     "MNOPQR".toCharArray(),
                     "abcdef".toCharArray(),
                     "ghijkl".toCharArray(),
                    };

        Direction dir = Direction.provideRandomDirection();
        System.out.println("Direction: " + dir);

        int posX = 0;
        int posY = 0;

        int steps = 0;
        while (steps < 25)
        {
            System.out.print(world[posY][posX] + " ");

            if (!isOnBoard(world, posX + dir.dx, posY + dir.dy))
            {
                dir = selectNewDir(world, dir, posX, posY);
                System.out.println("\nNew Direction: " + dir);
            }

            posX += dir.dx;
            posY += dir.dy;
            steps++;
        }
    }

    static Direction selectNewDir(final char[][] world, Direction dir,
                                  final int posX, final  int posY)
    {
        Direction oldDir = dir;
        do
        {
            dir = Direction.provideRandomDirection();
        }
        while (!isOnBoard(world, posX + dir.dx, posY + dir.dy) || oldDir == dir);

        return dir;
    }

    private static boolean isOnBoard(final char[][] values,
                                     final int nextPosX, final int nextPosY)
    {
        // Assumption: Rectangular array => must be clarified by question
        return nextPosX >= 0 && nextPosY >= 0 &&
                        nextPosX < values[0].length && nextPosY < values.length;
    }
}
