package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[501];

        StringTokenizer st;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            max = Math.max(max, n);
            arr[n] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[n]);
        }

        int[] dp = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            if (arr[i] == 0) continue;
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (dp[j] == 0) continue;
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int lis = 0;
        for (int i = 1; i <= max; i++) {
            lis = Math.max(lis, dp[i]);
        }
        System.out.println(N - lis);
    }
}
