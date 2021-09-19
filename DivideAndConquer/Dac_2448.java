package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dac_2448 {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        arr = new String[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                arr[i][j] = " ";
            }
        }

        divide(0, 0, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int row, int col, int N) {
        if (N == 3) {
            arr[row][col + 2] = "*";
            arr[row + 1][col + 1] = "*";
            arr[row + 1][col + 3] = "*";
            for (int i = col; i < col + 5; i++) {
                arr[row + 2][i] = "*";
            }
        } else {
            divide(row, col + (N / 2), N / 2);
            divide(row + (N / 2), col, N / 2);
            divide(row + (N / 2), col + 2 * (N / 2), N / 2);
        }
    }
}
