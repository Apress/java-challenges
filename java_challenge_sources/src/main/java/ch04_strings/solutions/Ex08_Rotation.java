package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_Rotation
{
    private Ex08_Rotation()
    {
    }

    static boolean containsRotation(final String str1, final String str2)
    {
        final String newDoubledStr1 = (str1 + str1).toLowerCase();

        return newDoubledStr1.indexOf(str2.toLowerCase()) != -1;
    }
}
