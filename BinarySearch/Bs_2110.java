package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_2110 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int result = bs(1, arr[N - 1] - arr[0], C);
        System.out.println(result);
    }

    private static int bs(int left, int right, int C) {
        while (left <= right) {
            int count = 1;
            int mid = (left + right) / 2;
            int choice = arr[0];

            for (int i : arr) {
                if (i - choice >= mid) {
                    count++;
                    choice = i;
                }
            }

            if (count >= C)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right;
    }
}
