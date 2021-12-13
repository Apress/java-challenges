package ch08_recursion_advanced.solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex06_MathOperationChecker
{
    private static final ScriptEngineManager manager  = new ScriptEngineManager();

    private static final ScriptEngine        jsEngine = manager.getEngineByName("js");

    private Ex06_MathOperationChecker()
    {
    }

    static Set<String> allCombinationsWithValue(final List<Integer> baseValues, final int desiredValue)
    {
        final Map<String, Long> allCombinations = allCombinations(baseValues);

        return findByValue(allCombinations, desiredValue);
    }

    static Set<String> findByValue(final Map<String, Long> results, final int desiredValue)
    {
        return results.entrySet().stream().filter(entry -> entry.getValue() == desiredValue)
                        .map(entry -> entry.getKey()).collect(Collectors.toSet());
    }

    static Set<String> allCombinationsWithValueShort(final List<Integer> baseValues, final int desiredValue)
    {
        final Map<String, Long> allCombinations = allCombinations(baseValues);

        allCombinations.entrySet().removeIf(entry -> entry.getValue() != desiredValue);

        return allCombinations.keySet();
    }

    static Map<String, Long> allCombinations(final List<Integer> numbers)
    {
        return allCombinations(numbers, 0);
    }

    static Map<String, Long> allCombinations(final List<Integer> digits, final int pos)
    {
        // recursive termination
        if (pos >= digits.size() - 1)
        {
            final long lastDigit = digits.get(digits.size() - 1);
            return Map.of("" + lastDigit, lastDigit);
        }

        // recursive descent
        final Map<String, Long> results = allCombinations(digits, pos + 1);

        // check combinations
        final Map<String, Long> solutions = new HashMap<>();
        results.forEach((key, value) -> {
            final int currentDigit = digits.get(pos);

            solutions.put(currentDigit + "+" + key, evaluate("" + currentDigit + "+" + key));
            solutions.put(currentDigit + "-" + key, evaluate("" + currentDigit + "-" + key));
            solutions.put(currentDigit + key, evaluate("" + currentDigit + key));
        });

        return solutions;
    }

    static long evaluateJS(final String expression)
    {
        try
        {
            return (long) jsEngine.eval(expression);
        }
        catch (final ScriptException e)
        {
            throw new RuntimeException("unprocessable expression " + expression);
        }
    }

    static long evaluate(final String expression)
    {
        final String[] values = expression.split("\\+|-");

        // Use numbers as separators
        final String[] tmpoperators = expression.split("\\d+");

        // Filter out empty elements, limit to the real operators
        final String[] operators = Arrays.stream(tmpoperators).filter(str -> !str.isEmpty()).toArray(String[]::new);

        long result = Long.parseLong(values[0]);
        for (int i = 1; i < values.length; i++)
        {
            final String nextOp = operators[i - 1];
            final long nextValue = Long.parseLong(values[i]);

            if (nextOp.equals("+"))
                result = result + nextValue;
            else if (nextOp.equals("-"))
                result = result - nextValue;
            else
                throw new IllegalStateException("unsupported operator " + nextOp);
        }
        return result;
    }

    private static Map<String, Long> allCombinationsWithStreams(final List<Integer> digits)
    {
        return allExpressions(digits)
                        .collect(Collectors.toMap(Function.identity(), Ex06_MathOperationChecker::evaluate));
    }

    private static Stream<String> allExpressions(final List<Integer> digits)
    {
        if (digits.size() == 1)
        {
            return Stream.of("" + digits.get(0));
        }

        final long first = digits.get(0);
        final List<Integer> remainingDigits = digits.subList(1, digits.size());

        final var resultCombine = allExpressions(remainingDigits).map(expr -> first + expr);
        final var resultAdd = allExpressions(remainingDigits).map(expr -> first + "+" + expr);
        final var resultMinus = allExpressions(remainingDigits).map(expr -> first + "-" + expr);

        return Stream.concat(resultCombine, Stream.concat(resultAdd, resultMinus));
    }

    public static void main(String... args)
    {
        System.out.println(allCombinations(List.of(1, 2, 3)));
        System.out.println(allCombinationsWithValue(List.of(1, 2, 3), 100));
    }
}
