package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_2579 {
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        result[1] = arr[1];
        if (N >= 2) {
            result[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= N; i++) {
            result[i] = Math.max(result[i - 2], result[i - 3] + arr[i - 1]) + arr[i];
        }

        System.out.println(result[N]);
    }

}
