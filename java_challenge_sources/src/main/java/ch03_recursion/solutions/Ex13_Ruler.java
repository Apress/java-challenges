package ch03_recursion.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex13_Ruler
{
    private Ex13_Ruler()
    {
    }

    public static void drawRuler(final int majorTickCount, final int maxLength)
    {
        drawLine(maxLength, "0");

        for (int i = 1; i < majorTickCount; i++)
        {
            drawInterval(maxLength - 1);
            drawLine(maxLength, "" + i);
        }
    }

    public static void drawInterval(final int centerLength)
    {
        if (centerLength > 0)
        {
            drawInterval(centerLength - 1);
            drawLine(centerLength, "");
            drawInterval(centerLength - 1);
        }
    }

    private static void drawLine(int count, final String label)
    {
        System.out.println("-".repeat(count) + " " + label);
    }

    public static void main(String[] args)
    {
        drawRuler(3, 4);

        drawRulerDE(3, 4);
    }

    public static void drawRulerDE(final int majorTickCount, final int maxLength)
    {
        drawLine(maxLength, "0");

        for (int i = 1; i < majorTickCount; i++)
        {
            drawIntervalDE(maxLength / 2);
            drawLine(maxLength, "" + i);
        }
    }

    public static void drawIntervalDE(final int centerLength)
    {
        if (centerLength > 0)
        {
            drawLine(1, "");
            drawLine(1, "");
            drawLine(1, "");
            drawLine(1, "");
            drawLine(centerLength, "");
            drawLine(1, "");
            drawLine(1, "");
            drawLine(1, "");
            drawLine(1, "");
        }
    }
}