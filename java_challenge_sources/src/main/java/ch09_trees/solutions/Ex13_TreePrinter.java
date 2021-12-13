package ch09_trees.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
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
public class Ex13_TreePrinter
{
    public static void main(final String[] args)
    {
        final BinaryTreeNode<String> F = createTreePrintExampleTree();
        nicePrintV1(F);
        nicePrint(F);

        // modify: remove leaves under H
        F.right.left = null;
        F.right.right = null;
        nicePrintV1(F);
        nicePrint(F);

        final BinaryTreeNode<String> big = createBigTree();
        nicePrintV1(big);
        nicePrint(big);

        final BinaryTreeNode<String> monster = createMonsterTree();
        nicePrintV1(monster);
        nicePrint(monster);
    }

    protected static BinaryTreeNode<String> createTreePrintExampleTree()
    {
        final BinaryTreeNode<String> F = new BinaryTreeNode<>("F");
        TreeUtils.insert(F, "D");
        TreeUtils.insert(F, "H");
        TreeUtils.insert(F, "B");
        TreeUtils.insert(F, "A");
        TreeUtils.insert(F, "C");
        TreeUtils.insert(F, "I");
        return F;
    }

    protected static BinaryTreeNode<String> createBigTree()
    {
        final var d4a = ExampleTrees.createExampleTree();
        final var d4b = ExampleTrees.createExampleTree();
        final var BIG = new BinaryTreeNode<>("BIG");
        BIG.left = Ex07_RotateBinaryTree.rotateRight(d4a);
        BIG.right = Ex07_RotateBinaryTree.rotateLeft(d4b);
        return BIG;
    }

    protected static BinaryTreeNode<String> createMonsterTree()
    {
        final var mon = new BinaryTreeNode<>("MON");
        mon.left = createBigTree();
        mon.right = createBigTree();
        return mon;
    }

    static int subtreeWidth(final int height)
    {
        if (height <= 0)
            return 0;

        final int leafWidth = 3;
        final int spacing = 3;

        final int maxNumOfLeaves = (int) Math.pow(2, height - 1);
        final int widthOfTree = maxNumOfLeaves * leafWidth + (maxNumOfLeaves - 1) * spacing;
        final int widthOfSubtree = (widthOfTree - spacing) / 2;

        return widthOfSubtree;
    }


    static <T> String drawNode(final BinaryTreeNode<T> currentNode, final int lineLength)
    {
        String strNode = "   ";
        strNode += spacing(lineLength);
        strNode += stringifyNodeValue(currentNode);
        strNode += spacing(lineLength);

        return strNode;
    }

    static <T> String stringifyNodeValue(final BinaryTreeNode<T> node)
    {
        if (node == null || node.item == null)
            return "   ";

        final String nodeValue = "" + node.item;
        if (nodeValue.length() == 1)
            return " " + nodeValue + " ";
        if (nodeValue.length() == 2)
            return nodeValue + " ";

        return nodeValue.substring(0, 3);
    }

    static String spacing(final int lineLength)
    {
        return " ".repeat(lineLength);
    }

    static <T> String drawConnections(final BinaryTreeNode<T> currentNode,
                                      final int lineLength)
    {
        if (currentNode == null)
            return "   " + spacing(lineLength) + "   " + spacing(lineLength) + "   ";

        String connection = drawLeftConnectionPart(currentNode, lineLength);
        connection += drawJunction(currentNode);
        connection += drawRightConnectionPart(currentNode, lineLength);
        return connection;
    }

    static <T> String drawLeftConnectionPart(final BinaryTreeNode<T> currentNode,
                                             final int lineLength)
    {
        if (currentNode.left == null)
            return "   " + spacing(lineLength);

        return " |-" + drawLine(lineLength);
    }

    static <T> String drawJunction(final BinaryTreeNode<T> currentNode)
    {
        if (currentNode.left == null && currentNode.right == null)
            return "   ";
        else if (currentNode.left == null)
            return " +-";
        else if (currentNode.right == null)
            return "-+ ";

        return "-+-";
    }

    static <T> String drawRightConnectionPart(final BinaryTreeNode<T> currentNode,
                                              final int lineLength)
    {
        if (currentNode.right == null)
            return spacing(lineLength) + "   ";

        return drawLine(lineLength) + "-| ";
    }

    static String drawLine(final int lineLength)
    {
        return "-".repeat(lineLength);
    }

