package ch09_trees.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex03_TreeHeightTest
{
    @Test
    void getHeight()
    {
        final var root = Ex03_TreeHeight.createHeightExampleTree();

        final var result = Ex03_TreeHeight.getHeight(root);

        assertEquals(4, result);
    }
}
