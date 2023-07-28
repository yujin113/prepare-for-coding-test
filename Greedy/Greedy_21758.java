package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_21758 {
    static int[] honey;
    static int[] leftSum;
    static int[] rightSum;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        honey = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(line[i]);
        }

        leftSum = new int[N];
        rightSum = new int[N];

        leftSum[0] = honey[0];
        rightSum[N - 1] = honey[N - 1];

        for (int i = 1; i < N; i++) {
            leftSum[i] = leftSum[i - 1] + honey[i];
        }
        for (int i = N - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + honey[i];
        }

        calcHoney(N);

        System.out.println(result);
    }

    private static void calcHoney(int N) {
        int sum = leftSum[N - 1];

        // 벌 왼쪽 끝, 벌통 오른쪽 끝
        for (int i = 1; i < N - 1; i++) {
            int bee1 = sum - (honey[0] + honey[i]);
            int bee2 = sum - leftSum[i];
            result = Math.max(result, bee1 + bee2);
        }

        // 벌통 왼쪽 끝, 벌 오른쪽 끝
        for (int i = 1; i < N - 1; i++) {
            int bee1 = sum - (honey[N - 1] + honey[i]);
            int bee2 = sum - rightSum[i];
            result = Math.max(result, bee1 + bee2);
        }

        // 벌 양쪽 끝
        for (int i = 1; i < N - 1; i++) {
            int bee1 = leftSum[i] - honey[0];
            int bee2 = rightSum[i] - honey[N - 1];
            result = Math.max(result, bee1 + bee2);
        }
    }
}
