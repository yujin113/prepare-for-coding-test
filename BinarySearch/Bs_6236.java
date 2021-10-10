package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_6236 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int result = bs(max, sum, M);
        System.out.println(result);

    }

    public static int bs(int left, int right, int M) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int cost = mid;

            for (int i : arr) {
                if (cost - i < 0) {
                    cost = mid;
                    count++;
                }
                cost -= i;
            }

            if (count <= M)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
