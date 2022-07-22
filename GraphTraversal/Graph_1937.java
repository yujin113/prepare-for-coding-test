package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_1937 {
    static int[] moveR = {0, 1, 0, -1};
    static int[] moveC = {-1, 0, 1, 0};
    static int[][] arr, dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }
        System.out.println(result);
    }

    static int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        dp[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int moveRow = row + moveR[i];
            int moveCol = col + moveC[i];

            if (moveRow >= 0 && moveCol >= 0 && moveRow < n && moveCol < n) {
                if (arr[moveRow][moveCol] > arr[row][col]) {
                    dp[row][col] = Math.max(dfs(moveRow, moveCol) + 1, dp[row][col]);
                }
            }
        }

        return dp[row][col];
    }
}
