package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dac_2630 {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void search(int row, int col, int N) {
        int temp = arr[row][col];
//        System.out.println(row + " " + col + " = " + temp);

        if (N > 1) {
            for (int i = row; i < row + N; i++) {
                for (int j = col; j < col + N; j++) {
                    if (arr[i][j] != temp) {
                        search(row, col, N / 2);
                        search(row, col + N / 2, N / 2);
                        search(row + N / 2, col, N / 2);
                        search(row + N / 2, col + N / 2, N / 2);
                        return;
                    }
                }
            }
        }

        if (temp == 0)
            white++;
        if (temp == 1)
            blue++;
    }

}
