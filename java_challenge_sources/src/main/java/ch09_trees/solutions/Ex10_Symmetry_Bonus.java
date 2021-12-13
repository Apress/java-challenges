package ch09_trees.solutions;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex10_Symmetry_Bonus
{
    private Ex10_Symmetry_Bonus()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> root = ExampleTrees.createNumberTree();
        TreeUtils.nicePrint(root);
        final BinaryTreeNode<String> newRoot = invert(root);
        TreeUtils.nicePrint(newRoot);
    }

    static <T> BinaryTreeNode<T> invert(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return null;

        final BinaryTreeNode<T> invertedRight = invert(startNode.right);
        final BinaryTreeNode<T> invertedLeft = invert(startNode.left);

        startNode.left = invertedRight;
        startNode.right = invertedLeft;

        return startNode;
    }
}
