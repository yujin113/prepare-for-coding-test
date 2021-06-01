package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_2206 {
    static class Point {
        int x, y, count, wall;

        Point(int x, int y, int wall, int count) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.count = count;
        }
    }

    static int[][] arr;
    static int[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(bfs(n, m));
    }

    private static int bfs(int n, int m) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0, 1));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x == n - 1 && p.y == m - 1)
                return p.count;

            for (int i = 0; i < 4; i++) {
                int x = p.x + moveX[i];
                int y = p.y + moveY[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (visited[x][y] <= p.wall) continue;
                    if (arr[x][y] == 0) { // 벽 아닐 때
                        visited[x][y] = p.wall;
                        q.add(new Point(x, y, p.wall, p.count + 1));
                    } else { // 벽일 때
                        if (p.wall == 0) {
                            visited[x][y] = p.wall + 1;
                            q.add(new Point(x, y, p.wall + 1, p.count + 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
