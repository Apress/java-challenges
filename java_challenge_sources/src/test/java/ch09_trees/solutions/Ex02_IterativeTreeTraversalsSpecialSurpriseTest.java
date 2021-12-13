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
public class Ex02_IterativeTreeTraversalsSpecialSurpriseTest
{
    @Test
    public void testInorderIterative() throws Exception
    {
        final var root = ExampleTrees.createExampleTree();
        final var expected = List.of("a1", "b2", "c3", "d4", "e5", "f6", "g7");

        final List<String> result = new ArrayList<>();
        Ex02_IterativeTreeTraversals.inorderIterative(root, result::add);

        assertEquals(expected, result);
    }

    @Test
    public void testPreorderIterative() throws Exception
    {
        final var root = ExampleTrees.createExampleTree();
        final var expected = List.of("d4", "b2", "a1", "c3", "f6", "e5", "g7");

        final List<String> result = new ArrayList<>();
        Ex02_IterativeTreeTraversals.preorderIterative(root, result::add);

        assertEquals(expected, result);
    }

    @Test
    public void testPostOrderIterative() throws Exception
    {
        final var root = ExampleTrees.createExampleTree();
        final var expected = List.of("a1", "c3", "b2", "e5", "g7", "f6", "d4");

        final List<String> result = new ArrayList<>();
        Ex02_IterativeTreeTraversals.postorderIterative(root, result::add);

        assertEquals(expected, result);
    }

}
