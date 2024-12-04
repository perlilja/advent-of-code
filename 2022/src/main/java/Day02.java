import java.io.IOException;

public class Day02 {
    final static String ROCK = "A";
    final static String PAPER = "B";
    final static String SCISSORS = "C";



    public static void main(String... args) throws IOException {
        int sum = DataFileReader.asStringList(Day02.class.getResource("").getPath() + "/day02.txt")
                .stream()
                .mapToInt(round -> {
                    int opponent = round.substring(0,1).charAt(0) - 'A';
                    int outcome = round.substring(2,3).charAt(0) - 'X';

                   if (outcome == 0) {
                        outcome = (opponent - 1) % 3;
                        if (outcome < 0)
                            outcome = 2;

                        return outcome + 1;
                   } else if(outcome == 1) {
                        return 3 + opponent + 1;
                   } else {
                       return 6 + ((opponent + 1) % 3 ) + 1;
                   }


                }).sum();

        System.out.println(sum);


    }
}
