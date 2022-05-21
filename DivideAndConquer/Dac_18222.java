package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dac_18222 {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        arr = new long[64];
        arr[0] = 1;
        for (int i = 1; i < 64; i++) {
            arr[i] = arr[i - 1] * 2;
        }

        System.out.println(dac(k));
    }

    private static long dac(long n) {
        if (n == 1) return 0;

        for (int i = 0; i < 64; i++) {
            if (n <= arr[i]) {
                return 1 - dac(n - arr[i - 1]);
            }
        }

        return 0;
    }
}
