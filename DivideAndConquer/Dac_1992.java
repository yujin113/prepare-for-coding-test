package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dac_1992 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        dac(arr, N, 0, 0);

        System.out.println(sb);

    }

    private static void dac(int[][] arr, int N, int row, int col) {
        if (N == 1) {
//            System.out.println(row + " , " + col);
            sb.append(arr[row][col]);
            return;
        }

        boolean same = true;
        for (int i = row; i < row + N; i++) {
            for (int j = col; j < col + N; j++) {
                if (arr[i][j] != arr[row][col]) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            sb.append(arr[row][col]);
            return;
        }
        if (!same) {
            sb.append("(");
            dac(arr, N / 2, row, col);
            dac(arr, N / 2, row, col + N / 2);
            dac(arr, N / 2, row + N / 2, col);
            dac(arr, N / 2, row + N / 2, col + N / 2);
            sb.append(")");
        }

    }
}
