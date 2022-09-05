package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = arr[i][1];
            for (int j = 2; j <= N; j++) {
                dp[i][j] = dp[i][j - 1] + arr[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
            int sum = 0;
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j <= x2; j++) {
                sum += (dp[j][y2] - dp[j][y1 - 1]);
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
