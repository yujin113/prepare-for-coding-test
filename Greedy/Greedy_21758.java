package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_21758 {
    static int[] honey;
    static int[][] sum;
    static int[] arr = new int[3];
    static boolean[] visited;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        honey = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(line[i]);
        }

        sum = new int[N][N];
        for (int i = 0; i < N; i++) {
            int temp = honey[i];
            sum[i][i] = temp;
            for (int j = i + 1; j < N; j++) {
                temp += honey[j];
                sum[i][j] = temp;
                sum[j][i] = temp;
            }
        }

        visited = new boolean[N];
        bt(0);

        System.out.println(result);
    }

    static void bt(int depth) {
        if (depth == 3) {
//            for (int i : arr) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
            countHoney();
            return;
        }

        for (int i = 0; i < honey.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[depth] = i;
            bt(depth + 1);
            visited[i] = false;
        }
    }

    static void countHoney() {
        int bee1 = sum[arr[0]][arr[2]] - honey[arr[0]];
        int bee2 = sum[arr[1]][arr[2]] - honey[arr[1]];
        int sum = bee1 + bee2;

        if (arr[0] < arr[2] && arr[1] < arr[2]) {
            if (arr[0] < arr[1]) {
                sum -= honey[arr[1]];
            } else {
                sum -= honey[arr[0]];
            }
        }
        if (arr[2] < arr[0] && arr[2] < arr[1]) {
            if (arr[0] < arr[1]) {
                sum -= honey[arr[0]];
            } else {
                sum -= honey[arr[1]];
            }
        }

//        System.out.println(sum);
//        System.out.println();
        result = Math.max(result, sum);
    }
}
