package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex04_LowestCommonAncestorTest
{
    @ParameterizedTest(name = "findLCA({0}, {1}) = {2}")
    @CsvSource({ "1, 3, 2", "1, 5, 4", "2, 5, 4", "3, 5, 4", "1, 7, 6" })
    void findLCA(final int value1, final int value2, final int expected)
    {
        final var root = createLcaExampleTree();

        final var result = Ex04_LowestCommonAncestor.findLCA(root, value1, value2);

        assertEquals(expected, result.item);
    }

    @Test
    void findLCASpecial()
    {
        final var root = createLcaExampleTree();

        final var result = Ex04_LowestCommonAncestor.findLCA(root, 1, 2);

        assertEquals(2, result.item);
    }

    static BinaryTreeNode<Integer> createLcaExampleTree()
    {
        final BinaryTreeNode<Integer> _6 = new BinaryTreeNode<>(6);
        TreeUtils.insert(_6, 7);
        TreeUtils.insert(_6, 4);
        TreeUtils.insert(_6, 5);
        TreeUtils.insert(_6, 2);
        TreeUtils.insert(_6, 1);
        TreeUtils.insert(_6, 3);

        return _6;
    }

    static BinaryTreeNode<Integer> createLcaExampleTree2()
    {
        final BinaryTreeNode<Integer> _60 = new BinaryTreeNode<>(60);
        TreeUtils.insert(_60, 70);
        TreeUtils.insert(_60, 40);
        TreeUtils.insert(_60, 50);
        TreeUtils.insert(_60, 20);
        TreeUtils.insert(_60, 10);
        TreeUtils.insert(_60, 30);

        return _60;
    }
}