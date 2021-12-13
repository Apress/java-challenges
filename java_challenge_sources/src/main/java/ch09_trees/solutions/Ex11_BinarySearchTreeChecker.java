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
public class Ex11_BinarySearchTreeChecker
{
    private Ex11_BinarySearchTreeChecker()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<Integer> _4 = ExampleTrees.createIntegerNumberTree();
        TreeUtils.nicePrint(_4);

        final BinaryTreeNode<Integer> _2 = _4.left;
        final BinaryTreeNode<Integer> _6 = _4.right;

        System.out.println("isBST(_4): " + isBST(_4));
        System.out.println("isBST(_2): " + isBST(_2));
        System.out.println("isBST(_6): " + isBST(_6));
        System.out.println();

        // change tree on left side in bad way, change right correctly
        _2.left = new BinaryTreeNode<>(13);
        _6.right = null;

        TreeUtils.nicePrint(_4);
        System.out.println("isBST(_4): " + isBST(_4));
        System.out.println("isBST(_2): " + isBST(_2));
        System.out.println("isBST(_6): " + isBST(_6));
    }

    static boolean isBST(final BinaryTreeNode<Integer> node)
    {
        // recursive termination
        if (node == null)
            return true;

        if (node.isLeaf())
            return true;

        // recursive descent
        boolean isLeftBST = false;
        boolean isRightBST = false;
        if (node.left != null)
        {
            isLeftBST = node.left .item < node.item && isBST(node.left);
        }
        if (node.right != null)
        {
            isRightBST = node.right.item > node.item && isBST(node.right);
        }

        return isLeftBST && isRightBST;
    }
}
