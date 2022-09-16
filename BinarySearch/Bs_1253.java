package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_1253 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (search(i)) {
                result += 1;
            }
        }
        System.out.println(result);
    }

    static boolean search(int i) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (left == i) left++;
            if (right == i) right--;

            if (left >= right) break;

            int sum = arr[left] + arr[right];
            if (sum == arr[i]) {
                return true;
            }

            if (sum > arr[i]) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
