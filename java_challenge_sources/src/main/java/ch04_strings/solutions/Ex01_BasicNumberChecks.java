package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_BasicNumberChecks
{
    public static void main(final String[] args)
    {
        System.out.println("101101 binary? " + isBinaryNumber("101101"));
        System.out.println("123456 binary? " + isBinaryNumber("123456"));

        // convert binary to decimal
        System.out.println("0110 binary => decimal: " + binaryToDecimal("0110"));
        System.out.println("1110 binary => decimal: " + binaryToDecimal("1110"));
        System.out.println("101101 binary => decimal: " + binaryToDecimal("101101"));
        System.out.println("11111111 binary => decimal: " + binaryToDecimal("11111111"));

        // ------------------------

        System.out.println("123456 binary? " + isHexNumber("123456"));
        System.out.println("ABCDEF binary? " + isHexNumber("ABCDEF"));
        System.out.println("GH binary? " + isHexNumber("GH"));

        System.out.println("A hex => decimal: " + hexToDecimal("A"));
        System.out.println("ABC hex => decimal: " + hexToDecimal("ABC"));
        System.out.println("123 hex => decimal: " + hexToDecimal("123"));
    }

    // checks if a given string is a binary number, i.e. consists only of the
    // characters 0 and 1
    static boolean isBinaryNumber(final String number)
    {
        boolean isBinary = true;

        int i = 0;
        while (i < number.length() && isBinary)
        {
            final char currentChar = number.charAt(i);
            isBinary = currentChar == '0' || currentChar == '1';

            i++;
        }

        return isBinary;
    }

    static int binaryToDecimal(final String number)
    {
        if (!isBinaryNumber(number))
            throw new IllegalArgumentException(number + " is not a binary number");

        int decimalValue = 0;
        for (int i = 0; i < number.length(); i++)
        {
            final int current = number.charAt(i) - '0';
            decimalValue = decimalValue * 2 + current;
        }

        return decimalValue;
    }

    // -------------------------------------------------------------------

    static boolean isHexNumber(final String number)
    {
        boolean isHex = true;

        final String upperCaseNumber = number.toUpperCase();
        int i = 0;
        while (i < upperCaseNumber.length() && isHex)
        {
            final char currentChar = upperCaseNumber.charAt(i);
            isHex = Character.isDigit(currentChar) || currentChar == 'A' || currentChar == 'B' || currentChar == 'C'
                            || currentChar == 'D' || currentChar == 'E' || currentChar == 'F';

            i++;
        }

        return isHex;
    }

    static int hexToDecimal(final String number)
    {
        if (!isHexNumber(number))
            throw new IllegalArgumentException(number + " is not a hex number, it conatins invalid chars");

        final String upperCaseNumber = number.toUpperCase();

        int decimalValue = 0;
        for (int i = 0; i < upperCaseNumber.length(); i++)
        {
            final char currentChar = upperCaseNumber.charAt(i);

            int value = hexDigitToDecimal2(currentChar);
            decimalValue = decimalValue * 16 + value;

            //            int value = Character.getNumericValue(currentChar);
            //            decimalValue = decimalValue * 16 + value;
        }

        return decimalValue;
    }

    static int hexDigitToDecimalOld(final char currentChar)
    {
        int digitValueOld = 0;
        if (Character.isDigit(currentChar))
        {
            digitValueOld = currentChar - '0';
        }
        else
        {
            // A ... F
            digitValueOld = currentChar - 'A' + 10;
        }
        return digitValueOld;
    }

    static int hexDigitToDecimal2(final char currentChar)
    {
        final int position = "0123456789ABCDEF".indexOf(currentChar);
        if (position < 0)
            throw new IllegalArgumentException("invalid hex char: " + currentChar);

        return position;
    }

    static String asHexDigit(final int n)
    {
        if (n < 0)
            throw new IllegalArgumentException("n must be >= 0");

        if (n <= 15)
        {
            final char hexdigit = "0123456789ABCDEF".charAt(n);
            return String.valueOf(hexdigit);
        }

        throw new IllegalArgumentException("value not in range 0 - 15, " + "but is: " + n);
    }
}
