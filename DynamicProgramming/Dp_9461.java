package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_9461 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        int[] testcase = new int[T];
        int max = 0;

        for (int i = 0; i < T; i++) {
            testcase[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, testcase[i]);
        }

        dp(max);

        for (int i : testcase) {
            System.out.println(arr[i]);
        }
    }

    private static void dp(int N) {
        if (N > 3) {
            for (int i = 4; i <= N; i++) {
                arr[i] = arr[i - 2] + arr[i - 3];
            }
        }
    }
}
