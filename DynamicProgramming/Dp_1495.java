package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int S = Integer.parseInt(str[1]);
        int M = Integer.parseInt(str[2]);

        int[] V = new int[N + 1];
        str = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(str[i - 1]);
        }

        boolean[][] dp = new boolean[N + 1][M + 1];

        dp[0][S] = true;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (!dp[i - 1][j]) continue;
                if (j + V[i] <= M) {
                    dp[i][j + V[i]] = true;
                }
                if (j - V[i] >= 0) {
                    dp[i][j - V[i]] = true;
                }
            }
        }

//        for (int i = 0; i <= N; i++) {
//            for (int j = 0; j <= M; j++) {
//                if (dp[i][j]) {
//                    System.out.print(j + " ");
//                }
//            }
//            System.out.println();
//        }

        boolean res = false;
        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                res = true;
                System.out.println(i);
                break;
            }
        }
        if (!res) {
            System.out.println("-1");
        }
    }
}
