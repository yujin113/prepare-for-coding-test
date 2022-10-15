package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        long[] dp = new long[len + 1];

        if (num.charAt(0) == '0') {
            System.out.println("0");
            return;
        }
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int pre = num.charAt(i - 2) - '0';
            int now = num.charAt(i - 1) - '0';
            if (now == 0) {
                if (pre == 1 || pre == 2) {
                    dp[i] = dp[i - 2];
                } else {
                    break;
                }
            } else {
                if (pre == 1) {
                    dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                } else if (pre == 2) {
                    if (now <= 6) {
                        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000;
                    } else {
                        dp[i] = dp[i - 1];
                    }
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        System.out.println(dp[len]);
    }
}
