package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_2146 {
    static class Node {
        int row, col, len;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Node(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }

    static int[][] arr;
    static int[] moveR = {-1, 0, 1, 0};
    static int[] moveC = {0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[N][N];
        int changeNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    visited[i][j] = true;
                    divide(N, i, j, changeNum, visited);
                    changeNum++;
                }
            }
        }

        int temp = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == temp) {
                    visited = new boolean[N][N];
                    bfs(N, i, j, visited);
                    temp++;
                }
            }
        }

        System.out.println(result);
    }

    //각 섬에 1,2,3... 인덱스 붙여주기
    private static void divide(int N, int r, int c, int changeNum, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        arr[r][c] = changeNum;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];

                if (row >= 0 && col >= 0 && row < N && col < N) {
                    if (visited[row][col]) continue;
                    visited[row][col] = true;

                    if (arr[row][col] == 1) {
                        arr[row][col] = changeNum;
                        q.add(new Node(row, col));
                    }
                }
            }
        }
    }

    private static void bfs(int N, int startR, int startC, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startR, startC, 0));
        int nowIndex = arr[startR][startC];
        visited[startR][startC] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];

                if (row >= 0 && col >= 0 && row < N && col < N) {
                    if (visited[row][col]) continue;
                    visited[row][col] = true;

                    if (arr[row][col] == 0) {
                        q.add(new Node(row, col, node.len + 1));
                    } else {
                        if (arr[row][col] != nowIndex) {
                            result = Math.min(result, node.len);
                        }
                        if (arr[row][col] == nowIndex) {
                            q.add(new Node(row, col, 0));
                        }
                    }
                }
            }
        }
    }
}
