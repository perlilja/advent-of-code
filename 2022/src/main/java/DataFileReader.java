import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataFileReader {
    public static final List<Integer> asIntegerList(String filename) throws IOException {
        List<Integer> result = new ArrayList();

        try (Scanner s = new Scanner(new FileReader(filename))) {
            while (s.hasNext()) {
                result.add(Integer.valueOf(s.nextLine()));
            }
            return result;
        }
    }

    public static final List<String> asStringList(String filename) throws IOException {
        List<String> result = new ArrayList();

        try (Scanner s = new Scanner(new FileReader(filename))) {
            while (s.hasNext()) {
                result.add(s.nextLine());
            }
            return result;
        }
    }
}