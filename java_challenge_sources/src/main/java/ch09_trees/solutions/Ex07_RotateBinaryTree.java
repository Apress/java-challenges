package ch09_trees.solutions;

import ch09_trees.intro.BinaryTreeNode;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_RotateBinaryTree
{
    private Ex07_RotateBinaryTree()
    {
    }

    static <T> BinaryTreeNode<T> rotateLeft(final BinaryTreeNode<T> rootNode)
    {
        if (rootNode.right == null)
            throw new IllegalStateException("can't rotate left, no valid root");

        final BinaryTreeNode<T> rc = rootNode.right;
        final BinaryTreeNode<T> rlc = rootNode.right.left;

        rootNode.right = rlc;
        rc.left = rootNode;

        return rc;
    }

    static <T> BinaryTreeNode<T> rotateRight(final BinaryTreeNode<T> rootNode)
    {
        if (rootNode.left == null)
            throw new IllegalStateException("can't rotate right, no valid root");

        final BinaryTreeNode<T> lc = rootNode.left;
        final BinaryTreeNode<T> lrc = rootNode.left.right;

        rootNode.left = lrc;
        lc.right = rootNode;

        return lc;
    }
}
