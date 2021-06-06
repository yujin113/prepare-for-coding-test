package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dijk_4485 {
    static class Cave implements Comparable<Cave> {
        int x, y, count;

        public Cave(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Cave o) {
            return count - o.count;
        }
    }

    static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problem = 0;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            problem++;

            arr = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                }
            }
            sb.append("Problem " + problem + ": " + bfs() + "\n");
        }

        System.out.println(sb);
    }

    private static int bfs() {
        PriorityQueue<Cave> q = new PriorityQueue<>();
        q.add(new Cave(0, 0, arr[0][0]));

        while (!q.isEmpty()) {
            Cave cave = q.poll();

            if (cave.x == N - 1 && cave.y == N - 1)
                return cave.count;

            for (int i = 0; i < 4; i++) {
                int x = cave.x + moveX[i];
                int y = cave.y + moveY[i];
                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        q.add(new Cave(x, y, cave.count + arr[x][y]));
                    }
                }
            }
        }

        return 0;
    }
}
