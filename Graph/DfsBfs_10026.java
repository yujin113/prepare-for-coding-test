package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DfsBfs_10026 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                String str = line.substring(j, j + 1);
                if (str.equals("R"))
                    arr[i][j] = 0;
                if (str.equals("G"))
                    arr[i][j] = 1;
                if (str.equals("B"))
                    arr[i][j] = 2;
            }
        }
        int res1 = 0, res2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, n, arr[i][j]);
                    res1++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, n, arr[i][j]);
                    res2++;
                }
            }
        }
        System.out.print(res1 + " " + res2);
    }

    static void dfs(int row, int col, int n, int num) {
        if (visited[row][col])
            return;

        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int x = row + moveX[i];
            int y = col + moveY[i];
            if (x >= 0 && y >= 0 && x < n && y < n) {
                if (arr[x][y] == num)
                    dfs(x, y, n, num);
            }
        }
    }
}
