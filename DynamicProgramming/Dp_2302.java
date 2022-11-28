package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 1;
        int temp = 0;
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            result *= dp[num - temp - 1];
            temp = num;
        }
        result *= dp[N - temp];

        System.out.println(result);
    }
}
