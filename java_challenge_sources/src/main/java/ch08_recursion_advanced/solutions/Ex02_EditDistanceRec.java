package ch08_recursion_advanced.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_EditDistanceRec
{
    static int editDistance(final String str1, final String str2)
    {
        return editDistanceRec(str1.toLowerCase(), str2.toLowerCase());
    }

    static int editDistanceRec(final String str1, final String str2)
    {
        // recursive termination
        // both match
        if (str1.equals(str2))
            return 0;

        // if one of the strings is at the beginning and the other is
        // not yet, then take the length of the remaining string
        if (str1.length() == 0)
            return str2.length();
        if (str2.length() == 0)
            return str1.length();

        // check if the characters match and then advance to the next one
        if (str1.charAt(0) == str2.charAt(0))
        {
            // recursive descent
            return editDistance(str1.substring(1), str2.substring(1));
        }
        else
        {
            // recursive descent: check for insert, delete, change
            final int insertInFirst = editDistanceRec(str1.substring(1), str2);
            final int deleteInFirst = editDistanceRec(str1, str2.substring(1));
            final int change = editDistanceRec(str1.substring(1), str2.substring(1));

            // minimum from all three variants + 1
            return 1 + minOf3(insertInFirst, deleteInFirst, change);
        }
    }

    static int minOf3(final int x, final int y, final int z)
    {
        return Math.min(x, Math.min(y, z));
    }

    public static void main(final String args[])
    {
        final String[][] inputs_tuples = { { "Micha", "Michael" }, { "Ananas", "Banane" }, { "Pale", "Maple" },
                                           { "Apple", "Maple" }, { "maple", "tables" }, { "marble", "tables" },
                                           { "rapple", "tables" },
                                           // takes long:
                                           { "sunday-Morning", "saturday-Night" },
                                           // takes very long:
                                           // { "sunday-Morning-Breakfast", "saturday-Night-Party" }
        };

        for (final String[] inputs : inputs_tuples)
        {
            final long start = System.currentTimeMillis();
            System.out.println(inputs[0] + " -> " + inputs[1] + " edits: " + editDistance(inputs[0], inputs[1]));
            final long end = System.currentTimeMillis();
            System.out.println("editDist took " + (end - start) + " ms");
        }
    }
}
