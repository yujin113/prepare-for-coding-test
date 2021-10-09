package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_2343 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int min = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            min = Math.max(min, arr[i]);
        }

        int result = bs(min, sum, M);
        System.out.println(result);
    }

    private static int bs(int left, int right, int M) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;

            for (int i : arr) {
                if (sum + i > mid) {
                    count++;
                    sum = 0;
                }
                sum += i;
            }
            if (sum > 0) count++;

            if (count <= M)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
