package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_2468 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        int high = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
                if (arr[i][j] > high) high = arr[i][j];
            }
        }
        for (int i = 0; i <= high; i++) {
            int cnt = 0;
            visited = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (arr[j][k] > i && !visited[j][k]) {
//                        bfs(j, k, n, i);
                        dfs(j, k, n, i);
                        cnt++;
                    }
                }
            }
//            System.out.println(cnt);
            if (res < cnt) res = cnt;
        }
        System.out.println(res);
    }

    public static void dfs(int row, int col, int n, int height) {
        if (arr[row][col] <= height || visited[row][col])
            return;

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int x = row + moveX[i];
            int y = col + moveY[i];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                dfs(x, y, n, height);
            }
        }
    }

    public static void bfs(int row, int col, int n, int height) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        visited[row][col] = true;
        qx.add(row);
        qy.add(col);

        while (!qx.isEmpty() && !qy.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            for (int i = 0; i < 4; i++) {
                int x2 = x + moveX[i];
                int y2 = y + moveY[i];
                if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < n) {
                    if (arr[x2][y2] > height && !visited[x2][y2]) {
                        visited[x2][y2] = true;
                        qx.add(x2);
                        qy.add(y2);
                    }
                }
            }
        }
    }
}
