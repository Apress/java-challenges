package ch09_trees.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.solutions.Ex13_TreePrinter;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class TreeUtils
{
    public static <T extends Comparable<T>> BinaryTreeNode<T> insert(final BinaryTreeNode<T> root, final T value)
    {
        // recursive termination
        if (root == null)
            return new BinaryTreeNode<>(value);

        // recursive descent to the left or right depending on the comparison
        final int compareResult = root.item.compareTo(value);
        if (compareResult > 0)
            root.left = insert(root.left, value);
        else if (compareResult < 0)
            root.right = insert(root.right, value);

        return root;
    }

    public static <T> void inorder(final BinaryTreeNode<T> currentNode)
    {
        if (currentNode != null)
        {
            inorder(currentNode.left);
            System.out.println(currentNode.item);
            inorder(currentNode.right);
        }
    }

    public static <T> void preorder(final BinaryTreeNode<T> currentNode)
    {
        if (currentNode != null)
        {
            System.out.println(currentNode.item);
            preorder(currentNode.left);
            preorder(currentNode.right);
        }
    }

    public static <T> void postorder(final BinaryTreeNode<T> currentNode)
    {
        if (currentNode != null)
        {
            postorder(currentNode.left);
            postorder(currentNode.right);
            System.out.println(currentNode.item);
        }
    }

    public static <T> void levelOrder(final BinaryTreeNode<T> node)
    {
        if (node == null)
            return;

        final Queue<BinaryTreeNode<T>> toProcess = new LinkedList<>();
        toProcess.offer(node);

        while (!toProcess.isEmpty())
        {
            final BinaryTreeNode<T> currentNode = toProcess.poll();
            System.out.println(currentNode.item);

            if (currentNode.left != null)
                toProcess.offer(currentNode.left);

            if (currentNode.right != null)
                toProcess.offer(currentNode.right);
        }
    }

    public static <T> void levelOrder(final BinaryTreeNode<T> node, final Consumer<T> action)
    {
        if (node == null)
            return;

        final Queue<BinaryTreeNode<T>> toProcess = new LinkedList<>();
        toProcess.offer(node);

        while (!toProcess.isEmpty())
        {
            final BinaryTreeNode<T> currentNode = toProcess.poll();
            action.accept(currentNode.item);

            if (currentNode.left != null)
                toProcess.offer(currentNode.left);

            if (currentNode.right != null)
                toProcess.offer(currentNode.right);
        }
    }

    public static <T> void nicePrint(final BinaryTreeNode<T> root)
    {
        Ex13_TreePrinter.nicePrint(root);
    }

    // Rotation
    static <T> BinaryTreeNode<T> rotateLeft(final BinaryTreeNode<T> startNode)
    {
        final BinaryTreeNode<T> newRoot = startNode.right;
        final BinaryTreeNode<T> newSubRight = startNode.right.left;

        startNode.right = newSubRight;
        newRoot.left = startNode;

        return newRoot;
    }

    static <T> BinaryTreeNode<T> rotateRight(final BinaryTreeNode<T> startNode)
    {
        final BinaryTreeNode<T> newRoot = startNode.left;
        final BinaryTreeNode<T> newSubLeft = startNode.left.right;

        startNode.left = newSubLeft;
        newRoot.right = startNode;

        return newRoot;
    }

    // just for BST

    public static <T extends Comparable<T>> BinaryTreeNode<T> find(final BinaryTreeNode<T> currentNode,
                                                                   final T searchFor)
    {
        if (currentNode == null)
            return null;

        if (currentNode.item.compareTo(searchFor) < 0)
            return find(currentNode.right, searchFor);

        if (currentNode.item.compareTo(searchFor) > 0)
            return find(currentNode.left, searchFor);

        return currentNode;
    }
}
