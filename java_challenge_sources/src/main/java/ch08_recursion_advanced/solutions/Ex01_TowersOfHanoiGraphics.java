package ch08_recursion_advanced.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex01_TowersOfHanoiGraphics
{
    private Ex01_TowersOfHanoiGraphics()
    {
    }

    public static void main(final String[] args)
    {
        System.out.println("Tower Of Hanoi 2");
        solveHanoi(2);
    }

    static class Tower
    {
        final String         name;

        final Stack<Integer> values = new Stack<>();

        public Tower(final String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return "Tower [" + name + "]";
        }

        // must be odd
        List<String> printTowerOld(final int maxHeight)
        {
            final int height = values.size() - 1;

            final List<String> visual = new ArrayList<>();

            // append blank lines
            for (int i = maxHeight - height - 1; i > 0; i--)
            {
                final int padding = maxHeight;

                final String line = repeatCharSequence(" ", padding) + "|" + repeatCharSequence(" ", padding);
                visual.add(line);
            }
            for (int i = height; i >= 0; i--)
            {
                final int value = values.get(i);
                final int padding = maxHeight - value;

                final String line = repeatCharSequence(" ", padding) + repeatCharSequence("#", value) + "|"
                                + repeatCharSequence("#", value) + repeatCharSequence(" ", padding);
                visual.add(line);
            }

            // bottom line
            final String line = repeatCharSequence("-", maxHeight * 2 + 1);
            visual.add(line);

            return visual;
        }

        List<String> printTower(final int maxHeight)
        {
            final int height = values.size() - 1;

            final List<String> visual = new ArrayList<>();

            visual.addAll(drawTop(maxHeight, height));
            visual.addAll(drawSlices(maxHeight, height));
            visual.add(drawBottom(maxHeight));

            return visual;
        }

        private List<String> drawTop(final int maxHeight, final int height)
        {
            final List<String> visual = new ArrayList<>();
            final String nameLine = repeatCharSequence(" ", maxHeight) + name +
                            repeatCharSequence(" ", maxHeight);
            visual.add(nameLine);

            for (int i = maxHeight - height - 1; i > 0; i--)
            {
                final String line = repeatCharSequence(" ", maxHeight) + "|" +
                                repeatCharSequence(" ", maxHeight);
                visual.add(line);
            }
            return visual;
        }

        private List<String> drawSlices(final int maxHeight, final int height)
        {
            final List<String> visual = new ArrayList<>();

            for (int i = height; i >= 0; i--)
            {
                final int value = values.get(i);
                final int padding = maxHeight - value;

                final String line = repeatCharSequence(" ", padding) +
                                repeatCharSequence("#", value) + "|" +
                                repeatCharSequence("#", value) +
                                repeatCharSequence(" ", padding);
                visual.add(line);
            }
            return visual;
        }

        private static String drawBottom(final int height)
        {
            return repeatCharSequence("-", height * 2 + 1);
        }

        static String repeatCharSequence(final String character, final int length)
        {
            String str = "";
            for (int i = 0; i < length; i++)
            {
                str += character;
            }

            return str;
        }

        public void push(final Integer item)
        {
            values.push(item);
        }

        public Integer pop()
        {
            return values.pop();
        }
    }

    static void solveHanoi(final int n)
    {
        final Tower source = new Tower("A");
        final Tower helper = new Tower("B");
        final Tower destination = new Tower("C");

        // Attention: reverse order since it is a stack
        for (int i = n; i > 0; i--)
            source.push(i);

        final Runnable action = () -> printTowers(n+1, source, helper, destination);
        action.run();
        moveTower(n, source, helper, destination, action);
    }

    // elegant solution using lambda
    static void moveTower(final int n, final Tower source, final Tower helper, final Tower destination, final Runnable action)
    {
        if (n == 1)
        {
            final Integer elementToMove = source.pop();
            destination.push(elementToMove);

            System.out.println("Moving slice " + elementToMove + ": " + source + " -> " + destination);

            action.run();
        }
        if (n >= 2)
        {
            moveTower(n - 1, source, destination, helper, action);
            moveTower(1, source, helper, destination, action);
            moveTower(n - 1, helper, source, destination, action);
        }
    }

    static void move(final Tower from, final Tower to, final Runnable action)
    {
        final Integer elementToMove = from.pop();

        System.out.println("Moving slice "  + elementToMove + ": " + from + " -> " + to);

        to.push(elementToMove);

        action.run();
    }

    private static void printTowers(final int maxHeight, final Tower source, final Tower helper, final Tower destination)
    {
        final List<String> tower1 = source.printTower(maxHeight);
        final List<String> tower2 = helper.printTower(maxHeight);
        final List<String> tower3 = destination.printTower(maxHeight);

        for (int i = 0; i < tower1.size(); i++)
        {
            final String line = tower1.get(i) + "   " + tower2.get(i) + "   " + tower3.get(i);
            System.out.println(line);
        }
    }
}
