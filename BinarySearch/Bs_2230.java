package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bs_2230 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = bs(0, 0, N, M);
        System.out.println(result);
    }

    static int bs(int left, int right, int N, int M) {
        int min = Integer.MAX_VALUE;

        while (right < N && left <= right) {
            int diff = arr[right] - arr[left];

            if (diff < M) {
                right++;
            }
            if (diff >= M) {
                min = Math.min(min, diff);
                left++;
            }
        }

        return min;
    }
}
