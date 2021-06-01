package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class recursion_1780 {

    static int[][] arr;
    static int[] count = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0, n);
        for (int i = 0; i < 3; i++)
            System.out.println(count[i]);
    }

    public static void func(int row, int col, int n) {
        int temp = arr[row][col];
        int cnt = 0;
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (arr[i][j] != temp)
                    break;
                else cnt++;
            }
        }
        if (cnt == n * n) {
            count[++temp]++;
            return;
        }

        if (n / 3 >= 1) {
            int n2 = n / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    func(row + n2 * i, col + n2 * j, n2);
                }
            }
        }
    }
}
