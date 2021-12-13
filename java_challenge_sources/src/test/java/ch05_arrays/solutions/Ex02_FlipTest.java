package ch05_arrays.solutions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_FlipTest
{
    @Test
    void flipHorizontally()
    {
        final Integer[][] horiNumbers = { { 1, 2, 3 },
                                          { 4, 5, 6 },
                                          { 7, 8, 9 }};

        final Integer[][] expected = { { 3, 2, 1 },
                                       { 6, 5, 4 },
                                       { 9, 8, 7 } };

        Ex02_Flip.flipHorizontally(horiNumbers);

        assertArrayEquals(expected, horiNumbers);
    }

    @Test
    void flipVertically()
    {
        final Integer[][] vertNumbers = { { 1, 1, 4, 4 },
                                          { 2, 2, 5, 5 },
                                          { 3, 3, 6, 6 } };

        final Integer[][] expected = { { 3, 3, 6, 6 },
                                       { 2, 2, 5, 5 },
                                       { 1, 1, 4, 4 } };

        Ex02_Flip.flipVertically(vertNumbers);

        assertArrayEquals(expected, vertNumbers);
    }

    @Test
    void flipHorizontallyV2()
    {
        final Integer[][] horiNumbers = { { 1, 2, 3 },
                                          { 4, 5, 6 },
                                          { 7, 8, 9 }};

        final Integer[][] expected = { { 3, 2, 1 },
                                       { 6, 5, 4 },
                                       { 9, 8, 7} };

        Ex02_Flip.flipHorizontallyV2(horiNumbers);

        assertArrayEquals(expected, horiNumbers);
    }

    @Test
    void flipVerticallySimplified()
    {
        final Integer[][] vertNumbers = { { 1, 1, 4, 4 },
                                          { 2, 2, 5, 5 },
                                          { 3, 3, 6, 6 } };

        final Integer[][] expected = { { 3, 3, 6, 6 },
                                       { 2, 2, 5, 5 },
                                       { 1, 1, 4, 4 } };

        Ex02_Flip.flipVerticallySimplified(vertNumbers);

        assertArrayEquals(expected, vertNumbers);
    }
}
