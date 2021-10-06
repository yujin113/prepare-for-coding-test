package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dac_2447 {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        divide(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == null) {
                    sb.append(" ");
                    continue;
                }
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void divide(int N, int row, int col) {
        if (N == 3) {
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (i == row + 1 && j == col + 1) {
                        arr[i][j] = " ";
                        continue;
                    }
                    arr[i][j] = "*";
                }
            }
        } else {
            int num = N / 3;
            divide(num, row, col);
            divide(num, row, col + num);
            divide(num, row, col + 2 * num);
            divide(num, row + num, col);
            divide(num, row + num, col + 2 * num);
            divide(num, row + 2 * num, col);
            divide(num, row + 2 * num, col + num);
            divide(num, row + 2 * num, col + 2 * num);
        }
    }
}
