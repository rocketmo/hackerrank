import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LisaWorkbook {

    /**
     * Determines the number of special problems in Lisa's workbook
     * View problem for more details
     *
     * @param n Number of chapters in the workbook
     * @param k Maximum number of problems per page
     * @param arr Array of integers containing number of problems per chapter
     * @return Number of special problems in the workbook
     */
    static int workbook(int n, int k, int[] arr) {
        int currentChapter = 0;
        int currentPage = 1;
        int minProblem = 1; // number of first problem on current page
        int maxProblem = 1; // number of last problem on current page
        int numSpecial = 0; // special problem counter
        
        while (currentChapter < n) {
            maxProblem = Math.min(arr[currentChapter], minProblem + k - 1);
            numSpecial += (currentPage >= minProblem && currentPage <= maxProblem) ? 1 : 0;
            
            if (maxProblem == arr[currentChapter]) {
                currentChapter += 1;
                minProblem = 1;
            } else {
                minProblem = maxProblem + 1;
            }
            
            currentPage += 1;
        }

        return numSpecial;
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

        int result = workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
