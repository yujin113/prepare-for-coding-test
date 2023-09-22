package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bt_17182 {
    static int[][] arr;
    static boolean[] visited;
    static int N, K;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];
        visited[K] = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) { //경유
            for (int j = 0; j < N; j++) { //출발
                if (i == j) continue;
                for (int k = 0; k < N; k++) { //도착
                    if (i == k || j == k) continue;
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }

        bt(0, K, 0);

        System.out.println(result);
    }

    private static void bt(int depth, int now, int time) {
        if (isAllVisited()) {
            result = Math.min(result, time);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (now == i || visited[i]) continue;
            visited[i] = true;
            bt(depth + 1, i, time + arr[now][i]);
            visited[i] = false;
        }
    }

    private static boolean isAllVisited() {
        boolean flag = true;

        for (boolean b : visited) {
            if (!b) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
