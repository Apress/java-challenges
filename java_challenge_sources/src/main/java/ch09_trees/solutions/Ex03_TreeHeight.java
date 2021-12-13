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
public class Ex03_TreeHeight
{
    private Ex03_TreeHeight()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> e = createHeightExampleTree();
        TreeUtils.nicePrint(e);

        printInfo(e.left, e, e.right, e.right.right.right);
    }

    protected static BinaryTreeNode<String> createHeightExampleTree()
    {
        final BinaryTreeNode<String> e = new BinaryTreeNode<>("E");
        TreeUtils.insert(e, "C");
        TreeUtils.insert(e, "A");
        TreeUtils.insert(e, "G");
        TreeUtils.insert(e, "F");
        TreeUtils.insert(e, "H");
        TreeUtils.insert(e, "I");
        return e;
    }

    private static void printInfo(final BinaryTreeNode<String> c, final BinaryTreeNode<String> e,
                                  final BinaryTreeNode<String> g, final BinaryTreeNode<String> i)
    {
        System.out.println("\nHeight of root E: " + getHeight(e));
        System.out.println("Height from leftParent C:  " + getHeight(c));
        System.out.println("Height from rightParent G: " + getHeight(g));
        System.out.println("Height from rightChild I:  " + getHeight(i));
    }

    static <T> int getHeight(final BinaryTreeNode<T> parent)
    {
        // recursive termination
        if (parent == null)
            return 0;

        // recursive descent
        final int leftHeight = getHeight(parent.left);
        final int rightHeight = getHeight(parent.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
