package ch09_trees.solutions;

import java.util.Stack;

import ch09_trees.intro.BinaryTreeNode;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex02_IterativeTreeTraversalsSpecialSurprise
{
    private Ex02_IterativeTreeTraversalsSpecialSurprise()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> d4 = ExampleTrees.createExampleTree();
        traverse(d4, Order.PREORDER);
        traverse(d4, Order.INORDER);
        inorder(d4);
        traverse(d4, Order.POSTORDER);

        final BinaryTreeNode<String> a = new BinaryTreeNode<>("a");
        final BinaryTreeNode<String> b = new BinaryTreeNode<>("b");
        final BinaryTreeNode<String> c = new BinaryTreeNode<>("c");
        final BinaryTreeNode<String> d = new BinaryTreeNode<>("d");
        final BinaryTreeNode<String> e = new BinaryTreeNode<>("e");
        final BinaryTreeNode<String> f = new BinaryTreeNode<>("f");
        final BinaryTreeNode<String> g = new BinaryTreeNode<>("g");
        final BinaryTreeNode<String> h = new BinaryTreeNode<>("h");
        final BinaryTreeNode<String> i = new BinaryTreeNode<>("i");
        final BinaryTreeNode<String> j = new BinaryTreeNode<>("j");
        final BinaryTreeNode<String> k = new BinaryTreeNode<>("k");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = h;
        e.left = i;
        e.right = j;
        c.left = f;
        c.right = g;
        f.right = k;

        traverse(a, Order.PREORDER);
        traverse(a, Order.INORDER);
        inorder(a);
        traverse(a, Order.POSTORDER);
    }

    private static <T> void inorder(final BinaryTreeNode<T> root)
    {
        final Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            final BinaryTreeNode<T> currentNode = stack.pop();
            if (currentNode != null)
            {
                if (currentNode.isLeaf())
                    System.out.print(currentNode.item + " ");
                else
                {
                    stack.push(currentNode.right);
                    stack.push(new BinaryTreeNode<T>(currentNode.item));
                    stack.push(currentNode.left);
                }
            }
        }
        System.out.println();
    }

    enum Order {
        PREORDER, INORDER, POSTORDER
    }

    private static <T> void traverse(final BinaryTreeNode<T> root, final Order order)
    {
        final Stack<BinaryTreeNode<T>> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty())
        {
            final BinaryTreeNode<T> currentNode = stack.pop();
            if (currentNode != null)
            {
                if (currentNode.isLeaf())
                {
                    System.out.print(currentNode.item + " ");
                }
                else
                {
                    if (order == Order.POSTORDER)
                        stack.push(new BinaryTreeNode<T>(currentNode.item));

                    stack.push(currentNode.right);

                    if (order == Order.INORDER)
                        stack.push(new BinaryTreeNode<T>(currentNode.item));

                    stack.push(currentNode.left);

                    if (order == Order.PREORDER)
                        stack.push(new BinaryTreeNode<T>(currentNode.item));
                }
            }
        }
        System.out.println();
    }
}