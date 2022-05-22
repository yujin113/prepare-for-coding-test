package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_3079 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //심사대수
        int M = Integer.parseInt(st.nextToken()); //인원수
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(bs(0, (long) arr[N - 1] * M, M));
    }

    private static long bs(long left, long right, int M) {
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i : arr) {
                if (i <= mid) {
                    sum += (mid / i);
                }
            }

            if (sum >= M)
                right = mid - 1;
            else
                left = mid + 1;
        }

        return left;
    }
}
