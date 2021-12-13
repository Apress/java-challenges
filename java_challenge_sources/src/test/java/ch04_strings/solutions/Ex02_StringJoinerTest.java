package ch04_strings.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_StringJoinerTest
{
    @Test
    public void testJoinLowLevel()
    {
        final var result = Ex02_StringJoiner.join(List.of("hello", "world", "message"), " +++ ");

        assertEquals("hello +++ world +++ message", result);
    }

    @Test
    public void testJoinStringsWithStream()
    {
        final var result = Ex02_StringJoiner.joinStrings(List.of("Micha", "Zürich"), " likes ");

        assertEquals("Micha likes Zürich", result);
    }

    @Test
    public void testJoinWithLibs() throws Exception
    {
        final var result = Ex02_StringJoiner.joinStrings(List.of("hello", "world", "message"), " +++ ");
        assertEquals("hello +++ world +++ message", result);
    }
}
