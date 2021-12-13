package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch09_trees.intro.BinaryTreeNode;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_RotateBinaryTreeTest
{
    @Test
    public void testRotateLeft()
    {
        final BinaryTreeNode<String> root = ExampleTrees.createExampleTree();
        var expected = List.of("f6", "d4", "g7", "b2", "e5", "a1", "c3");

        var leftRotatedRoot = Ex07_RotateBinaryTree.rotateLeft(root);
        final List<String> result = convertToList(leftRotatedRoot);

        assertEquals(expected, result);
    }

    @Test
    public void testRotateRight()
    {
        final BinaryTreeNode<String> root = ExampleTrees.createExampleTree();
        var expected = List.of("b2", "a1", "d4", "c3", "f6", "e5", "g7");

        var rightRotatedRoot = Ex07_RotateBinaryTree.rotateRight(root);
        final List<String> result = convertToList(rightRotatedRoot);

        assertEquals(expected, result);
    }

    private List<String> convertToList(BinaryTreeNode<String> leftRotatedRoot)
    {
        final List<String> result = new ArrayList<>();
        Ex05_BreadthFirst.levelorder(leftRotatedRoot, result::add);
        return result;
    }
}
