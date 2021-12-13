package appendix_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
class JUnit5ExampleTest
{
    @Test
    void testAssertTrue()
    {
        final List<String> names = new ArrayList<>();
        names.add("Max");
        names.add("Moritz");
        names.clear();
        assertTrue(names.isEmpty());
    }

    @Test
    void testAssertFalse()
    {
        final List<Integer> primes = Arrays.asList(2, 3, 5, 7);
        // An error is deliberately provoked here
        assertFalse(primes.contains(7));
    }

    @Test
    void testAssertNull()
    {
        assertNull(null);
    }

    @Test
    void testAssertNotNull()
    {
        // An error is deliberately provoked here
        assertNotNull(null, "Unexpected null value");
    }

    @Test
    void testAssertEquals()
    {
        assertEquals("EXPECTED", "expected".toUpperCase());
    }

    @Test
    void testAssertEqualsWithPrecision()
    {
        assertEquals(2.75, 2.74999, 0.1);
    }

    @Test
    void testFailWithExceptionJUnit5()
    {
        assertThrows(java.lang.NumberFormatException.class, () ->
        {
            // An error is deliberately provoked here
            final int value = Integer.parseInt("provoke error!");
        });
    }
}
