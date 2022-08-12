package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1041 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[6];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            int sum = 0;
            Arrays.sort(arr);
            for (int i = 0; i < 5; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        } else {
            System.out.println(three() + two(N) + one(N));
        }
    }

    static long three() {
        long AorF = Math.min(arr[0], arr[5]);
        long BorE = Math.min(arr[1], arr[4]);
        long CorD = Math.min(arr[2], arr[3]);

        return 4 * (AorF + CorD + BorE);
    }

    static long two(int N) {
        long min = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j == 5) continue;
                min = Math.min(min, arr[i] + arr[j]);
            }
        }

        return min * (4 + 8L * (N - 2));
    }

    static long one(int N) {
        long min = arr[0];
        for (int i : arr) {
            min = Math.min(i, min);
        }

        return (5L * (N - 2) * (N - 2) + 4L * (N - 2)) * min;
    }
}
