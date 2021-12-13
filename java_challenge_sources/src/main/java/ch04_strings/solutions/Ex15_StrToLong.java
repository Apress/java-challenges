package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex15_StrToLong
{
    private Ex15_StrToLong()
    {
    }

    static long strToLongV1(final String number)
    {
        final boolean isNegative = number.charAt(0) == '-';
        long value = 0;

        int pos = startsWithSign(number) ? 1 : 0;

        while (pos < number.length())
        {
            final int digitValue = number.charAt(pos) - '0';

            value = value * 10 + digitValue;

            pos++;
        }

        return isNegative ? -value : value;
    }

    private static boolean startsWithSign(final String number)
    {
        return number.charAt(0) == '-' || number.charAt(0) == '+';
    }

    // V2 with error handling for characters
    static long strToLongV2(final String number)
    {
        final boolean isNegative = number.charAt(0) == '-';
        long value = 0;

        int pos = startsWithSign(number) ? 1 : 0;

        while (pos < number.length())
        {
            if (!Character.isDigit(number.charAt(pos)))
                throw new IllegalArgumentException(number + " contains not only digits");

            final int digitValue = number.charAt(pos) - '0';

            value = value * 10 + digitValue;

            pos++;
        }

        return isNegative ? -value : value;
    }

    static long strToLongBonus(final String number)
    {
        final boolean isNegative = number.charAt(0) == '-';
        final boolean isOctal = number.charAt(0) == '0' ||
                        startsWithSign(number) && number.charAt(1) == '0';

        long value = 0;

        final int factor = isOctal ? 8 : 10;

        int pos = calcStartPos(number, isOctal);

        while (pos < number.length())
        {
            if (!Character.isDigit(number.charAt(pos)))
                throw new IllegalArgumentException(number + " contains not only digits");

            final int digitValue = number.charAt(pos) - '0';
            if (isOctal && digitValue >= 8)
                throw new IllegalArgumentException(number + " found digit >= 8");

            value = value * factor + digitValue;

            pos++;
        }

        return isNegative ? -value : value;
    }

    private static int calcStartPos(final String number, boolean isOctal)
    {
        int pos = 0;
        if (startsWithSign(number) && isOctal)
        {
            pos = 2;
        }
        else if (startsWithSign(number) || isOctal)
        {
            pos = 1;
        }
        return pos;
    }
}