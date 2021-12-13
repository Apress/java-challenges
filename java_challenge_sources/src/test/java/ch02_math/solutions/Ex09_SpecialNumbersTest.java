package ch02_math.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import ch02_math.solutions.Ex09_SpecialArmstrongNumbers.CubicFunction;

/**
 * Example program for the book "Java Challenge"
 *
 * @author Michael Inden
 *
 *         Copyright 2020 by Michael Inden
 */
public class Ex09_SpecialNumbersTest
{
	@Test
	public void calcArmstronglNumbers()
	{
		final List<Integer> result = Ex09_SpecialArmstrongNumbers.calcArmstrongNumbers();

		assertEquals(List.of(153, 371), result);
	}

	@Test
	public void calcNumbers()
	{
		final CubicFunction special = (x, y, z) -> (int) (Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3));

		final List<Integer> result = Ex09_SpecialArmstrongNumbers.calcNumbers(special);

		assertEquals(List.of(153, 371), result);
	}
}
