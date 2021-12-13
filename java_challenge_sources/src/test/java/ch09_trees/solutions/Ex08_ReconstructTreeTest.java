package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex08_ReconstructTreeTest
{
    @Test
    void testReconstructFromIntArray()
    {
        final int[] inputs = { 1, 2, 3, 4, 5, 6, 7 };

        final var expected = List.of(4, 2, 6, 1, 3, 5, 7);

        final var resultRoot = Ex08_ReconstructTree.reconstruct(inputs);
        final var result = levelOrderToList(resultRoot);

        assertEquals(expected, result);
    }

    private static List<Integer> levelOrderToList(final BinaryTreeNode<Integer> root)
    {
        final List<Integer> result = new ArrayList<>();
        Ex05_BreadthFirst.levelorder(root, result::add);
        return result;
    }


    // reconstruction from list

    @ParameterizedTest(name = "reconstruct(pre= {0}, in={2}) => levelorder: {2}")
    @MethodSource("preInorderAndResult")
    void testReconstructFromLists(final List<Integer> preorderValues,
                                  final List<Integer> inorderValues,
                                  final List<Integer> expectedLevelorder)
    {

        final var resultRoot = Ex08_ReconstructTree.reconstruct(preorderValues,
                                                                inorderValues);
        final var result = levelOrderToList(resultRoot);

        TreeUtils.nicePrint(resultRoot);
        assertEquals(expectedLevelorder, result);
    }

    @ParameterizedTest(name = "reconstruct(pre= {0}, in={2}) => levelorder: {2}")
    @MethodSource("preInorderAndResult")
    void reconstructClearer(final List<Integer> preorderValues, final List<Integer> inorderValues,
                            final List<Integer> expectedLevelorder)
    {

        final var resultRoot = Ex08_ReconstructTree.reconstructClearer(preorderValues, inorderValues);
        final var result = levelOrderToList(resultRoot);

        TreeUtils.nicePrint(resultRoot);
        assertEquals(expectedLevelorder, result);
    }

    private static Stream<Arguments> preInorderAndResult()
    {
        return Stream.of(Arguments.of(List.of(4, 2, 1, 3, 6, 5, 7),
                                      List.of(1, 2, 3, 4, 5, 6, 7),
                                      List.of(4, 2, 6, 1, 3, 5, 7)),
                         Arguments.of(List.of(5, 4, 2, 1, 3, 7, 6, 8),
                                      List.of(1, 2, 3, 4, 5, 6, 7, 8),
                                      List.of(5, 4, 7, 2, 6, 8, 1, 3)));
    }
}
