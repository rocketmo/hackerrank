import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class HackerrankInString {

    /**
     * Determines if "hackerrank" is a subsequence in the given string
     * @param s String to check
     * @return "YES" if hackerrank is a subsequence, "NO" otherwise
     */
    static String hackerrankInString(String s) {
        String h = "hackerrank";
        int hi = 0;

        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == h.charAt(hi)) {
                hi += 1;
                if (hi >= h.length()) return "YES";
            }
        }

        return "NO";
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
