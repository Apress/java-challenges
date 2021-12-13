package ch07_lists.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_FindMaxRevenue
{
    private Ex04_FindMaxRevenue()
    {
    }

    static int maxRevenue(final List<Integer> prices)
    {
        final List<Integer> relevantMins = calcRelevantMins(prices);

        return calcMaxRevenue(prices, relevantMins);
    }

    static List<Integer> calcRelevantMins(final List<Integer> prices)
    {
        final List<Integer> relevantMins = new ArrayList<>();

        int currentMin = Integer.MAX_VALUE;
        for (final int currentPrice : prices)
        {
            currentMin = Math.min(currentMin, currentPrice);
            relevantMins.add(currentMin);
        }
        return relevantMins;
    }

    static int calcMaxRevenue(final List<Integer> prices, final List<Integer> relevantMins)
    {
        int maxRevenue = 0;
        for (int i = 0; i < prices.size(); i++)
        {
            if (prices.get(i) > relevantMins.get(i))
            {
                final int currentRevenue = prices.get(i) - relevantMins.get(i);
                maxRevenue = Math.max(maxRevenue, currentRevenue);
            }
        }
        return maxRevenue;
    }

    static int maxRevenueV2(final List<Integer> prices)
    {
        int currentMin = Integer.MAX_VALUE;
        int maxRevenue = 0;

        for (final int currentPrice : prices)
        {
            currentMin = Math.min(currentMin, currentPrice);
            final int currentRevenue = currentPrice - currentMin;
            maxRevenue = Math.max(maxRevenue, currentRevenue);
        }

        return maxRevenue;
    }

    static int maxRevenueV3(final List<Integer> prices)
    {
        int currentMin = Integer.MAX_VALUE;
        int maxRevenue = 0;

        for (final int currentPrice : prices)
        {
            if (currentPrice < currentMin)
                currentMin = currentPrice;
            else
            {
                final int currentRevenue = currentPrice - currentMin;
                maxRevenue = Math.max(maxRevenue, currentRevenue);
            }
        }
        return maxRevenue;
    }

}
