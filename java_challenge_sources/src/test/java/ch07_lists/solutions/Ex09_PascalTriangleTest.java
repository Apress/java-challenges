package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

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
public class Ex09_PascalTriangleTest
{
    @ParameterizedTest(name = "pascal({0}) = {1}")
    @MethodSource("listInputsAndExpected")
    public void valueCountV2(int n,  List<List<Integer>>expected)
    {
        List<List<Integer>> result = Ex09_PascalTriangle.pascal(n);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of(1, List.of(List.of(1))),
                         Arguments.of(2, List.of(List.of(1),
                                                 List.of(1, 1))),
                         Arguments.of(5, List.of(List.of(1),
                                                 List.of(1, 1),
                                                 List.of(1, 2, 1),
                                                 List.of(1, 3, 3, 1),
                                                 List.of(1, 4, 6, 4, 1))));
    }
}
