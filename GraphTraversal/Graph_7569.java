package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_7569 {
    static class Node {
        int m, n, h, day;

        public Node(int m, int n, int h, int day) {
            this.m = m;
            this.n = n;
            this.h = h;
            this.day = day;
        }
    }

    static int[][][] arr;
    static boolean[][][] visited;
    static int[] moveM = {0, 1, 0, -1, 0, 0};
    static int[] moveN = {-1, 0, 1, 0, 0, 0};
    static int[] moveH = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); //가로
        int N = Integer.parseInt(st.nextToken()); //세로
        int H = Integer.parseInt(st.nextToken()); //높이
        arr = new int[H][N][M];
        visited = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        int zeroCnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        q.add(new Node(k, j, i, 0));
                        visited[i][j][k] = true;
                    }
                    if (arr[i][j][k] == 0) {
                        zeroCnt += 1;
                    }
                }
            }
        }
        if (zeroCnt == 0) {
            System.out.println(0);
            System.exit(0);
        }

        bfs(M, N, H, q);

        // 다 익었는지 검사
        int result = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(int M, int N, int H, Queue<Node> q) {
        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 6; i++) {
                int m = node.m + moveM[i];
                int n = node.n + moveN[i];
                int h = node.h + moveH[i];

                if (m >= 0 && n >= 0 && h >= 0 && m < M && n < N && h < H) {
                    if (visited[h][n][m]) continue;
                    visited[h][n][m] = true;
                    if (arr[h][n][m] == 0) {
                        arr[h][n][m] = node.day + 1;
                        q.add(new Node(m, n, h, node.day + 1));
                    }
                }
            }
        }
    }
}
