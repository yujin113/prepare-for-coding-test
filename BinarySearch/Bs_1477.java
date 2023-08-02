package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_1477 {
    static int[] arr;
    static int N, M, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];
        arr[0] = 0;
        arr[N + 1] = L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int result = bs(1, L);
        System.out.println(result);
    }

    private static int bs(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;

            for (int i = 1; i < arr.length; i++) {
                count += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if (count > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
