package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex09_SimpleBracesChecker
{
    private Ex09_SimpleBracesChecker()
    {
    }

    static boolean checkBraces(final String input)
    {
        int openingCount = 0;

        for (int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);

            if (ch == '(')
            {
                openingCount++;
            }
            else if (ch == ')')
            {
                openingCount--;
                if (openingCount < 0)
                    return false;
            }
        }

        return openingCount == 0;
    }
}