    static <T> void nicePrintV1(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return;

        final int treeHeight = Ex03_TreeHeight.getHeight(startNode);
        final List<BinaryTreeNode<T>> allNodes = fillNodeArray(startNode);

        // traverse level by level
        int offset = 0;
        final List<String> lines = new ArrayList<>();
        for (int level = 0; level < treeHeight; level++)
        {
            final int lineLength = subtreeWidth(treeHeight - 1 - level);

            // Indent previous lines to the right
            for (int i = 0; i < lines.size(); i++)
            {
                lines.set(i, "   " + spacing(lineLength) + lines.get(i).stripTrailing());
            }

            final int nodesPerLevel = (int) Math.pow(2, level);
            String nodeLine = "";
            String connectionLine = "";

            for (int pos = 0; pos < nodesPerLevel; pos++)
            {
                final BinaryTreeNode<T> currentNode = allNodes.get(offset + pos);

                nodeLine += drawNode(currentNode, lineLength);
                nodeLine += spacingBetweenNodes(treeHeight, level);
                connectionLine += drawConnections(currentNode, lineLength);
                connectionLine += spacingBetweenConnections(treeHeight, level);
            }

            lines.add(nodeLine.stripTrailing());
            lines.add(connectionLine.stripTrailing());

            // Jump forward in the array
            offset += nodesPerLevel;
        }

        lines.forEach(System.out::println);
    }

    static String spacingBetweenNodes(final int treeHeight, final int level)
    {
        final int spacingLength = subtreeWidth(treeHeight - level);
        String spacing = " ".repeat(spacingLength);
        if (spacingLength > 0)
            spacing += "   ";
        return spacing;
    }


    static String spacingBetweenConnections(final int treeHeight, final int level)
    {
        final int spacingLength = subtreeWidth(treeHeight - level);
        return " ".repeat(spacingLength);
    }


    static <T> List<BinaryTreeNode<T>> fillNodeArray(final BinaryTreeNode<T> startNode)
    {
        final int height = Ex03_TreeHeight.getHeight(startNode);
        final int maxNodeCount = (int) Math.pow(2, height);

        final List<BinaryTreeNode<T>> nodes = new ArrayList<>(Collections.nCopies(maxNodeCount, null));

        traverseAndMark(startNode, nodes, 0);

        return nodes;
    }

    static <T> void traverseAndMark(final BinaryTreeNode<T> startNode,
                                    final List<BinaryTreeNode<T>> nodes,
                                    final int pos)
    {
        // recursive termination
        if (startNode == null)
            return;
        if (pos >= nodes.size())
            return;

        // action
        nodes.set(pos, startNode);

        traverseAndMark(startNode.left, nodes, pos * 2 + 1);
        traverseAndMark(startNode.right, nodes, pos * 2 + 2);
    }

    static class Pair<T1, T2>
    {
        final T1 first;

        final T2 second;

        public Pair(final T1 left, final T2 right)
        {
            this.first = left;
            this.second = right;
        }
    }

    public static <T> void nicePrint(final BinaryTreeNode<T> startNode)
    {
        if (startNode == null)
            return;

        final int treeHeight = Ex03_TreeHeight.getHeight(startNode);
        final List<String> lines = new ArrayList<>();

        int level = 0;
        String nodeLine = "";
        String connectionLine = "";

        final Queue<Pair<BinaryTreeNode<T>, Integer>> toProcess = new LinkedList<>();
        toProcess.offer(new Pair<>(startNode, 0));

        while (!toProcess.isEmpty() && level < treeHeight)
        {
            // Levelorder
            final Pair<BinaryTreeNode<T>, Integer> current = toProcess.poll();
            final BinaryTreeNode<T> currentNode = current.first;
            final int nodelevel = current.second;

            // action
            int lineLength = subtreeWidth(treeHeight - 1 - level);

            // change in level
            if (level != nodelevel)
            {
                level = nodelevel;
                lineLength = subtreeWidth(treeHeight - 1 - level);

                lines.add(nodeLine.stripTrailing());
                lines.add(connectionLine.stripTrailing());
                nodeLine = "";
                connectionLine = "";

                // Indent previous lines to the right
                for (int i = 0; i < lines.size(); i++)
                {
                    lines.set(i, "   " + spacing(lineLength) + lines.get(i));
                }
            }

            nodeLine += drawNode(currentNode, lineLength);
            nodeLine += spacingBetweenNodes(treeHeight, level);
            connectionLine += drawConnections(currentNode, lineLength);
            connectionLine += spacingBetweenConnections(treeHeight, level);

            // Levelorder
            if (currentNode != null)
            {
                toProcess.offer(new Pair<>(currentNode.left, level + 1));
                toProcess.offer(new Pair<>(currentNode.right, level + 1));
            }
            else
            {
                // artificial placeholders for correct layout
                toProcess.offer(new Pair<>(null, level + 1));
                toProcess.offer(new Pair<>(null, level + 1));
            }
        }

        lines.forEach(System.out::println);
    }
}
