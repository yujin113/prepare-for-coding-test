package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_27211 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        visited = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(int startX, int startY) {
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + moveX[i];
                int y = node.y + moveY[i];
                if (x < 0) {
                    x = N + x;
                }
                if (y < 0) {
                    y = M + y;
                }
                if (x >= N) {
                    x = x - N;
                }
                if (y >= M) {
                    y = y - M;
                }

                if (arr[x][y] == 1) continue;
                if (visited[x][y]) continue;
                visited[x][y] = true;
                q.add(new Node(x, y));
            }
        }
    }
}
