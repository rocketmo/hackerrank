import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BeautifulTriplets {

    // Returns the number of beautiful triplets in arr, given the value d
    static int beautifulTriplets(int d, int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i += 1) {
            // Look for integers to complete sequence using binary search
            if (Arrays.binarySearch(arr, arr[i] + d) >= 0 && Arrays.binarySearch(arr, arr[i] + (2 * d)) >= 0) {
                count += 1;
            }
        }

        return count;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
