package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class brute_14889 {
    static int[][] arr;
    static boolean[] visited;
    static int res = Integer.MAX_VALUE, n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0,0);

        System.out.println(res);
    }

    private static void func(int idx, int count) {
        if (count == n / 2) {
//            for (int i = 0; i < n; i++) {
//                if (visited[i])
//                    System.out.print(i + " ");
//            }
//            System.out.println();
            calc();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                func(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    private static void calc() {
        int start = 0, link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                if (!visited[i] && !visited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        if (res > Math.abs(start - link))
            res = Math.abs(start - link);
    }
}
