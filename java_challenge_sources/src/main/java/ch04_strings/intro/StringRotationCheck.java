package ch04_strings.intro;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class StringRotationCheck
{
    public static void main(final String[] args)
    {
        checkSimple();
        checkSimpleWrong();
        checkComplex();
    }

    private static void checkSimple()
    {
        String str1 = "AAAA.CD.";
        String str2 = ".CD.AAAA";

        System.out.println("isRotationContained? " + isRotationContained(str1, str2));
    }

    private static void checkSimpleWrong()
    {
        String str1 = "AAA.C.";
        String str2 = ".D.AAA";

        System.out.println("isRotationContained? " + isRotationContained(str1, str2));
    }

    private static void checkComplex()
    {
        String str1 = "FIND-ME";
        String str2 = "ME.SOME.ARBITRARY.WORD.FIND-";

        System.out.println("isRotationContained? " + isRotationContained(str1, str2));
    }

    private static boolean isRotationContained(final String str1, final String str2)
    {
        final String longerSreachString = str2 + str2;

        return longerSreachString.contains(str1);
    }
}
