package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_2212 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 센서
        int K = Integer.parseInt(br.readLine()); // 집중국

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(find(N, K));
    }

    static int find(int N, int K) {
        if (K >= N) {
            return 0;
        }

        int[] diff = new int[N - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = Math.abs(arr[i + 1] - arr[i]);
        }
        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < N - K; i++) {
            result += diff[i];
        }
        return result;
    }
}
