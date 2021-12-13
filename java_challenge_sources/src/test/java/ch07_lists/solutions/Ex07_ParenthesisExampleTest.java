package ch07_lists.solutions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import ch07_lists.solutions.Ex07_ParenthesisExample.CheckResult;
import ch07_lists.solutions.Ex07_ParenthesisExample.CheckResultV2;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex07_ParenthesisExampleTest
{
    @ParameterizedTest(name = "checkParentheses(''{0}'') should be valid")
    @CsvSource({ "()", "()[]{}", "[((()[]{}))]" })
    public void checkParentheses_ValidInput_Success(String input)
    {
        boolean result = Ex07_ParenthesisExample.checkParentheses(input);

        assertTrue(result);
    }

    @ParameterizedTest(name = "checkParentheses(''{0}'') should be invalid")
    @CsvSource({ "(()", "((})", "(()}", ")()(", "()((", "()A(" })
    public void checkParentheses_InvalidInputs_Should_Fail(String input)
    {
        boolean result = Ex07_ParenthesisExample.checkParentheses(input);

        assertFalse(result);
    }

    @ParameterizedTest(name = "checkParenthesesV2(''{0}'') should be valid")
    @CsvSource({ "()", "()[]{}", "[((()[]{}))]" })
    void checkParenthesesV2_ValidInput_Success(String input)
    {
        CheckResult result = Ex07_ParenthesisExample.checkParenthesesV2(input);

        assertEquals(CheckResult.OK, result);
    }

    @ParameterizedTest(name = "checkParenthesesSpecial(''{0}'') should be valid")
    @CsvSource({ "()", "()[]{}", "[((()[]{}))]" })
    void checkParenthesesSpecial_ValidInput_Success(String input)
    {
        CheckResultV2 result = Ex07_ParenthesisExample.checkParenthesesSpecial(input);

        assertEquals(CheckResultV2.OK, result);
    }

    @ParameterizedTest(name = "checkParenthesesV2(''{0}'') should be invalid")
    @MethodSource("listInputsAndExpected")
    void checkParenthesesV2_ValidInputs_Should_Fail(String input, CheckResult expected)
    {
        CheckResult result = Ex07_ParenthesisExample.checkParenthesesV2(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpected()
    {
        return Stream.of(Arguments.of("(()", CheckResult.ODD_LENGTH), Arguments.of("((})", CheckResult.MISMATCHING),
                         Arguments.of("(()}", CheckResult.MISMATCHING),
                         Arguments.of(")()(", CheckResult.CLOSING_BEFORE_OPENING),
                         Arguments.of("()((", CheckResult.REMAINING_OPENING),
                         Arguments.of("()A(", CheckResult.INVALID_CHAR));
    }

    @ParameterizedTest(name = "checkParenthesesSpecial(''{0}'') should be invalid")
    @MethodSource("listInputsAndExpectedV2")
    void checkParenthesesSpecial_ValidInputs_Should_Fail(String input, CheckResultV2 expected)
    {
        CheckResultV2 result = Ex07_ParenthesisExample.checkParenthesesSpecial(input);

        assertEquals(expected, result);
    }

    static Stream<Arguments> listInputsAndExpectedV2()
    {
        return Stream.of(Arguments.of("(()", CheckResultV2.ODD_LENGTH), Arguments.of("((})", CheckResultV2.MISMATCHING),
                         Arguments.of("(()}", CheckResultV2.MISMATCHING),
                         Arguments.of(")()(", CheckResultV2.CLOSING_BEFORE_OPENING),
                         Arguments.of("()((", CheckResultV2.REMAINING_OPENING),
                         Arguments.of("()A(", CheckResultV2.INVALID_CHAR));
    }
}
