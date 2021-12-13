package ch02_math.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_MaxChangeCalculator
{
	private Ex10_MaxChangeCalculator()
	{
	}

	static int calcMaxPossibleChange(final List<Integer> values)
	{
		final List<Integer> sortedNumberx = new ArrayList<>(values);
		sortedNumberx.sort(Integer::compareTo);

		int maxPossibleChange = 0;

		for (int currentValue : sortedNumberx)
		{
			if (currentValue > maxPossibleChange + 1)
				break;

			maxPossibleChange += currentValue;
		}

		return maxPossibleChange;
	}
}
