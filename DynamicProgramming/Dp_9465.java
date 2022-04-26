package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_9465 {
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];
            sum = new int[2][n + 1];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append(dp(n)).append("\n");
        }

        System.out.println(sb);
    }

    private static int dp(int n) {
        sum[0][1] = arr[0][1];
        sum[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            sum[0][i] = Math.max(sum[1][i - 1], sum[1][i - 2]) + arr[0][i];
            sum[1][i] = Math.max(sum[0][i - 1], sum[0][i - 2]) + arr[1][i];
        }

        return Math.max(sum[0][n], sum[1][n]);
    }
}
