package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_2178 {
    static class Node {
        int x, y, count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        int result = bfs(N, M);
        System.out.println(result);
    }

    private static int bfs(int N, int M) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1));
        int count = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.x + moveX[i];
                int col = node.y + moveY[i];

                if (row == N - 1 && col == M - 1) {
                    if (count > node.count + 1) {
                        count = node.count + 1;
                    }
                }

                if (row >= 0 && col >= 0 && row < N && col < M) {
                    if (visited[row][col]) continue;
                    visited[row][col] = true;
                    if (arr[row][col] == 1) {
                        q.add(new Node(row, col, node.count + 1));
                    }
                }
            }
        }

        return count;
    }
}
