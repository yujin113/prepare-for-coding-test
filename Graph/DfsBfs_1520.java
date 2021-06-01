package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsBfs_1520 {
    static int[][] arr;
    static int[][] dp;
    static int m, n;
    static int[] moveX = {0, 1, 0, - 1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int row, int col) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (dp[row][col] != -1)
            return dp[row][col];

        dp[row][col] = 0;
        for (int i = 0; i < 4; i++) {
            int r = row + moveX[i];
            int c = col + moveY[i];
            if (r >= 0 && c >= 0 && r < m && c < n) {
                if (arr[row][col] > arr[r][c]) {
                    dp[row][col] += dfs(r, c);
                }
            }
        }

        return dp[row][col];
    }
}
