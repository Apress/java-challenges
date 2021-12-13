package ch09_trees.solutions;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import ch09_trees.intro.BinaryTreeNode;
import ch09_trees.utils.TreeUtils;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_LevelSum
{
    private Ex06_LevelSum()
    {
    }

    static BinaryTreeNode<Integer> createExampleLevelSumTree()
    {
        final BinaryTreeNode<Integer> _4 = new BinaryTreeNode<>(4);
        TreeUtils.insert(_4, 2);
        TreeUtils.insert(_4, 1);
        TreeUtils.insert(_4, 3);
        TreeUtils.insert(_4, 6);
        TreeUtils.insert(_4, 5);
        TreeUtils.insert(_4, 8);
        TreeUtils.insert(_4, 7);
        TreeUtils.insert(_4, 9);

        return _4;
    }

    static Map<Integer, Integer> levelSum(final BinaryTreeNode<Integer> startNode)
    {
        if (startNode == null)
            return Map.of();

        final Map<Integer, Integer> result = new TreeMap<>();

        final Queue<TreeNodeLevelPair> toProcess = new LinkedList<>();
        toProcess.offer(new TreeNodeLevelPair(startNode, 0));

        while (!toProcess.isEmpty())
        {
            final TreeNodeLevelPair current = toProcess.poll();

            final BinaryTreeNode<Integer> currentNode = current.first;
            final int nodeValue = currentNode.item;
            final int level = current.second;

            result.putIfAbsent(level, 0);
            result.computeIfPresent(level, (key, value) -> value + nodeValue);

            if (currentNode.left != null)
                toProcess.offer(new TreeNodeLevelPair(currentNode.left, level + 1));

            if (currentNode.right != null)
                toProcess.offer(new TreeNodeLevelPair(currentNode.right, level + 1));
        }

        return result;
    }

    // Variant with depth first traveesal

    static Map<Integer, Integer> levelSumDepthFirst(final BinaryTreeNode<Integer> root)
    {
        final Map<Integer, Integer> result = new TreeMap<>();
        traverseDepthFirst(root, 0, result);
        return result;
    }

    private static void traverseDepthFirst(final BinaryTreeNode<Integer> currentNode, final int level,
                                           final Map<Integer, Integer> result)
    {
        if (currentNode != null)
        {
            // PRE: result.put(level, result.getOrDefault(level, 0) + currentNode.item);
            traverseDepthFirst(currentNode.left, level + 1, result);
            result.put(level, result.getOrDefault(level, 0) + currentNode.item);
            traverseDepthFirst(currentNode.right, level + 1, result);
            // POST: map.result(level, result.getOrDefault(level, 0) + currentNode.item);
        }
    }

    record TreeNodeLevelPair(BinaryTreeNode<Integer> first, Integer second)
    {
    }
}
