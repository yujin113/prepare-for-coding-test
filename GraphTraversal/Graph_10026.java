package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_10026 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        int[][] arr2 = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    arr[i][j] = 0;
                    arr2[i][j] = 0;
                } else if (c == 'G') {
                    arr[i][j] = 1;
                    arr2[i][j] = 0;
                } else if (c == 'B') {
                    arr[i][j] = 2;
                    arr2[i][j] = 1;
                }
            }
        }

        int count1 = 0, count2 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(N, i, j, arr);
                    count1 += 1;
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(N, i, j, arr2);
                    count2 += 1;
                }
            }
        }

        System.out.println(count1 + " " + count2);
    }

    private static void bfs(int N, int x, int y, int[][] arr) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int num = arr[node.x][node.y];

            for (int i = 0; i < 4; i++) {
                int row = node.x + moveX[i];
                int col = node.y + moveY[i];

                if (row >= 0 && col >= 0 && row < N && col < N) {
                    if (visited[row][col]) continue;
                    if (num == arr[row][col]) {
                        q.add(new Node(row, col));
                        visited[row][col] = true;
                    }
                }
            }
        }
    }
}
