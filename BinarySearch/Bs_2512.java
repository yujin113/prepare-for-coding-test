package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_2512 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int result = bs(arr, 1, arr[N - 1]);
        System.out.println(result);
    }

    private static int bs(int[] arr, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i : arr) {
                if (i <= mid)
                    sum += i;
                else
                    sum += mid;
            }

            if (sum <= M)
                left = mid + 1;
            else
                right = mid - 1;

        }
        return right;
    }
}
