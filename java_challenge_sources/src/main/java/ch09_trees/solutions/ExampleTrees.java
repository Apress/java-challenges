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
public class ExampleTrees
{
    private ExampleTrees()
    {
    }

    static BinaryTreeNode<String> createExampleTree()
    {
        final BinaryTreeNode<String> a1 = new BinaryTreeNode<>("a1");
        final BinaryTreeNode<String> b2 = new BinaryTreeNode<>("b2");
        final BinaryTreeNode<String> c3 = new BinaryTreeNode<>("c3");
        final BinaryTreeNode<String> d4 = new BinaryTreeNode<>("d4");
        final BinaryTreeNode<String> e5 = new BinaryTreeNode<>("e5");
        final BinaryTreeNode<String> f6 = new BinaryTreeNode<>("f6");
        final BinaryTreeNode<String> g7 = new BinaryTreeNode<>("g7");

        d4.left = b2;
        d4.right = f6;
        b2.left = a1;
        b2.right = c3;
        f6.left = e5;
        f6.right = g7;

        return d4;
    }

    static BinaryTreeNode<String> createNumberTree()
    {
        final BinaryTreeNode<String> _4 = new BinaryTreeNode<>("4");
        TreeUtils.insert(_4, "2");
        TreeUtils.insert(_4, "1");
        TreeUtils.insert(_4, "3");
        TreeUtils.insert(_4, "6");
        TreeUtils.insert(_4, "5");
        TreeUtils.insert(_4, "7");

        return _4;
    }

    static BinaryTreeNode<Integer> createIntegerNumberTree()
    {
        final BinaryTreeNode<Integer> _4 = new BinaryTreeNode<>(4);
        TreeUtils.insert(_4, 2);
        TreeUtils.insert(_4, 1);
        TreeUtils.insert(_4, 3);
        TreeUtils.insert(_4, 6);
        TreeUtils.insert(_4, 5);
        TreeUtils.insert(_4, 7);

        return _4;
    }
}
