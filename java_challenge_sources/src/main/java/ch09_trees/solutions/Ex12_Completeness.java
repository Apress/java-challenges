package ch09_trees.solutions;

import java.util.LinkedList;
import java.util.Queue;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_Completeness
{
    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> F = createCompletenessExampleTree();
        TreeUtils.nicePrint(F);
        System.out.println("levelorderIsComplete? " + levelorderIsComplete(F));

        // modify: remove leaves under H
        F.right.left = null;
        F.right.right = null;
        TreeUtils.nicePrint(F);
        System.out.println("levelorderIsComplete? " + levelorderIsComplete(F));
    }

    protected static BinaryTreeNode<String> createCompletenessExampleTree()
    {
        final BinaryTreeNode<String> F = new BinaryTreeNode<>("F");
        TreeUtils.insert(F, "D");
        TreeUtils.insert(F, "H");
        TreeUtils.insert(F, "B");
        TreeUtils.insert(F, "E");
        TreeUtils.insert(F, "A");
        TreeUtils.insert(F, "C");
        TreeUtils.insert(F, "G");
        TreeUtils.insert(F, "I");
        return F;
    }

    static <T> int nodeCount(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return 0;

        return 1 + nodeCount(startNode.left) + nodeCount(startNode.right);
    }

    static <T> boolean isFull(final BinaryTreeNode<T> currentNode)
    {
        if (currentNode == null)
            return true;

        return isFull(currentNode.left, currentNode.right);
    }

    static <T> boolean isFull(final BinaryTreeNode<T> leftNode, final BinaryTreeNode<T> rightNode)
    {
        if (leftNode == null && rightNode == null)
            return true;

        if (leftNode != null && rightNode != null)
            return isFull(leftNode) && isFull(rightNode);

        return false;
    }

    // to do this, all the leaves must be at the same height
    static <T> boolean isPerfect(final BinaryTreeNode<T> parent)
    {
        if (parent == null)
            return true;

        final int height = Ex03_TreeHeight.getHeight(parent);

        return isPerfect(parent.left, parent.right, height, 1);
    }

    static <T> boolean isPerfect(final BinaryTreeNode<T> leftNode, final BinaryTreeNode<T> rightNode, final int height,
                                 final int currentLevel)
    {
        if (leftNode == null || rightNode == null)
            return false;

        if (leftNode.isLeaf() && rightNode.isLeaf())
            return onSameHeight(leftNode, rightNode, height, currentLevel);

        return isPerfect(leftNode.left, leftNode.right, height, currentLevel + 1)
                        && isPerfect(rightNode.left, rightNode.right, height, currentLevel + 1);
    }

    static <T> boolean onSameHeight(final BinaryTreeNode<T> leftNode, final BinaryTreeNode<T> rightNode,
                                    final int height, final int currentLevel)
    {
        return Ex03_TreeHeight.getHeight(leftNode) + currentLevel == height
                        && Ex03_TreeHeight.getHeight(rightNode) + currentLevel == height;
    }

    // -------------------------------------------------------------------

    static <T> boolean levelorderIsComplete(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return false;

        final Queue<BinaryTreeNode<T>> toProcess = new LinkedList<>();
        toProcess.offer(startNode);

        boolean missingNode = false;

        while (!toProcess.isEmpty())
        {
            final BinaryTreeNode<T> current = toProcess.poll();

            // Only descendants on the right side
            if (current.left == null && current.right != null)
                return false;

            // If a missing node was previously detected, then the next one must be only one leaf
            if (missingNode && !current.isLeaf())
                return false;

            // Include subelements, mark if not complete
            if (current.left != null)
                toProcess.offer(current.left);
            else
                missingNode = true;

            if (current.right != null)
                toProcess.offer(current.right);
            else
                missingNode = true;
        }

        // All nodes successfully processed
        return true;
    }
}
