package ch03_recursion.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_FibonacciTest
{
	@ParameterizedTest(name = "fibRec({0}) = {1}")
	@CsvSource({ "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21" })
	void fibRec(int n, long expectedFibN)
	{
		long result1 = Ex01_Fibonacci.fibRec(n);

		assertEquals(expectedFibN, result1);
	}

	@ParameterizedTest(name = "fibIterative({0}) = {1}")
	@CsvSource({ "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21" })
	void fibIterative(int n, long expectedFibN)
	{
		long result = Ex01_Fibonacci.fibIterative(n);

		assertEquals(expectedFibN, result);
	}

	@ParameterizedTest(name = "fibBigInt({0}) = {1}")
	@CsvSource({ "1, 1", "2, 1", "3, 2", "4, 3", "5, 5", "6, 8", "7, 13", "8, 21" })
	void fibIterative(int n, BigInteger expectedFibN)
	{
		BigInteger result = Ex01_Fibonacci.fibBigInt(n);

		assertEquals(expectedFibN, result);
	}
}
