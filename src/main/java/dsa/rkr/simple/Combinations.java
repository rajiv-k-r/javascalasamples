package dsa.rkr.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Print combinations of n characters, r at a time
 * Combination formula: nCr = n!/(n-r)!r!
 */
public class Combinations {

    public static void main(String[] args) {
        String input = "abcde";
        char[] chars = input.toCharArray();
        List<String> characters = new ArrayList<>(input.length());
        for(char mychar : chars) {
            characters.add(String.valueOf(mychar));
        }
        List<String> combinations = combinations(characters, 5, 3);
        for(String str : combinations) {
            System.out.println(str);
        }
    }

    public static List<String> combinations(List<String> characters, int m, int n) {
        List<String> combinations = new ArrayList<>();
        if(m == n) {
            String result = "";
            for(String str : characters) {
                result = result + str;
            }
            combinations.add(result);
            return combinations;
        }
        if(m < n) {
            return combinations;
        }
        if(n == 1) {
            combinations.addAll(characters);
            return combinations;
        }
        List<String> subCharacters = new ArrayList<>();
        subCharacters.addAll(characters);
        for(String str : characters) {
            m = m-1;
            subCharacters.remove(str);
            List<String> subCombinations = combinations(subCharacters, m, n-1);
            for(String subStr : subCombinations) {
                combinations.add(str + subStr);
            }
        }
        return combinations;
    }

}
