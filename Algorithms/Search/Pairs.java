import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;

public class Pairs {

    /**
     * Determines the number of pairs in arr that have a difference of k
     *
     * @param k Difference between pairs
     * @param arr Array of integers
     * @return Number of pairs in arr that have a difference of k
     */
    static int pairs(int k, int[] arr) {
        HashSet<Integer> hash = new HashSet<Integer>();
        int count = 0;

        for (int i = 0; i < arr.length; i += 1) {
            hash.add(arr[i]);
        }

        for (int i = 0; i < arr.length; i += 1) {
            if (hash.contains(arr[i] - k)) {
                count += 1;
            }
        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
