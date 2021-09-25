package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_1654 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long result = binarySearch(1, arr[K - 1], N);
        System.out.println(result);
    }

    private static long binarySearch(long left, long right, int N) {
        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for (int i : arr) {
                sum += (i / mid);
            }

            if (sum < N)
                right = mid - 1;
            if (sum >= N)
                left = mid + 1;
        }
        return right;
    }
}
