package ch08_recursion_advanced.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
class Ex03_LCS
{
    private Ex03_LCS()
    {
    }

    static String lcs(final String str1, final String str2)
    {
        return lcs(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    static String lcs(final String str1, final String str2,
                      final int pos1, final int pos2)
    {
        // recursive termination
        if (pos1 < 0 || pos2 < 0)
            return "";

        // check if chars are the same and move to the next
        if (str1.charAt(pos1) == str2.charAt(pos2))
        {
            // recursive descent
            return lcs(str1, str2, pos1 - 1, pos2 - 1) + str1.charAt(pos1);
        }
        else
        {
            // otherwise remove one of the two letters and try again,
            // neither letter belongs in the result
            final String lcs1 = lcs(str1, str2, pos1, pos2 - 1);
            final String lcs2 = lcs(str1, str2, pos1 - 1, pos2);

            if (lcs1.length() > lcs2.length())
                return lcs1;

            return lcs2;
        }
    }

    static String lcsOptimized(final String str1, final String str2)
    {
        return lcsWithMemo(str1, str2, str1.length() - 1, str2.length() - 1, new String[str1.length()][str2.length()]);
    }

    static String lcsWithMemo(final String str1, final String str2, final int pos1, final int pos2,
                              final String[][] values)
    {
        // recursive termination
        if (pos1 < 0 || pos2 < 0)
            return "";

        // MEMOIZATION
        if (values[pos1][pos2] != null)
            return values[pos1][pos2];

        String lcs;

        // check if chars are the same and move to the next
        if (str1.charAt(pos1) == str2.charAt(pos2))
        {
            // recursive descent
            lcs = lcsWithMemo(str1, str2, pos1 - 1, pos2 - 1, values) + str1.charAt(pos1);
        }
        else
        {
            // otherwise remove one of the two letters and try again,
            // neither letter belongs in the result
            final String lcs1 = lcsWithMemo(str1, str2, pos1, pos2 - 1, values);
            final String lcs2 = lcsWithMemo(str1, str2, pos1 - 1, pos2, values);

            if (lcs1.length() > lcs2.length())
                lcs = lcs1;
            else
                lcs = lcs2;
        }

        // MEMOIZATION
        values[pos1][pos2] = lcs;

        return lcs;
    }


    public static void main(final String args[])
    {
        final String[][] inputs_tuples = { { "ABCMIXCHXAEL", "MICHAEL" },
                                           { "sunday-Morning",
                                           "saturday-Night-Party" },
                                           { "sunday-Morning-Wakeup", "saturday-Night" },
                                           { "sunday-Morning-Wakeup", "saturday-Night-Party" },
                                           { "sunday-Morning-Breakfast", "saturday-Night-Party" } };

        for (final String[] inputs : new String[][] { { "ABCXY", "XYACB" } })
        {
            final long start = System.currentTimeMillis();
            System.out.println(inputs[0] + " -> " + inputs[1] +
                               " lcs: " + lcs(inputs[0], inputs[1]));

            final long end = System.currentTimeMillis();
            System.out.println("lcs took " + (end - start) + " ms");
        }

        for (final String[] inputs : inputs_tuples)
        {
            final long start = System.currentTimeMillis();
            System.out.println(inputs[0] + " -> " + inputs[1] + " lcsWithMemo: " + lcsOptimized(inputs[0], inputs[1]));
            final long end = System.currentTimeMillis();
            System.out.println("lcsWithMemo took " + (end - start) + " ms");
        }
    }
}
