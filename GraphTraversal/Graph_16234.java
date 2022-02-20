package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_16234 {
    static class Node {
        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited;
    static ArrayList<Node> list;
    static int[] moveR = {-1, 0, 1, 0};
    static int[] moveC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    visited[i][j] = true;
                    int sum = bfs(i, j);
                    if (list.size() > 1) {
                        // 인구 이동
                        isMove = true;
                        int avg = sum / list.size();
                        for (Node node : list) {
                            arr[node.row][node.col] = avg;
                        }
                    }
                }
            }
            if (!isMove) break;
            result += 1;
        }

        System.out.println(result);
    }

    private static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        list = new ArrayList<>();
        list.add(new Node(r, c));
        int sum = arr[r][c];

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.row + moveR[i];
                int col = node.col + moveC[i];
                if (row >= 0 && col >= 0 && row < N && col < N) {
                    if (visited[row][col]) continue;
                    int num = Math.abs(arr[node.row][node.col] - arr[row][col]);
                    if (num >= L && num <= R) {
                        visited[row][col] = true;
                        q.add(new Node(row, col));
                        list.add(new Node(row, col));
                        sum += arr[row][col];
                    }
                }
            }
        }
        return sum;
    }
}
