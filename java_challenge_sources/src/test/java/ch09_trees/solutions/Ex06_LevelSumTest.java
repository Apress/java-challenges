package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_LevelSumTest
{
    @Test
    public void testLevelSum()
    {
        final var root = Ex06_LevelSum.createExampleLevelSumTree();
        final var expected = Map.ofEntries(Map.entry(0, 4), Map.entry(1, 8),
                                           Map.entry(2, 17), Map.entry(3, 16));

        final Map<Integer, Integer> resultBreadthFirst = Ex06_LevelSum.levelSum(root);
        final Map<Integer, Integer> resultDepthFirst = Ex06_LevelSum.levelSumDepthFirst(root);

        assertAll(() -> assertEquals(expected, resultBreadthFirst), () -> assertEquals(expected, resultDepthFirst));
    }
}
