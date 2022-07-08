package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dac_14600 {
    static int[][] arr;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = (int) Math.pow(2, K);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        arr[N - y][x - 1] = -1;

        num = 1;

        divide(N, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void divide(int N, int row, int col) {
        if (N == 2) {
            boolean hole = false;
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    if (arr[i][j] == 0) {
                        arr[i][j] = num;
                    }
                    if (arr[i][j] == -1) {
                        hole = true;
                    }
                }
            }
            if (hole) {
                for (int i = row; i < row + 2; i++) {
                    for (int j = col; j < col + 2; j++) {
                        if (arr[i][j] != -1) {
                            arr[i][j] = num;
                        }
                    }
                }
            }
            num++;
            return;
        }
        divide(N / 2, row + N / 4, col + N / 4);
        divide(N / 2, row, col);
        divide(N / 2, row, col + N / 2);
        divide(N / 2, row + N / 2, col);
        divide(N / 2, row + N / 2, col + N / 2);
    }
}
