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
public class Ex10_Symmetry
{
    private Ex10_Symmetry()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> root = ExampleTrees.createNumberTree();
        TreeUtils.nicePrint(root);
        System.out.println("symmetric: " + isSymmetric(root));

        final BinaryTreeNode<String> root2 = createSymmetricNumberTree();
        TreeUtils.nicePrint(root2);
        System.out.println("symmetric: " + isSymmetric(root2));

        // Modified tree: Add a 4
        root2.right.left = new BinaryTreeNode<>("4");
        TreeUtils.nicePrint(root2);
        System.out.println("symmetric: " + isSymmetric(root2));
    }

    static BinaryTreeNode<String> createSymmetricNumberTree()
    {
        final BinaryTreeNode<String> root = new BinaryTreeNode<>("1");
        root.left = new BinaryTreeNode<>("2");
        root.right = new BinaryTreeNode<>("2");
        root.left.left = new BinaryTreeNode<>("3");
        root.right.right = new BinaryTreeNode<>("3");
        return root;
    }

    private static void checkSymmetry(final BinaryTreeNode<String> r1)
    {
        System.out.println("symmetric: " + isSymmetric(r1));
        System.out.println("isSymmetricNoValue: " + isSymmetric(r1, false));
        System.out.println("isSymmetricValue:   " + isSymmetric(r1, true));
        System.out.println();
    }

    static <T> boolean isSymmetric(final BinaryTreeNode<T> parent)
    {
        if (parent == null)
            return true;

        return isSymmetric(parent.left, parent.right);
    }

    static <T> boolean isSymmetric(final BinaryTreeNode<T> left, final BinaryTreeNode<T> right)
    {
        if (left == null && right == null)
            return true;

        if (left != null && right != null)
        {
            // Descend both subtrees
            return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
        }

        return false;
    }

    static <T> boolean isSymmetric(final BinaryTreeNode<T> parent, final boolean checkValue)
    {
        if (parent == null)
            return true;

        return isSymmetric(parent.left, parent.right, checkValue);
    }

    static <T> boolean isSymmetric(final BinaryTreeNode<T> left, final BinaryTreeNode<T> right,
                                   final boolean checkValue)
    {
        if (left == null && right == null)
            return true;

        if (left != null && right != null)
        {
            if (checkValue && !left.item.equals(right.item))
                return false;

            return isSymmetric(left.right, right.left, checkValue) && isSymmetric(left.left, right.right, checkValue);
        }
        return false;
    }
}
