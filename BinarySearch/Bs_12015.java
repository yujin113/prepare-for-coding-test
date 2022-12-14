package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = arr[0];

        int len = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > lis[len - 1]) {
                lis[len] = arr[i];
                len++;
            } else {
                int res = bs(lis, arr[i], len - 1);
                lis[res] = arr[i];
            }
        }
        System.out.println(len);
    }

    static int bs(int[] lis, int num, int right) {
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (lis[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
