package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_7576 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Node> q = new LinkedList<>();

        int zeroCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                }
                if (arr[i][j] == 0) zeroCount++;
            }
        }
        if (zeroCount == 0) {
            System.out.println("0");
            System.exit(0);
        }

        bfs(q, N, M);

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println("-1");
                    System.exit(0);
                }
                result = Math.max(arr[i][j], result);
            }
        }

        System.out.println(result);
    }

    private static void bfs(Queue<Node> q, int N, int M) {
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.x + moveX[i];
                int col = node.y + moveY[i];

                if (row >= 0 && col >= 0 && row < N && col < M) {
                    if (arr[row][col] == -1) continue;
                    if (arr[row][col] == 0) {
                        arr[row][col] = node.count + 1;
                        q.add(new Node(row, col, node.count + 1));
                    }
                }
            }
        }
    }
}
