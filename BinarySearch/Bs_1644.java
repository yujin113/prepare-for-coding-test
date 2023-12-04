package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bs_1644 {
    static boolean[] decimal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        isDecimal(N);

        System.out.println(bs(N));
    }

    private static int bs(int N) {
        int left = 2;
        int right = 2;
        int sum = left;
        int count = 0;

        while (left <= right && right <= N) {
            if (sum == N) {
                count++;
                sum -= left;
                do {
                    left++;
                } while (left <= right && !decimal[left]);
            } else if (sum < N) {
                do {
                    right++;
                } while (right <= N && !decimal[right]);
                sum += right;
            } else {
                sum -= left;
                do {
                    left++;
                } while (left <= right && !decimal[left]);
            }
        }

        return count;
    }

    private static void isDecimal(int N) {
        decimal = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            decimal[i] = true;
        }
        decimal[0] = decimal[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (decimal[i]) {
                for (int j = i + i; j <= N; j += i) {
                    decimal[j] = false;
                }
            }
        }
    }
}
