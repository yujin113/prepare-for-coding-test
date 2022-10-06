package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        int[] temp = new int[3];
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st[j]);
            }
            if (i == 0) {
                maxDp[0] = arr[0];
                maxDp[1] = arr[1];
                maxDp[2] = arr[2];
                minDp[0] = arr[0];
                minDp[1] = arr[1];
                minDp[2] = arr[2];
                continue;
            }
            temp[0] = Math.max(maxDp[0], maxDp[1]) + arr[0];
            temp[1] = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + arr[1];
            temp[2] = Math.max(maxDp[1], maxDp[2]) + arr[2];
            maxDp[0] = temp[0];
            maxDp[1] = temp[1];
            maxDp[2] = temp[2];

            temp[0] = Math.min(minDp[0], minDp[1]) + arr[0];
            temp[1] = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + arr[1];
            temp[2] = Math.min(minDp[1], minDp[2]) + arr[2];
            minDp[0] = temp[0];
            minDp[1] = temp[1];
            minDp[2] = temp[2];
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i : maxDp) {
            max = Math.max(max, i);
        }
        for (int i : minDp) {
            min = Math.min(min, i);
        }

        System.out.print(max + " " + min);
    }
}
