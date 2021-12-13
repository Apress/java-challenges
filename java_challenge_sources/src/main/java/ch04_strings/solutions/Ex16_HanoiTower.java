package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex16_HanoiTower
{
    private Ex16_HanoiTower()
    {
    }

    public static void main(final String[] args)
    {
        printTower(3);
        printTower(5);

        printTowerRec(3);
        printTowerRec(5);
    }

    static void printTower(final int height)
    {
        drawTop(height);
        drawSlices(height);
        drawBottom(height);
    }

    static void drawTop(final int height)
    {
        System.out.println(repeatCharSequence(" ", height + 1) + "|");
    }

    static void drawBottom(final int height)
    {
        System.out.println(repeatCharSequence("-", (height + 1) * 2 + 1));
    }

    static void drawSlices(final int height)
    {
        for (int i = height - 1; i >= 0; i--)
        {
            final int value = height - i;
            final int padding = i + 1;

            final String line = repeatCharSequence(" ", padding) + repeatCharSequence("#", value) + "|"
                            + repeatCharSequence("#", value);

            System.out.println(line);
        }
    }

    static String repeatCharSequence(final String character, final int length)
    {
        String str = "";
        for (int i = 0; i < length; i++)
        {
            str += character;
        }

        return str;
    }

    static void printTowerRec(final int height)
    {
        drawTop(height);
        drawSlices(height, height);
        drawBottom(height);
    }

    private static void drawSlices(final int slice, final int height)
    {
        if (slice > 0)
        {
            drawSlices(slice - 1, height);

            System.out.println(repeatCharSequence(" ", height - slice + 1) + repeatCharSequence("#", slice) + "|"
                            + repeatCharSequence("#", slice));
        }
    }
}
