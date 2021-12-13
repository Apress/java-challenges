package ch09_trees.solutions;

import java.util.ArrayList;
import java.util.List;
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
public class Ex01_TreeTraversalWithConsumer
{
    private Ex01_TreeTraversalWithConsumer()
    {
    }

    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> root = ExampleTrees.createExampleTree();
        TreeUtils.nicePrint(root);

        System.out.println("\nInorder with consumer: ");
        inorder(root, str -> System.out.print(str + " "));
        System.out.println();

        System.out.println("\toList: " + toList(root));
        System.out.println("toListPreorder: " + toListPreorderV1(root));
        System.out.println("toListPreorder: " + toListPreorder(root));

        System.out.println("inorder in range [c3 - f6]");
        inorder(root, inRange("c3", "f6"));
    }

    static <T> void inorder(final BinaryTreeNode<T> node, final Consumer<T> action)
    {
        if (node == null)
            return;

        inorder(node.left, action);
        action.accept(node.item);
        inorder(node.right, action);
    }

    static <T> void preorder(final BinaryTreeNode<T> node, final Consumer<T> action)
    {
        if (node == null)
            return;

        action.accept(node.item);
        preorder(node.left, action);
        preorder(node.right, action);
    }

    static <T> void postorder(final BinaryTreeNode<T> node, final Consumer<T> action)
    {
        if (node == null)
            return;

        postorder(node.left, action);
        postorder(node.right, action);
        action.accept(node.item);
    }

    static <T> List<T> toList(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return List.of();

        final List<T> result = new ArrayList<>();

        // inorder
        result.addAll(toList(startNode.left));
        result.add(startNode.item);
        result.addAll(toList(startNode.right));

        return result;
    }

    static <T> List<T> toListPreorderV1(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return List.of();

        final List<T> result = new ArrayList<>();

        // preorder
        result.add(startNode.item);
        result.addAll(toListPreorder(startNode.left));
        result.addAll(toListPreorder(startNode.right));

        return result;
    }

    static <T> List<T> toListPreorder(final BinaryTreeNode<T> startNode)
    {
        final List<T> result = new ArrayList<>();
        preorder(startNode, result::add);
        return result;
    }

    static <T> List<T> toListPostorder(final BinaryTreeNode<T> startNode)
    {
        final List<T> result = new ArrayList<>();
        postorder(startNode, result::add);
        return result;
    }

    static <T> List<T> toListPostorderV2(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return List.of();

        final List<T> result = new ArrayList<>();

        // postorder
        result.addAll(toListPostorder(startNode.left));
        result.addAll(toListPostorder(startNode.right));
        result.add(startNode.item);

        return result;
    }

    // Bonus: special consumer that filters

    private static Consumer<String> inRange(final String lower, final String upper)
    {
        return str -> printIfInRange(str, lower, upper);
    }

    private static void printIfInRange(final String str, final String lower, final String upper)
    {
        if (str.compareTo(lower) >= 0 && str.compareTo(upper) <= 0)
        {
            System.out.println(str);
        }
    }
}
