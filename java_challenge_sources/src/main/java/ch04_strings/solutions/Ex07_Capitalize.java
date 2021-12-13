package ch04_strings.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_Capitalize
{
    private Ex07_Capitalize()
    {
    }

    static String capitalize(final String input)
    {
        final char[] inputChars = input.toCharArray();

        boolean capitalizeNextChar = true;
        for (int i = 0; i < inputChars.length; i++)
        {
            var currentChar = inputChars[i];
            if (Character.isWhitespace(currentChar))
            {
                capitalizeNextChar = true;
            }
            else
            {
                if (capitalizeNextChar && Character.isLetter(currentChar))
                {
                    // convert to uppercase
                    inputChars[i] = Character.toUpperCase(currentChar);
                    capitalizeNextChar = false;
                }
            }
        }

        return new String(inputChars);
    }

    static List<String> capitalize(final List<String> words)
    {
        final List<String> capitalizedWords = new ArrayList<>();

        for (final String word : words)
        {
            capitalizedWords.add(capitalizeWord(word));
        }
        return capitalizedWords;
    }

    static List<String> capitalizeWithStream(final List<String> words)
    {
        return words.stream().map(word -> capitalizeWord(word)).toList();
    }

    private static String capitalizeWord(String word)
    {
        if (word.isEmpty())
            return "";

        final String upperCaseFirstChar = word.substring(0, 1).toUpperCase();
        final String remainingChars = word.substring(1);

        return upperCaseFirstChar + remainingChars;
    }

    // ----------------

    static List<String> capitalizeSpecial(final List<String> words, final List<String> ignorableWords)
    {
        final List<String> capitalizedWords = new ArrayList<>();

        for (String word : words)
        {
            if (word.length() > 0)
            {
                if (ignorableWords.contains(word))
                {
                    capitalizedWords.add(word);
                }
                else
                {
                    capitalizedWords.add(capitalizeWord(word));
                }
            }
        }
        return capitalizedWords;
    }
}
