package dsa.rkr.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * Print permutations of all characters of the given string
 * Permutation formula: nPr = n!/(n-r)!
 */
public class Permutations {

    public static void main(String[] args) {
        String input = "abc";
        char[] chars = input.toCharArray();
        List<String> characters = new ArrayList<>(input.length());
        for(char mychar : chars) {
            characters.add(String.valueOf(mychar));
        }
        List<String> permutations = permutations(characters);
        for(String str : permutations) {
            System.out.println(str);
        }
    }

    public static List<String> permutations(List<String> characters) {
        List<String> permutations = new ArrayList<>();
        if(characters.size() == 1) {
            permutations.add(characters.get(0));
            return permutations;
        }
        for(String str : characters) {
            List<String> subCharacters = new ArrayList<>();
            subCharacters.addAll(characters);
            subCharacters.remove(str);
            List<String> subPermutations = permutations(subCharacters);
            for(String subStr : subPermutations) {
                permutations.add(str + subStr);
            }
        }
        return permutations;
    }

}
