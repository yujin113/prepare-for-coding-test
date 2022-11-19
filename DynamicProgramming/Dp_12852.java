package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_12852 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp(N);
    }

    static void dp(int N) {
        int[] dp = new int[N + 1];
        int[] str = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;
            str[i] = i - 1;
            if (i % 3 == 0) {
                if (dp[i] > dp[i / 3]) {
                    dp[i] = dp[i / 3] + 1;
                    str[i] = i / 3;
                }
            }
            if (i % 2 == 0) {
                if (dp[i] > dp[i / 2]) {
                    dp[i] = dp[i / 2] + 1;
                    str[i] = i / 2;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int temp = N;
        while (temp >= 1) {
            sb.append(temp).append(" ");
            temp = str[temp];
        }

        System.out.println(dp[N]);
        System.out.println(sb);
    }
}
