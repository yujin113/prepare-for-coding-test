package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_10942 {
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(line[i - 1]);
        }

        dp(N);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            sb.append(dp[s][e]).append("\n");
        }

        System.out.println(sb);
    }

    static void dp(int N) {
        for (int i = 1; i <= N; i++) {
            dp[i][i] = 1;
            if (arr[i] == arr[i - 1]) {
                dp[i - 1][i] = 1;
            }
        }

        for (int i = 2; i < N; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }
    }
}
