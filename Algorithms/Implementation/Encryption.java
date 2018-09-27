import java.lang.StringBuilder;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Encryption {

    /**
     * Encrypts the given string according to problem specification
     * @param s String to encrypt
     * @return Encrypted string
     */
    static String encryption(String s) {
        // get number of rows and columns for character grid
        double len = (double) s.length();
        double lenSqrt = Math.sqrt(len);
        int rows = (int) Math.floor(lenSqrt);
        int cols = (int) Math.ceil(lenSqrt);

        // check if rows * cols >= len, if not increase rows by 1
        if (rows * cols < s.length()) rows += 1;

        char[][] charGrid = new char[rows][cols];
        StringBuilder sb = new StringBuilder();

        // place characters into the grid
        for (int i = 0; i < rows; i += 1) {
            for (int j = 0; j < cols; j += 1) {
                if ((i * cols) + j >= s.length()) break;
                charGrid[i][j] = s.charAt((i * cols) + j);
            }
        }

        // create encrypted string
        for (int j = 0; j < cols; j += 1) {
            for (int i = 0; i < rows; i += 1) {
                if (!Character.isAlphabetic(charGrid[i][j])) break;
                sb.append(charGrid[i][j]);
            }
            sb.append(' ');
        }

        return sb.toString();
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();
        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
