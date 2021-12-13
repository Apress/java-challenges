package ch03_recursion.solutions;

import java.util.HashSet;
import java.util.Set;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex11_Permutations
{
    private Ex11_Permutations()
    {
    }

    static Set<String> calcPermutations(final String input)
    {
        // recursive termination
        if (input.isEmpty() || input.length() == 1)
            return Set.of(input);

        final Set<String> combinations = new HashSet<>();
        for (int i = 0; i < input.length(); i++)
        {
            // extract i-th character as new first character
            final String newFirst = "" + input.charAt(i);

            // rest without i-th character
            final String newInput = input.substring(0, i) + input.substring(i + 1);

            // recursive descent
            final Set<String> permutations = calcPermutations(newInput);

            // adding the extracted character to all partial solutions
            for (final String perm : permutations)
            {
                combinations.add(newFirst + perm);
            }
        }
        return combinations;
    }

    static Set<String> calcPermutationsMiniOpt(final String input)
    {
        return calcPermutationsMiniOpt(input, "");
    }

    static Set<String> calcPermutationsMiniOpt(final String remaining, final String prefix)
    {
        if (remaining.length() == 0)
            return Set.of(prefix);

        final Set<String> candidates = new HashSet<>();

        for (int i = 0; i < remaining.length(); i++)
        {
            // first part
            String newPrefix = prefix + remaining.charAt(i);

            // rest (without extracted character)
            final String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            candidates.addAll(calcPermutationsMiniOpt(newRemaining, newPrefix));
        }

        return candidates;
    }
}
