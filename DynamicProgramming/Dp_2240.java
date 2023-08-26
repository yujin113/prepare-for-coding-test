package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1]; // 시간, 이동 횟수
        int result = 0;

        for (int i = 1; i <= T; i++) {
            int tree = Integer.parseInt(br.readLine());

            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    // 현위치 : 나무 1 밑
                    if (tree == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else if (j % 2 == 0) {
                    // 현위치 : 나무 1 밑
                    if (tree == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                } else if (j % 2 != 0) {
                    // 현위치 : 나무 2 밑
                    if (tree == 2) {
                        dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }

                result = Math.max(result, dp[i][j]);
            }

        }

        System.out.println(result);
    }
}
