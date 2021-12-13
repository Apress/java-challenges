package ch07_lists.solutions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example program for the book "Java Challenges"
 *
 * @author Michael Inden
 *
 *         Copyright 2021/22 by Michael Inden
 */
public class Ex12_CompoundKey
{
    private Ex12_CompoundKey()
    {
    }

    public static void main(final String[] args)
    {
        // Definition of the keys
        final StringIntKey key1 = new StringIntKey("Peter", 22);
        final StringIntKey key2 = new StringIntKey("Mike", 48);
        final StringIntKey key3 = new StringIntKey("Tom", 33);

        // Alternative definition
        final StringIntKey mike48 = StringIntKey.of("Mike", 48);
        final StringIntKey tom33 = StringIntKey.of("Tom", 33);
        final StringIntKey michael48 = StringIntKey.of("Michael", 48);

        // Usage in the map
        final Map<StringIntKey, List<String>> personToHobbies = new HashMap<>();
        personToHobbies.put(key1, List.of("TV"));
        personToHobbies.put(key2, List.of("Java", "Cycling", "Movies"));
        personToHobbies.put(michael48, List.of("Java", "Cycling"));
        personToHobbies.put(tom33, List.of("Running", "Movies"));

        // Access
        System.out.println(mike48 + " => " + personToHobbies.get(mike48));
        final StringIntKey newTom33 = StringIntKey.of("Tom", 33);
        System.out.println(newTom33 + " => " + personToHobbies.get(newTom33));
    }

    record StringIntKey(String strValue, int intValue)
    {
        public static StringIntKey of(final String strValue, final int intValue)
        {
            return new StringIntKey(strValue, intValue);
        }
    }

    record IniIntKey(int value1, int value2)
    {
    }
}
