import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class FairRations {

    /**
     * Determines the minimum number of loaves to distribute across subjects.
     * View problem for more details
     *
     * @param B Array of bread counts
     * @return Min number of loaves to distribute for solution, -1 if impossible
     */
    static int fairRations(int[] B) {
        int count = 0;

        for (int i = 0; i < B.length; i += 1) {
            if (B[i] % 2 == 1) {
                if (i == B.length - 1) {
                    return -1;
                } else {
                    count += 2;
                    B[i + 1] += 1;
                }
            }
        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];
        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        bufferedWriter.write((result < 0) ? "NO" : String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
