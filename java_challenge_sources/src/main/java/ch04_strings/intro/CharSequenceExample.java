package ch04_strings.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class CharSequenceExample
{
    public static void main(final String[] args)
    {
        final String text = "ABCDEFGHIJKL";
        final StringBuilder sb1 = new StringBuilder("ABCDEFGHIJKL");
        final StringBuilder sb2 = new StringBuilder("ABCDEFGHIJKL");

        System.out.println(text.equals(sb1));
        System.out.println(CharSequence.compare(text, sb1));
        System.out.println(text.contentEquals(sb1));

        System.out.println(sb1.equals(sb2));
        System.out.println(CharSequence.compare(sb1, sb2) == 0);

        System.out.println(sb1.compareTo(sb2) == 0);

        // Unicode Character 'ARABIC-INDIC DIGIT ZERO' (U+0660)
        // Unicode Character 'ARABIC-INDIC DIGIT SEVEN' (U+0667)
        // Unicode Character 'ARABIC-INDIC DIGIT NINE' (U+0669)
        for (short i = 0; i < 10; i++)
        {
            final char arabicSpecialNumber = (char) ('\u0660' + i);
            digitToValue(arabicSpecialNumber);
        }

        final String smallSpace1 = "\u2001";
        System.out.println("'" + smallSpace1 + "': " + smallSpace1.isBlank());

        final String smallSpace2 = "\u2009";
        System.out.println("'" + smallSpace2 + "': " + smallSpace2.isBlank());
    }

    private static void digitToValue(final char nine)
    {
        System.out.print(nine);
        System.out.print(" - ");
        System.out.print(Character.isDigit(nine));
        System.out.print(" - ");
        System.out.println(Character.getNumericValue(nine));
    }
}
