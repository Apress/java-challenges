package ch04_strings.intro;

import java.util.Map;
import java.util.TreeMap;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class CharacterHistogram
{
    public static void main(final String[] args)
    {
        var charCountMap1 = generateCharacterHistogramV1("Otto");
        System.out.println(charCountMap1);

        var charCountMap2 = generateCharacterHistogramV1("Hello Michael");
        System.out.println(charCountMap2);

        Map<Character, Integer> characterCountMap1 = generateCharacterHistogramV2("a bb ccc dddd eeeee ffffff");
        System.out.println(characterCountMap1);

        Map<Character, Integer> characterCountMap2 = generateCharacterHistogramV2("Java Challenge, Your Java-Training");
        System.out.println(characterCountMap2);
    }

    private static Map<Character, Integer> generateCharacterHistogramV1(final String word)
    {
        final Map<Character, Integer> charCountMap = new TreeMap<>();

        final char[] chars = word.toLowerCase().toCharArray();
        for (char currentChar : chars)
        {
            if (Character.isLetter(currentChar))
            {
                // Trick, but attention to the order!
                charCountMap.computeIfPresent(currentChar, (key, value) -> value + 1);
                charCountMap.putIfAbsent(currentChar, 1);
            }
        }

        return charCountMap;
    }

    static Map<Character, Integer> generateCharacterHistogramV2(final String input)
    {
        final Map<Character, Integer> characterCountMap = new TreeMap<>();

        for (int i = 0; i < input.length(); i++)
        {
            final char currentChar = input.charAt(i);
            final char normalizedChar = Character.toLowerCase(currentChar);

            if (!Character.isWhitespace(normalizedChar))
            {
                characterCountMap.putIfAbsent(normalizedChar, 0);
                characterCountMap.computeIfPresent(normalizedChar, (key, value) -> value + 1);
            }
        }

        return characterCountMap;
    }
}
