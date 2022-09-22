package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_2636 {
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] arr;
    static int[] moveR = {0, 1, 0, -1};
    static int[] moveC = {-1, 0, 1, 0};
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]); //세로
        M = Integer.parseInt(st[1]); //가로
        arr = new int[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
                if (arr[i][j] == 1) count++;
            }
        }

        int time = 0;
        int result = 0;
        while (count > 0) {
            result = count;
            time++;
            count = bfs(count);
        }

        System.out.println(time);
        System.out.println(result);
    }

    static int bfs(int count) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        boolean[][] visited = new boolean[N][M];


        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];

                if (row >= 0 && col >= 0 && row < N && col < M) {
                    if (visited[row][col]) continue;
                    visited[row][col] = true;

                    if (arr[row][col] == 1) {
                        arr[row][col] = 0;
                        count--;
                    } else {
                        q.add(new Node(row, col));
                    }
                }
            }
        }

        return count;
    }
}
