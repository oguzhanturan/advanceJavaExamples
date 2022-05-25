package examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static final String[] FORBIDDEN = new String[]{"Shit"};

    public static void main(String[] args) {

        String test = "aabcdefg";
        List<Integer> intList = List.of(1,2,3,4,5,6,7,3,2,4);

        //Reverse String
        reverseString(test);
        //convert char array string
        convertCharArrayToList(test);
        //count duplicate char
        duplicateCharCount(test);
        //count duplicate int
        duplicateIntCount(intList);
        //check string contain list
        checkForbiddenWords("shit");
    }

    private static void reverseString(String test) {
        StringBuilder builder = new StringBuilder(test).reverse();
        System.out.println(builder);
    }

    private static void convertCharArrayToList(String test) {
        List<Character> characters = test.chars().mapToObj(c -> (char)c).collect(Collectors.toList());
        System.out.println(characters);
    }

    private static void duplicateCharCount(String test) {
        Map<Character, Long> countMap = test.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);
    }

    private static void duplicateIntCount(List<Integer> intList) {
        Map<Integer, Long> collect = intList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Long> collect1 = collect.values().stream().filter(c -> c > 1).collect(Collectors.toList());
        //Tekrar eden ilk elemanı almak isteseydik listenin 0. indisini alabilirdir.
        System.out.println(collect1.size());
    }

    private static void checkForbiddenWords(String word) {
        final boolean b = Arrays.stream(FORBIDDEN).anyMatch(fw -> fw.toUpperCase().contains(word.toUpperCase()));
        if(b) {
            System.out.println("forbidden word");
        }
    }
}
