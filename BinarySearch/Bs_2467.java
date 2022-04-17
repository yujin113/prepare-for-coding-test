package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_2467 {
    static long[] arr;
    static long min = Integer.MAX_VALUE;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        if (arr[0] > 0) {
            System.out.println(arr[0] + " " + arr[1]);
        } else if (arr[N - 1] < 0) {
            System.out.println(arr[N - 2] + " " + arr[N - 1]);
        } else {
            bs(0, N - 1);
            System.out.println(sb);
        }
    }

    private static void bs(int left, int right) {
        while (left < right) {
            long num = arr[left] + arr[right];
            if (Math.abs(num) < Math.abs(min)) {
                min = num;
                sb.setLength(0);
                sb.append(arr[left]).append(" ").append(arr[right]);
            }

            if (num > 0) {
                right -= 1;
            } else {
                left += 1;
            }
        }
    }
}
