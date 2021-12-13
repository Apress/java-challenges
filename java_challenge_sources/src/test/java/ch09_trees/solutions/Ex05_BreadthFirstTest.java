package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex05_BreadthFirstTest
{
    @Test
    public void testLevelorder()
    {
        var root = Ex05_BreadthFirst.createExampleLevelorderTree();
        var expected = List.of("1", "2", "3", "4", "5", "6", "7");

        final List<String> result = new ArrayList<>();
        Ex05_BreadthFirst.levelorder(root, result::add);

        assertEquals(expected, result);
    }

    @Test
    public void testLevelorderRecursive()
    {
        var root = Ex05_BreadthFirst.createExampleLevelorderTree();
        var expected = List.of("1", "2", "3", "4", "5", "6", "7");

        final List<String> result = new ArrayList<>();
        Ex05_BreadthFirst.levelorderRecursive(root, result::add);

        assertEquals(expected, result);
    }
}
