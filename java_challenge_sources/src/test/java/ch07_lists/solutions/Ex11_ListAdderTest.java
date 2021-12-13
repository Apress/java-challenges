package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex11_ListAdderTest
{
    @Test
    public void listAdd_for_Values1()
    {
        final List<Integer> result = Ex11_ListAdder.listAddImproved(List.of(1, 2, 3),
                                                                    List.of(4, 5, 6));

        assertEquals(List.of(5, 7, 9), result);
    }

    @Test
    public void listAdd_for_Values2()
    {
        final List<Integer> result = Ex11_ListAdder.listAddImproved(List.of(9, 2, 7),
                                                                    List.of(1, 3, 5));

        assertEquals(List.of(1, 0, 6, 2), result);
    }


    @ParameterizedTest(name = "listAddImproved({0} + {1}) = {2}")
    @MethodSource("reverseOrderInputs")
    public void listAddImproved(final List<Integer> inputs1, final List<Integer> inputs2,
                                final List<Integer> expected)
    {
        final List<Integer> result = Ex11_ListAdder.listAddInvers(inputs1, inputs2);

        assertEquals(expected, result);
    }

    static Stream<Arguments> reverseOrderInputs()
    {
        return Stream.of(Arguments.of(List.of(3, 2, 1),
                                      List.of(6, 5, 4),
                                      List.of(9, 7, 5)),
                         Arguments.of(List.of(7, 2, 9),
                                      List.of(5, 3, 1),
                                      List.of(2, 6, 0, 1)),
                         Arguments.of(List.of(5, 3, 1),
                                      List.of(0, 0, 0, 1, 3, 5),
                                      List.of(5, 3, 1, 1, 3, 5)));
    }
}
