import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class CamelCase {

    /**
     * Finds the number of words in a camel case string
     * @param s String written in camel case
     * @return Number of words in s
     */
    static int camelcase(String s) {

        // If length of s is 0, there are no words
        if (s.length() == 0) {
            return 0;
        }

        // Count the number of upper case letters after the first character to find the number of words
        int words = 1;
        for (int i = 1; i < s.length(); i += 1) {
            if (Character.isUpperCase(s.charAt(i))) {
                words += 1;
            }
        }

        return words;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
