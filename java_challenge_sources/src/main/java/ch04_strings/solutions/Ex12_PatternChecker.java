package ch04_strings.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_PatternChecker
{
    private Ex12_PatternChecker()
    {
    }

    static boolean matchesPattern(final String pattern, final String input)
    {
        // preparation
        final int patternLength = pattern.length();
        final String[] values = input.split(" ");
        final int valuesLength = values.length;

        if (valuesLength != patternLength || values.length == 1 && values[0].isEmpty())
            return false;

        final Map<Character, String> placeholderToValueMap = new HashMap<>();

        // run through all characters of the pattern
        for (int i = 0; i < pattern.length(); i++)
        {
            final char patternChar = pattern.charAt(i);
            final String value = values[i];

            // add, if not already there
            placeholderToValueMap.putIfAbsent(patternChar, value);

            // does stored value match current string?
            final String assignedValue = placeholderToValueMap.get(patternChar);
            if (!assignedValue.equals(value))
                return false;
        }
        return true;
    }

    static boolean inputMatchesPatternNoDuplicateValuesForKeys(final String pattern, final String input)
    {
        // preparation
        final int patternLength = pattern.length();
        final String[] values = input.split(" ");
        final int valuesLength = values.length;

        if (valuesLength != patternLength || values.length == 1 && values[0].isEmpty())
            return false;

        final Map<Character, String> placeholderToValueMap = new HashMap<>();

        // run through all characters of the pattern
        for (int i = 0; i < pattern.length(); i++)
        {
            final char patternChar = pattern.charAt(i);
            final String value = values[i];

            // add, if not already there
            placeholderToValueMap.putIfAbsent(patternChar, value);

            // does stored value match current string?
            final String assignedValue = placeholderToValueMap.get(patternChar);
            if (!assignedValue.equals(value))
                return false;

            // check for uniqueness
            if (placeholderToValueMap.values().stream().filter(str -> str.equals(value)).count() > 1)
                return false;
        }
        return true;
    }
}
