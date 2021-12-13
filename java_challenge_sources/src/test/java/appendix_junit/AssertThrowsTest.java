package appendix_junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class AssertThrowsTest
{
	@Test
	public void arrayIndexOutOfBoundsExceptionExpected()
	{
		final var numbers = new int[] {1,2,3,4,5,6,7};

		final Executable action = () ->
		{
			numbers[1_000] = 13;
		};

		assertThrows(ArrayIndexOutOfBoundsException.class, action);
	}

	@Test
	public void illegalStateExceptionExpected()
	{
		final Executable action = () ->
		{
			throw new IllegalStateException("XYZ is not initialized");
		};

		assertThrows(IllegalStateException.class, action);
	}

	@Test
	public void illegalStateExceptionWithMessageTextExpected()
	{
		final Executable action = () ->
		{
			throw new IllegalStateException("XYZ is not initialized",
					new IOException("IO"));

		};

		final IllegalStateException exception =
				assertThrows(IllegalStateException.class,
						action);
		assertEquals("XYZ is not initialized", exception.getMessage());
		assertEquals(IOException.class, exception.getCause().getClass());
	}
}
