package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 0;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
        }

        System.out.println(arr[N]);
    }

    /*private static int calc(int n) {
        if (n == 1) {
            return 0;
        }
        if (arr[n] > 0) {
            return arr[n];
        }

        arr[n] = calc(n - 1) + 1;
        if (n % 3 == 0) {
            arr[n] = Math.min(calc(n / 3) + 1, arr[n]);
        }
        if (n % 2 == 0) {
            arr[n] = Math.min(calc(n / 2) + 1, arr[n]);
        }
        return arr[n];
    }*/
}
