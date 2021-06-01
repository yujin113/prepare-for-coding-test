package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Dijk_1261 {
    static class Point {
        int x, y, count;

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(n, m));
    }

    private static int bfs(int n, int m) {
        Deque<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 0));

        while (!q.isEmpty()) {
            Point p = q.pollLast();

            if (p.x == n - 1 && p.y == m - 1)
                return p.count;

            for (int i = 0; i < 4; i++) {
                int x = p.x + moveX[i];
                int y = p.y + moveY[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    if (!visited[x][y] && arr[x][y] == 0) {
                        visited[x][y] = true;
                        q.addLast(new Point(x, y, p.count));
                    }
                    if (!visited[x][y] && arr[x][y] == 1) {
                        visited[x][y] = true;
                        q.addFirst(new Point(x, y, p.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}
