package ch10_searching_sorting.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_FlagPartioningTest
{
    @Test
    public void testPartition2()
    {
        final String result = Ex02_FlagPartitioning.partition2("ABAABBBAAABBBA");

        assertEquals("AAAAAAABBBBBBB", result);
    }

    @Test
    public void testPartition3()
    {
        final String result = Ex02_FlagPartitioning.partition3("ABACCBBCAACCBBA");

        assertEquals("AAAAABBBBBCCCCC", result);
    }
}
