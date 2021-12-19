package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_14502 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};
    static int N, M, res; // N 세로 M 가로
    static int[][] virusArr, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virusArr = new int[N][M];
        arr = new int[N][M];
        res = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);
        System.out.println(res);

    }

    private static void makeWall(int count) {
        if (count == 3) {
            bfs();
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (virusArr[i][j] == 0) cnt++;
                }
            }
            res = Math.max(res, cnt);

            return;

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    makeWall(count + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusArr[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusArr[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = p.x + moveX[i];
                int col = p.y + moveY[i];

                if (row >= 0 && col >= 0 && col < M && row < N) {
                    if (virusArr[row][col] != 0) continue;
                    virusArr[row][col] = 2;
                    q.add(new Point(row, col));
                }
            }
        }

    }
}
