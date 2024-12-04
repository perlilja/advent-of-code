import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Day03 {


    private static Set<Character> toSet(String s) {
        Set<Character> charSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

       return charSet;
    }

    private static int getPriority(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 1;
        } else {
            return c - 'A' + 27;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> bags = DataFileReader.asStringList(Day03.class.getResource("").getPath() + "/day03.txt");
        int sum = 0;

       for(String bag : bags){
            String[] halves = {bag.substring(0, bag.length()/2), bag.substring(bag.length()/2)};
            Set<Character> half1 = new HashSet<>();
            Set<Character> half2 = new HashSet<>();

            for(char c : halves[0].toCharArray()){
                half1.add(c);
            }
           for(char c : halves[1].toCharArray()){
               half2.add(c);
           }

           half1.retainAll(half2);

           sum += half1.stream().mapToInt(Day03::getPriority).sum();
        }

        sum = 0;

        for (int i = 0; i < bags.size(); i += 3) {
            Set<Character> first = toSet(bags.get(i));
            Set<Character> second = toSet(bags.get(i+1));
            Set<Character> third = toSet(bags.get(i+2));

            first.retainAll(second);
            first.retainAll(third);

            sum += getPriority(first.iterator().next());

        }


        System.out.println(sum);
    }
}