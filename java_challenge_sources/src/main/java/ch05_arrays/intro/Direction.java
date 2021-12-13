package ch05_arrays.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public enum Direction
{
    N(0, -1), NE(1, -1),
    E(1, 0), SE(1, 1),
    S(0,1), SW(-1,1),
    W(-1,0), NW(-1,-1);

    public final int dx;
    public final int dy;

    private Direction(final int dx, final int dy)
    {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction provideRandomDirection()
    {
        final Direction[] directions = values();
        final int randomIndex = (int) (Math.random() * directions.length);

        return directions[randomIndex];
    }
}