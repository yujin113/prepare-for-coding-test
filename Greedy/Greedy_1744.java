package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy_1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int res = 0;
        int left = 0, right = N - 1;
        while (left < right) {
            if (arr[left] < 1 && arr[left + 1] < 1) {
                res += arr[left] * arr[left + 1];
            } else {
                break;
            }

            left += 2;
        }

        while (right > 0) {
            if (arr[right] > 1 && arr[right - 1] > 1) {
                res += arr[right] * arr[right - 1];
            } else {
                break;
            }

            right -= 2;
        }

        while (left <= right) {
            res += arr[right];
            right -= 1;
        }

        System.out.println(res);
    }
}
