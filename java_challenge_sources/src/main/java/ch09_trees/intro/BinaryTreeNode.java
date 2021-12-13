package ch09_trees.intro;

import java.util.Objects;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class BinaryTreeNode<T>
{
    /*private*/ public final T           item;

    /*private*/ public BinaryTreeNode<T> left;

    /*private*/ public BinaryTreeNode<T> right;

    public BinaryTreeNode(final T item)
    {
        this.item = item;
    }

    @Override
    public String toString()
    {
        return String.format("BinaryTreeNode [item=%s]", item);
    }

    // for depth calculation
    public boolean isLeaf()
    {
        return left == null && right == null;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(item);
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        final BinaryTreeNode<T> other = (BinaryTreeNode<T>) obj;
        return Objects.equals(item, other.item);
    }
}
