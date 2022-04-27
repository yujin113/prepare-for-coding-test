package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_2573 {
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] arr;
    static int N, M;
    static int[] moveR = {0, 1, 0, -1};
    static int[] moveC = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int count = 1;
        while (count == 1) {
            melt();
            count = countNum();
            result++;
        }
        if (count == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }

    }

    private static void melt() {
        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            int count = 0;
            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];

                if (row >= 0 && col >= 0 && row < N && col < M) {
                    if (!visited[row][col] && arr[row][col] == 0) {
                        count++;
                    }
                }
            }
            arr[node.row][node.col] -= count;
            if (arr[node.row][node.col] < 0) {
                arr[node.row][node.col] = 0;
            }

        }
    }

    private static int countNum() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static void bfs(int startR, int startC, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startR, startC));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];

                if (row >= 0 && col >= 0 && row < N && col < M) {
                    if (arr[row][col] != 0 && !visited[row][col]) {
                        visited[row][col] = true;
                        q.add(new Node(row, col));
                    }
                }
            }
        }
    }
}
