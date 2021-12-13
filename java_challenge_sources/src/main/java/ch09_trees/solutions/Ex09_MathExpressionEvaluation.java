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
public class Ex09_MathExpressionEvaluation
{
    private Ex09_MathExpressionEvaluation()
    {
    }

    public static void main(final String[] args)
    {

        final BinaryTreeNode<String> plus = new BinaryTreeNode<>("+");
        final BinaryTreeNode<String> _3 = new BinaryTreeNode<>("3");
        final BinaryTreeNode<String> mult = new BinaryTreeNode<>("*");
        final BinaryTreeNode<String> _7 = new BinaryTreeNode<>("7");
        final BinaryTreeNode<String> minus = new BinaryTreeNode<>("-");
        final BinaryTreeNode<String> _1 = new BinaryTreeNode<>("1");

        plus.left = _3;
        plus.right = mult;
        mult.left = _7;
        mult.right = minus;
        minus.left = _7;
        minus.right = _1;

        TreeUtils.nicePrint(plus);

        System.out.println("+: " + evaluate(plus));
        System.out.println("*: " + evaluate(mult));
        System.out.println("-: " + evaluate(minus));
        System.out.println("7: " + evaluate(_7));
    }

    // very easy with Java 14 switch ;-)
    static int evaluate(final BinaryTreeNode<String> node)
    {
        final String value = node.item;

        return switch (value)
                        {
                            case "+" -> evaluate(node.left) + evaluate(node.right);
                            case "-" -> evaluate(node.left) - evaluate(node.right);
                            case "*" -> evaluate(node.left) * evaluate(node.right);
                            case "/" -> evaluate(node.left) / evaluate(node.right);
                            default -> Integer.parseInt(value);
                        };
    }
}
