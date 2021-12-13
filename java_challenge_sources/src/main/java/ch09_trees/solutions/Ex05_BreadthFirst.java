package ch09_trees.solutions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_BreadthFirst
{
    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> _1 = createExampleLevelorderTree();
        TreeUtils.nicePrint(_1);

        System.out.print("\nLevelorder: ");
        levelorder(_1, value -> System.out.print(value + " "));

        System.out.println("\nlevelorderRecursive: ");
        levelorderRecursive(_1, value -> System.out.print(value + " "));
        System.out.println();

        final BinaryTreeNode<String> M = createExampleLevelorderNameTree();
        TreeUtils.nicePrint(M);

        System.out.print("\nLevelorder: ");
        levelorder(M, value -> System.out.print(value + " "));

        System.out.println("\nlevelorderRecursive: ");
        levelorderRecursive(M, value -> System.out.print(value + " "));
    }

    static BinaryTreeNode<String> createExampleLevelorderTree()
    {
        final BinaryTreeNode<String> _1 = new BinaryTreeNode<>("1");
        final BinaryTreeNode<String> _2 = new BinaryTreeNode<>("2");
        final BinaryTreeNode<String> _3 = new BinaryTreeNode<>("3");
        final BinaryTreeNode<String> _4 = new BinaryTreeNode<>("4");
        final BinaryTreeNode<String> _5 = new BinaryTreeNode<>("5");
        final BinaryTreeNode<String> _6 = new BinaryTreeNode<>("6");
        final BinaryTreeNode<String> _7 = new BinaryTreeNode<>("7");

        _1.left = _2;
        _1.right = _3;
        _2.left = _4;
        _2.right = _5;
        _3.left = _6;
        _3.right = _7;

        return _1;
    }

    static BinaryTreeNode<String> createExampleLevelorderNameTree()
    {
        final BinaryTreeNode<String> M = new BinaryTreeNode<>("M");
        final BinaryTreeNode<String> I = new BinaryTreeNode<>("I");
        final BinaryTreeNode<String> C = new BinaryTreeNode<>("C");
        final BinaryTreeNode<String> H = new BinaryTreeNode<>("H");
        final BinaryTreeNode<String> A = new BinaryTreeNode<>("A");
        final BinaryTreeNode<String> E = new BinaryTreeNode<>("E");
        final BinaryTreeNode<String> L = new BinaryTreeNode<>("L");

        M.left = I;
        M.right = C;
        I.left = H;
        I.right = A;
        C.left = E;
        C.right = L;

        return M;
    }

    static <T> void levelorder(final BinaryTreeNode<T> startNode, final Consumer<T> action)
    {
        if (startNode == null)
            return;

        final Queue<BinaryTreeNode<T>> toProcess = new LinkedList<>();
        toProcess.offer(startNode);

        while (!toProcess.isEmpty())
        {
            final BinaryTreeNode<T> currentNode = toProcess.poll();
            if (currentNode != null)
            {
                action.accept(currentNode.item);

                toProcess.offer(currentNode.left);
                toProcess.offer(currentNode.right);
            }
        }
    }

    // -----------

    static <T> void levelorderRecursive(final BinaryTreeNode<T> startNode, final Consumer<T> action)
    {
        if (startNode == null)
            return;

        final Queue<BinaryTreeNode<T>> toProcess = new LinkedList<>();
        toProcess.offer(startNode);

        levelorderRecursive(toProcess, action);
    }

    static <T> void levelorderRecursive(final Queue<BinaryTreeNode<T>> toProcess, final Consumer<T> action)
    {
        if (toProcess.isEmpty())
            return;

        final BinaryTreeNode<T> current = toProcess.poll();
        action.accept(current.item);

        if (current.left != null)
            toProcess.offer(current.left);

        if (current.right != null)
            toProcess.offer(current.right);

        levelorderRecursive(toProcess, action);
    }
}