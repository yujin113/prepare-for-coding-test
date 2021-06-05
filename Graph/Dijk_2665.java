package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dijk_2665 {
    static class Room {
        int x, y, count;

        public Room(int x, int y, int count) {
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
        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int res = bfs(n);

        System.out.println(res);

    }

    private static int bfs(int n) {
        Deque<Room> q = new LinkedList<>();
        q.add(new Room(0, 0, 0));

        while (!q.isEmpty()) {
            Room r = q.pollLast();

            if (r.x == n - 1 && r.y == n - 1)
                return r.count;

            for (int i = 0; i < 4; i++) {
                int x = r.x + moveX[i];
                int y = r.y + moveY[i];
                if (x >= 0 && y>= 0 && x < n && y < n) {
                    if (!visited[x][y] && arr[x][y] == 1) {
                        visited[x][y] = true;
                        q.addLast(new Room(x, y, r.count));
                    }
                    if (!visited[x][y] && arr[x][y] == 0) {
                        visited[x][y] = true;
                        q.addFirst(new Room(x, y, r.count + 1));
                    }
                }
            }
        }
        return 0;
    }
}
