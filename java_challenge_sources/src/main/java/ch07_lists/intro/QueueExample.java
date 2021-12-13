package ch07_lists.intro;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class QueueExample
{
    private QueueExample()
    {
    }

    public static void main(final String[] args)
    {
        final Queue<String> waitingPersons = new LinkedList<>();

        waitingPersons.offer("Marcello");
        waitingPersons.offer("Michael");
        waitingPersons.offer("Karthi");

        while (!waitingPersons.isEmpty())
        {
            if (waitingPersons.peek().equals("Michael"))
            {
                // Finally, "queue again" and process
                waitingPersons.offer("Michael again");
                waitingPersons.offer("Last Man");
            }
            final String nextPerson = waitingPersons.poll();
            System.out.println("Processing " + nextPerson);
        }
    }
}
