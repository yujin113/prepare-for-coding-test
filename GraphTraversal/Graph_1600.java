package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_1600 {
    static class Node {
        int row, col, num, K;

        public Node(int row, int col, int num, int K) {
            this.row = row;
            this.col = col;
            this.num = num;
            this.K = K;
        }
    }

    static int[][] arr;
    static int[] moveR = {-1, 1, 0, 0};
    static int[] moveC = {0, 0, 1, -1};
    static int[] horseR = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] horseC = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int W = Integer.parseInt(str[0]);
        int H = Integer.parseInt(str[1]);
        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = bfs(W, H, K);
        System.out.println(result);
    }

    static int bfs(int W, int H, int K) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, K));
        boolean[][][] visited = new boolean[H][W][K + 1];
        visited[0][0][K] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.row == H - 1 && node.col == W - 1) {
                return node.num;
            }

            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];

                if (row >= 0 && col >= 0 && row < H && col < W) {
                    if (arr[row][col] == 1) continue;

                    if (visited[row][col][node.K]) continue;
                    visited[row][col][node.K] = true;
                    q.add(new Node(row, col, node.num + 1, node.K));
                }
            }
            if (node.K > 0) {
                for (int i = 0; i < 8; i++) {
                    int row = node.row + horseR[i];
                    int col = node.col + horseC[i];

                    if (row >= 0 && col >= 0 && row < H && col < W) {
                        if (arr[row][col] == 1) continue;

                        if (visited[row][col][node.K - 1]) continue;
                        visited[row][col][node.K - 1] = true;
                        q.add(new Node(row, col, node.num + 1, node.K - 1));
                    }
                }
            }

        }

        return -1;
    }
}
