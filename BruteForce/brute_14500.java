package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class brute_14500 {
    static int[][] arr;
    static boolean[][] visited;
    static int res = 0;
    static int n, m;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                exception(i, j);
                dfs(i, j, 0, 0);
            }
        }
        System.out.println(res);
    }

    public static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            res = Math.max(sum, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r = row + moveX[i];
            int c = col + moveY[i];
            if (r >= 0 && c >= 0 && r < n && c < m) {
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    dfs(r, c, sum + arr[r][c], count + 1);
                    visited[r][c] = false;
                }
            }
        }
    }

    public static void exception(int row, int col) {
        for (int i = 0; i < 4; i++) {
            int sum = arr[row][col];
            boolean flag = true;

            for (int j = 0; j < 3; j++) {
                int r = row + moveX[(i + j) % 4];
                int c = col + moveY[(i + j) % 4];

                if (r >= 0 && c >= 0 && r < n && c < m) {
                    sum += arr[r][c];
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag) res = Math.max(res, sum);
        }

    }
}
