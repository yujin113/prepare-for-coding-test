package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] total = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = dp(arr, total, N);
        System.out.println(result);
    }

    private static int dp(int[] arr, int[] total, int N) {

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                total[i] = Math.max(total[i - j] + arr[j], total[i]);
            }
        }

        return total[N];
    }
}
