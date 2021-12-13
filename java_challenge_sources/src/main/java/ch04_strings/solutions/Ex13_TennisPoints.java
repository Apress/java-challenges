package ch04_strings.solutions;

import java.util.Map;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex13_TennisPoints
{
    private Ex13_TennisPoints()
    {
    }

    static String calculateScore(final String score, final String player1Name, final String player2Name)
    {
        final int[] points = extractPoints(score);

        final int score1 = points[0];
        final int score2 = points[1];

        if (score1 >= 3 && score2 >= 3)
        {
            return generateInfo(score1, score2, player1Name, player2Name);
        }
        else if (score1 >= 4 || score2 >= 4)
        {
            var playerName = score1 > score2 ? player1Name : player2Name;
            return "Game " + playerName;
        }
        else
        {
            // special naming
            var pointNames = Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");

            return pointNames.get(score1) + " " + pointNames.get(score2);
        }
    }

    static String generateInfo(final int score1, final int score2, final String player1Name, final String player2Name)
    {
        final int scoreDifference = Math.abs(score1 - score2);

        final String playerName = score1 > score2 ? player1Name : player2Name;

        if (score1 == score2)
            return "Deuce";
        if (scoreDifference == 1)
            return "Advantage " + playerName;
        if (scoreDifference == 2)
            return "Game " + playerName;

        throw new IllegalStateException("Unexpected difference: " + scoreDifference);
    }

    private static int[] extractPoints(final String score)
    {
        final String[] values = score.trim().split(":");

        if (values.length != 2)
            throw new IllegalArgumentException("illegal format -- score has not format <points>:<points>, e.g. 7:6");

        final int score1 = Integer.parseInt(values[0]);
        final int score2 = Integer.parseInt(values[1]);

        // sanity check
        if (score1 < 0 || score2 < 0)
            throw new IllegalArgumentException("points must be > 0");

        // prevents, e.g. 6:3
        if (score1 >= 3 && score2 >= 3 && Math.abs(score1 - score2) > 2)
            throw new IllegalArgumentException("point difference must be < 3, "
                            + "otherwise game has already been won");
        // prevents, e.g. 5:1 (upper if not necessary, is covered by this)
        if ((score1 > 4 || score2 > 4) && Math.abs(score1 - score2) > 2)
            throw new IllegalArgumentException("point difference must be < 3, "
                            + "otherwise game has already been won");

        return new int[] { score1, score2 };
    }
}
