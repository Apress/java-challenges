package ch08_recursion_advanced.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
class Ex02_EditDistance
{
    private Ex02_EditDistance()
    {
    }

    static int editDistanceOrig(final String str1, final String str2)
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

    static int editDistance(final String str1, final String str2)
    {
        return editDistance(str1.toLowerCase(), str2.toLowerCase(), str1.length() - 1, str2.length() - 1);
    }

    static int editDistance(final String str1, final String str2, final int pos1, final int pos2)
    {
        // recursive termination
        // if one of the strings is at the beginning and the other is is not yet,
        // then take the length of the remaining string
        if (pos1 < 0)
            return pos2 + 1;

        if (pos2 < 0)
            return pos1 + 1;

        // check if chars are the same and move to the next
        if (str1.charAt(pos1) == str2.charAt(pos2))
        {
            // recursive descent
            return editDistance(str1, str2, pos1 - 1, pos2 - 1);
        }
        else
        {
            // check for insert, delete, change
            final int insertInFirst = editDistance(str1, str2, pos1, pos2 - 1);
            final int deleteInFirst = editDistance(str1, str2, pos1 - 1, pos2);
            final int change = editDistance(str1, str2, pos1 - 1, pos2 - 1);

            // minimum from all three variants + 1
            return 1 + minOf3(insertInFirst, deleteInFirst, change);
        }
    }

    static int minOf3(final int x, final int y, final int z)
    {
        return Math.min(x, Math.min(y, z));
    }

    static int editDistanceOptimized(final String str1, final String str2)
    {
        final int length1 = str1.length();
        final int length2 = str2.length();

        final var memodata = new int[length1][length2];
        for (int i = 0; i < length1; i++)
            for (int j = 0; j < length2; j++)
                memodata[i][j] = -1;

        return editDistanceWithMemo(str1.toLowerCase(), str2.toLowerCase(), length1 - 1, length2 - 1, memodata);
    }

    static int editDistanceWithMemo(final String str1, final String str2, final int pos1, final int pos2,
                                    final int[][] memodata)
    {
        // recursive termination
        // if one of the strings is at the beginning and the other is is not yet,
        // then take the length of the remaining string
        if (pos1 < 0)
            return pos2 + 1;

        if (pos2 < 0)
            return pos1 + 1;

        // MEMOIZATION
        if (memodata[pos1][pos2] != -1)
            return memodata[pos1][pos2];

        int result = 0;
        // check if chars are the same and move to the next
        if (str1.charAt(pos1) == str2.charAt(pos2))
        {
            // recursive descent
            result = editDistanceWithMemo(str1, str2, pos1 - 1, pos2 - 1, memodata);
        }
        else
        {
            // check for insert, delete, change
            final int insertInFirst = editDistanceWithMemo(str1, str2, pos1, pos2 - 1, memodata);
            final int deleteInFirst = editDistanceWithMemo(str1, str2, pos1 - 1, pos2, memodata);
            final int change = editDistanceWithMemo(str1, str2, pos1 - 1, pos2 - 1, memodata);

            // minimum from all three variants + 1
            result = 1 + minOf3(insertInFirst, deleteInFirst, change);
        }

        // MEMOIZATION
        memodata[pos1][pos2] = result;

        return result;
    }

    public static void main(final String args[])
    {
        final String[][] inputs_tuples = { { "Micha", "Michael" }, { "Apple", "Maple" }, { "maple", "tables" },
                                           { "marble", "tables" }, { "rapple", "tables" },
                                           // takes long
                                           { "sunday-Morning", "saturday-Night" },
                                           // takes really long:
                                           // { "sunday-Morning-Breakfast", "saturday-Night-Party" }
        };

        for (final String[] inputs : inputs_tuples)
        {
            final long start = System.currentTimeMillis();
            System.out.println(inputs[0] + " -> " + inputs[1] + " edits: " + editDistanceOrig(inputs[0], inputs[1]));
            final long end = System.currentTimeMillis();
            System.out.println("editDist took " + (end - start) + " ms");
        }

        for (final String[] inputs : inputs_tuples)
        {
            final long start = System.currentTimeMillis();
            System.out.println(inputs[0] + " -> " + inputs[1] + " edits: " + editDistance(inputs[0], inputs[1]));
            final long end = System.currentTimeMillis();
            System.out.println("editDist took " + (end - start) + " ms");
        }

        for (final String[] inputs : inputs_tuples)
        {
            final long start = System.currentTimeMillis();
            System.out.println(inputs[0] + " -> " + inputs[1] + " edits: "
                            + editDistanceOptimized(inputs[0], inputs[1]));
            final long end = System.currentTimeMillis();
            System.out.println("editDistanceOptimized took " + (end - start) + " ms");
        }
    }
}
