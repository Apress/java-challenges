package ch07_lists.solutions;

import java.util.LinkedList;
import java.util.List;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_Stack<T>
{
    private final List<T> values = new LinkedList<>();

    public void push(final T elem)
    {
        values.add(0, elem);
    }

    public T pop()
    {
        if (isEmpty())
            throw new Ex06_StackIsEmptyException();

        return values.remove(0);
    }

    public T peek()
    {
        if (isEmpty())
            throw new Ex06_StackIsEmptyException();

        return values.get(0);
    }

    public boolean isEmpty()
    {
        return values.isEmpty();
    }

    static class Ex06_StackIsEmptyException extends RuntimeException
    {
    }

    public static void main(final String[] args)
    {
        final Ex06_Stack<String> stack = new Ex06_Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        System.out.println("PEEK: " + stack.peek());
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        System.out.println("ISEMPTY: " + stack.isEmpty());
        System.out.println("POP: " + stack.pop());
    }
}
