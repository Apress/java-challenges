package ch04_strings.solutions;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex13_TennisPointsTest
{
    @ParameterizedTest(name = "''{0}'' => ''{1}''")
    @CsvSource({ "1:0, Fifteen Love", "2:2, Thirty Thirty",
        "2:3, Thirty Forty", "3:3, Deuce",
        "4:3, Advantage Micha", "4:4, Deuce",
        "5:4, Advantage Micha", "6:4, Game Micha" })
    void calculateScore(String score, String expected)
    {
        String result = Ex13_TennisPoints.calculateScore(score, "Micha", "Tim");

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "''{0}'' => ''{1}''")
    @CsvSource({ "1:0, Fifteen Love", "2:2, Thirty Thirty",
        "3:2, Forty Thirty", "4:2, Game Micha" })
    void calculateScoreWin(String score, String expected)
    {
        String result = Ex13_TennisPoints.calculateScore(score, "Micha", "Tim");

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "''{0}'' => ''{1}''")
    @CsvSource({ "1:0, Fifteen Love", "2:0, Thirty Love",
        "3:0, Forty Love", "4:0, Game Micha"} )
    void calculateScoreStraightWin(String score, String expected)
    {
        String result = Ex13_TennisPoints.calculateScore(score, "Micha", "Tim");

        assertEquals(expected, result);
    }
}
