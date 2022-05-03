package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dac_17829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dac(arr, N, 0, 0));
    }

    private static int dac(int[][] arr, int N, int row, int col) {
        if (N == 2) {
            List<Integer> four = new ArrayList<>();
            for (int i = row; i < row + 2; i++) {
                for (int j = col; j < col + 2; j++) {
                    four.add(arr[i][j]);
                }
            }
            Collections.sort(four);
            return four.get(2);
        } else {
            int[] temp = new int[4];

            temp[0] = dac(arr, N / 2, row, col);
            temp[1] = dac(arr, N / 2, row, col + N / 2);
            temp[2] = dac(arr, N / 2, row + N / 2, col);
            temp[3] = dac(arr, N / 2, row + N / 2, col + N / 2);

            Arrays.sort(temp);
            return temp[2];
        }
    }
}
