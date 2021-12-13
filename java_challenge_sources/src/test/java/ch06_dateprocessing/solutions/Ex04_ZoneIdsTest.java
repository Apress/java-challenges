package ch06_dateprocessing.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_ZoneIdsTest
{
    @Test
    public void selectedEuropeAndAmericaTimeZones()
    {
        final var expected = Set.of("America/La_Paz", "America/Lima", "America/Los_Angeles", "America/Louisville",
                                    "America/Lower_Princes", "Europe/Samara", "Europe/San_Marino", "Europe/Sarajevo",
                                    "Europe/Saratov", "Europe/Simferopol", "Europe/Skopje", "Europe/Sofia",
                        "Europe/Stockholm");

        final Set<String> result = Ex04_ZoneIds.selectedAmericanAndEuropeanTimeZones();

        assertEquals(expected, result);
    }
}
