package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_1987 {
    static int[][] arr;
    static boolean[] visited;
    static int R, C, max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        visited = new boolean[43]; // 17 ~ 42

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int row, int col, int count) {
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {-1, 0, 1, 0};

        visited[arr[row][col]] = true;

        for (int i = 0; i < 4; i++) {
            int r = row + moveX[i];
            int c = col + moveY[i];

            if (r >= 0 && c >= 0 && r < R && c < C) {
                if (visited[arr[r][c]]) continue;
                dfs(r, c, count + 1);
            }
        }

        visited[arr[row][col]] = false;
        max = Math.max(max, count);
    }
}
