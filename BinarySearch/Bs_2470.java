package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        bs(arr, 0, N - 1);
    }

    private static void bs(int[] arr, int left, int right) {
        int res1 = 0, res2 = 0;
        int max = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < max) {
                res1 = arr[left];
                res2 = arr[right];
                max = Math.abs(sum);
            }

            if (sum > 0)
                right -= 1;
            else
                left += 1;
        }
        System.out.println(res1 + " " + res2);
    }
}
