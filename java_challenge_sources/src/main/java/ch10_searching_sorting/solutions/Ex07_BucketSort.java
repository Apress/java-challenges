package ch10_searching_sorting.solutions;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_BucketSort
{
    private Ex07_BucketSort()
    {
    }

    public static int[] bucketSort(final int[] values, final int expectedMax)
    {
        final int[] buckets = new int[expectedMax + 1];
        collectIntoBuckets(values, buckets);

        final int[] results = new int[values.length];
        fillResultFromBuckets(buckets, results);

        return results;
    }

    private static void collectIntoBuckets(final int[] values, final int[] buckets)
    {
        for (int current : values)
        {
            buckets[current]++;
        }
    }

    private static void fillResultFromBuckets(final int[] buckets, final int[] results)
    {
        int resultPos = 0;
        for (int i = 0; i < buckets.length; i++)
        {
            int count = buckets[i];

            while (count > 0)
            {
                results[resultPos] = i;

                count--;
                resultPos++;
            }
        }
    }
}
