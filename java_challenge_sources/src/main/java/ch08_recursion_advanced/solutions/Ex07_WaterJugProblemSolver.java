package ch08_recursion_advanced.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_WaterJugProblemSolver
{
    private Ex07_WaterJugProblemSolver()
    {

    }

    public static void main(final String[] args)
    {
        System.out.println(solveWaterJugs(4, 3, 2));
        System.out.println(solveWaterJugs(5, 2, 4));

        System.out.println(solveWaterJugs(4, 4, 2));
    }

    static boolean solveWaterJugs(final int size1, final int size2,
                                  final int desiredLiters)
    {
        return solveWaterJugsRec(size1, size2, desiredLiters, 0, 0,
                                 new HashMap<>());
    }

    static boolean solveWaterJugsRec(final int size1, final int size2,
                                     final int desiredLiters,
                                     final int currentJug1, final int currentJug2,
                                     final Map<IntIntKey, Boolean> alreadyTried)
    {
        if (isSolved(currentJug1, currentJug2, desiredLiters))
        {
            System.out.println("Solved Jug 1: " + currentJug1 +
                               " / Jug 2: " + currentJug2);;
                               return true;
        }

        final IntIntKey key = new IntIntKey(currentJug1, currentJug2);
        if (!alreadyTried.containsKey(key))
        {
            alreadyTried.put(key, true);

            // Try all 6 variants
            System.out.println("Jug 1: " + currentJug1 + " / Jug 2: " + currentJug2);

            final int min2_1 = Math.min(currentJug2, size1 - currentJug1);
            final int min_1_2 = Math.min(currentJug1, size2 - currentJug2);
            final boolean result = solveWaterJugsRec(size1, size2, desiredLiters,
                                                     0, currentJug2, alreadyTried) ||
                            solveWaterJugsRec(size1, size2, desiredLiters,
                                              currentJug1, 0, alreadyTried) ||
                            solveWaterJugsRec(size1, size2, desiredLiters,
                                              size1, currentJug2, alreadyTried) ||
                            solveWaterJugsRec(size1, size2, desiredLiters,
                                              currentJug1, size2, alreadyTried) ||
                            solveWaterJugsRec(size1, size2, desiredLiters,
                                              currentJug1 + min2_1,
                                              currentJug2 - min2_1,
                                              alreadyTried) ||
                            solveWaterJugsRec(size1, size2, desiredLiters,
                                              currentJug1 - min_1_2,
                                              currentJug2 + min_1_2,
                                              alreadyTried);

            // Memoization:
            alreadyTried.put(key, result);

            return result;
        }

        return false;
    }


    static boolean isSolved(final int currentJug1, final int currentJug2, final int desiredLiters)
    {
        return currentJug1 == desiredLiters && currentJug2 == 0 || currentJug2 == desiredLiters && currentJug1 == 0;
    }

    // --------------------------------

    // As developed in exercise 12 in the chapter on data structures (lists)
    static class IntIntKey
    {
        int value1;

        int value2;

        public IntIntKey(final int value1, final int value2)
        {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(value1, value2);
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
            final IntIntKey other = (IntIntKey) obj;

            return value1 == other.value1 && value2 == other.value2;
        }
    }
}
