package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_2805 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long left = 0;
        long right = arr[N - 1];

        long result = binarySearch(left, right, M);
        System.out.println(result);
    }

    public static long binarySearch(long left, long right, int M) {
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i : arr) {
                if (i <= mid) continue;
                sum += (i - mid);
            }

            if (sum >= M)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
