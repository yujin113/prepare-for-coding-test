package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_3109 {
    static char[][] map;
    static int[][] move = {{-1, 1}, {0, 1}, {1, 1}};
    static int R, C;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            dfs(i, 0);
        }

        System.out.println(result);
    }

    private static boolean dfs(int x, int y) {
        if (y == C - 1) {
            result++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];
            if (dx >= 0 && dy >= 0 && dx < R && dy < C) {
                if (map[dx][dy] == '.') {
                    map[dx][dy] = 'X';
                    if (dfs(dx, dy)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
