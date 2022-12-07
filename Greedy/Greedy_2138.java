package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_2138 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr2 = new int[N];
        String[] str = br.readLine().split("");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            arr2[i] = arr[i];
        }
        str = br.readLine().split("");
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(str[i]);
        }

        int res = Integer.MAX_VALUE;
        int cnt = 0, cnt2 = 0;

        change(arr, 0);
        cnt++;
        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != result[i - 1]) {
                change(arr, i);
                cnt++;
            }
        }
        if (arr[N - 1] == result[N - 1]) {
            res = Math.min(res, cnt);
        }

        for (int i = 1; i < N; i++) {
            if (arr2[i - 1] != result[i - 1]) {
                change(arr2, i);
                cnt2++;
            }
        }
        if (arr2[N - 1] == result[N - 1]) {
            res = Math.min(res, cnt2);
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    static void change(int[] arr, int index) {
        arr[index] = 1 - arr[index];
        if (index == 0) {
            arr[index + 1] = 1 - arr[index + 1];
        } else if (index == N - 1) {
            arr[index - 1] = 1 - arr[index - 1];
        } else {
            arr[index - 1] = 1 - arr[index - 1];
            arr[index + 1] = 1 - arr[index + 1];
        }
    }
}
