package day1;

import utils.DataFileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int partOne(List<Integer> sonarData) {
        final int[] previous = {-1};

        return  sonarData.stream().reduce(0, (sum,i) -> {
            if (i > previous[0] && previous[0] != -1 ) {
                sum++;
            }
            previous[0] = i;
            return sum;
        });
    }

    public static int partTwo(List<Integer> sonarData) {
        List<Integer> windowed = new ArrayList<>();
        final int[] index = {0};


        int windowPos = 0;
        for (int i = 0; i < sonarData.size() - 2; i++) {
            windowed.add(i, sonarData.get(i) + sonarData.get(i+1) + sonarData.get(i+2));
        }

        return partOne(windowed);

    }


    public static void main(String[] args) throws IOException {
        List<Integer> testData = DataFileReader.asIntegerList("C:\\Users\\plilja\\Code\\work\\advent-of-code\\src\\main\\resources\\day1\\day1.txt");

        System.out.println("The sum is " + Solution.partOne(testData));
        System.out.println("The sum is " + Solution.partTwo(testData));
    }
}
