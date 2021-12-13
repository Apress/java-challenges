package ch08_recursion_advanced.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_TowerOfHanoi
{
    private Ex01_TowerOfHanoi()
    {
    }

    public static void main(final String[] args)
    {
        solveTowerOfHanoi(1);
        solveTowerOfHanoi(2);
        solveTowerOfHanoi(3);

    }

    private static void solveTowerOfHanoi(final int n)
    {
        System.out.println("Tower Of Hanoi " + n);
        moveTower(n, 'A', 'B', 'C');
    }

    private static void moveTower(final int n, final char source, final char helper, final char destination)
    {
        if (n == 1)
        {
            System.out.println(source + " -> " + destination);
        }
        else
        {
            // move reduced by one from source to auxiliary stick, (target thus becomes the new auxiliary stick)
            moveTower(n-1, source, destination, helper);

            // move the largest disc
            moveTower(1, source, helper, destination);

            // move a reduced tower from auxiliary stick to target
            moveTower(n-1, helper, source, destination);
        }
    }
}
