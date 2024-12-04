import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Day01 {

    public static void main(String... args) throws IOException {
        ArrayList<Integer> elfs = new ArrayList(10);
        elfs.add(0,0);
        AtomicInteger currentElf = new AtomicInteger(0);
        DataFileReader.asStringList(Day01.class.getResource("").getPath() + "/day01.txt")
                        .forEach(calories -> {
                            if(calories.isBlank()) {
                                currentElf.getAndIncrement();
                                elfs.add(currentElf.get(), 0);
                            } else {
                                elfs.add(currentElf.get(), elfs.get(currentElf.get()) + Integer.valueOf(calories));
                            }

                        });
        elfs.stream().max((o1, o2) -> o1.compareTo(o2)).get();


        int sum = elfs.stream().sorted((o1, o2) -> o2.compareTo(o1)).limit(3).mapToInt(i -> i).sum();
        System.out.println(sum);
    }
}