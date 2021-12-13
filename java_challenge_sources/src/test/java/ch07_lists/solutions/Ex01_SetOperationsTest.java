package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.List;
import java.util.Set;
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
public class Ex01_SetOperationsTest
{
    @ParameterizedTest(name = "findCommon({0}, {1}) = {2}")
    @MethodSource("createCollectionsAndExpected")
    public void testFindCommon(final Collection<Integer> col1, final Collection<Integer> col2, final Set<Integer> expected) {
        final Set<Integer> result = Ex01_SetOperations.findCommon(col1, col2);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "findCommonNoJdk({0}, {1}) = {2}")
    @MethodSource("createCollectionsAndExpected")
    public void testFindCommonNoJdk(final Collection<Integer> col1, final Collection<Integer> col2, final Set<Integer> expected) {
        final Set<Integer> result = Ex01_SetOperations.findCommonNoJdk(col1, col2);

        assertEquals(expected, result);
    }

    @ParameterizedTest(name = "findCommonNoJdk({0}, {1}) = {2}")
    @MethodSource("createCollectionsAndExpected")
    public void testFindCommonTwoLoop(final Collection<Integer> col1, final Collection<Integer> col2,
                                      final Set<Integer> expected)
    {
        final Set<Integer> result = Ex01_SetOperations.findCommonTwoLoops(col1, col2);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> createCollectionsAndExpected()
    {
        return Stream.of(Arguments.of(List.of(1, 2, 4, 7, 8), List.of(2, 3, 7, 9), Set.of(2, 7)),
                         Arguments.of(List.of(1, 2, 7, 4, 7, 8), List.of(7, 7, 3, 2, 9), Set.of(2, 7)),
                         Arguments.of(List.of(2, 4, 6, 8), List.of(1, 3, 5, 7, 9), Set.of()));
    }

    // -------------------------------------------------------------------------

    @ParameterizedTest(name = "difference({0}, {1}) = {2}")
    @MethodSource("createCollectionsAndMultilpleExpected")
    public void testDifferenceA_B(final Set<Integer> colA, final Set<Integer> colB, final Set<Integer> expectedDiffA_B,
                                  final Set<Integer> expectedDiffB_A, final Set<Integer> expectedUnionUnion, final Set<Integer> expectedDifference) {
        final Set<Integer> result = Ex01_SetOperations.differenceV2(colA, colB);

        assertEquals(expectedDiffA_B, result);
    }

    @ParameterizedTest(name = "difference({1}, {0}) = {3}")
    @MethodSource("createCollectionsAndMultilpleExpected")
    public void testDifferenceB_A(final Set<Integer> colA, final Set<Integer> colB, final Set<Integer> expectedDiffA_B,
                                  final Set<Integer> expectedDiffB_A, final Set<Integer> expectedUnionUnion, final Set<Integer> expectedDifference) {
        final Set<Integer> result = Ex01_SetOperations.differenceV2(colB, colA);

        assertEquals(expectedDiffB_A, result);
    }

    @ParameterizedTest(name = "intersection({0}, {1}) = {5}")
    @MethodSource("createCollectionsAndMultilpleExpected")
    public void testIntersection(final Set<Integer> colA, final Set<Integer> colB, final Set<Integer> expectedDiffA_B,
                                 final Set<Integer> expectedDiffB_A, final Set<Integer> expectedUnion, final Set<Integer> expectedIntersection) {

        final Set<Integer> result = Ex01_SetOperations.intersectionV2(colA, colB);

        assertEquals(expectedIntersection, result);
    }

    private static Stream<Arguments> createCollectionsAndMultilpleExpected() {
        return Stream.of(
                         Arguments.of(Set.of(1, 2, 3, 4, 5), Set.of(2, 4, 6, 7, 8),
                                      Set.of(1, 3, 5), Set.of(6, 7, 8),
                                      Set.of(1, 2, 3, 4, 5, 6, 7, 8), Set.of(2, 4)),
                         Arguments.of(Set.of(2, 4, 6), Set.of(1, 3, 5, 7), Set.of(2, 4, 6), Set.of(1, 3, 5, 7),
                                      Set.of(1, 2, 3, 4, 5, 6, 7), Set.of()));
    }

    @ParameterizedTest(name = "unionV2({0}, {1}) = {2}")
    @MethodSource("createCollectionsAndUnionExpected")
    void testUnionV2(final Set<Integer> colA, final Set<Integer> colB, final Set<Integer> expectedUnion)
    {
        final Set<Integer> result = Ex01_SetOperations.unionV2(colA, colB);

        assertEquals(expectedUnion, result);
    }

    private static Stream<Arguments> createCollectionsAndUnionExpected()
    {
        return Stream.of(Arguments.of(Set.of(1, 2, 3, 4, 5), Set.of(2, 4, 6, 7, 8), Set.of(1, 2, 3, 4, 5, 6, 7, 8)),
                         Arguments.of(Set.of(2, 4, 6), Set.of(1, 3, 5, 7), Set.of(1, 2, 3, 4, 5, 6, 7)));
    }
}
