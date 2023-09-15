package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_3151 {
    static int[] arr;
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) break;
            bs(i + 1, N - 1, arr[i]);
        }
        System.out.println(result);
    }

    private static void bs(int left, int right, int standard) {
        while (left < right) {
            int sum = arr[left] + arr[right] + standard;

            if (sum == 0) {
                int leftCount = 1;
                int rightCount = 1;

                if (arr[left] == arr[right]) {
                    int num = right - left + 1;
                    result += ((num * (num - 1)) / 2);
                    break;
                }

                while (arr[left] == arr[left + 1]) {
                    leftCount++;
                    left++;
                }
                while (arr[right] == arr[right - 1]) {
                    rightCount++;
                    right--;
                }

                result += (leftCount * rightCount);
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
}
