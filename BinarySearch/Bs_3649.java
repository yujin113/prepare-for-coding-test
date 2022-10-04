package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bs_3649 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null || line.equals("")) break;
            int x = Integer.parseInt(line);
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            bs(arr, x * 10000000, n);
        }
        System.out.println(sb);
    }

    static void bs(int[] arr, int x, int n) {
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == x) {
                sb.append("yes ").append(arr[left]).append(" ").append(arr[right]).append("\n");
                return;
            }

            if (sum < x) {
                left++;
            } else {
                right--;
            }
        }
        sb.append("danger").append("\n");
    }
}
