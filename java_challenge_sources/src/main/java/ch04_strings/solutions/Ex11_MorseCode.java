package ch04_strings.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex11_MorseCode
{
    private Ex11_MorseCode()
    {
    }

    static String toMorseCode(final String input)
    {
        final StringBuilder convertedMsg = new StringBuilder();

        for (int i = 0; i < input.length(); i++)
        {
            var currentChar = input.charAt(i);
            var convertedLetter = convertToMorseCode(currentChar);

            convertedMsg.append(convertedLetter);
            convertedMsg.append("   ");
        }

        return convertedMsg.toString().trim();
    }

    private static String convertToMorseCode(final char currentChar)
    {
        return switch (currentChar)
                        {
                            case 'E' -> ".";
                            case 'O' -> "- - -";
                            case 'S' -> ". . .";
                            case 'T' -> "-";
                            case 'W' -> ". - -";
                            default -> "?";
                        };
    }
}
