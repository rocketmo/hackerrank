import java.util.HashSet;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Pangrams {

    /**
     * Determines if the given string is a pangram, a string that contains all
     * letters of the alphabet
     * @param s String to check
     * @return "pagram" if s is a pangram, "not pangram" otherwise
     */
    static String pangrams(String s) {
        // ignore case
        String sc = s.toLowerCase();

        // add all characters in s into a set
        HashSet<Character> h = new HashSet<Character>();
        for (int i = 0; i < sc.length(); i += 1) {
            h.add(sc.charAt(i));
        }

        // check if all alphabetical characters are inside the set
        for (char c = 'a'; c <= 'z'; c += 1) {
            if (!h.contains(c)) return "not pangram";
        }

        return "pangram";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();
        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
