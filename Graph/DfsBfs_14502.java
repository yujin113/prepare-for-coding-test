package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_14502 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] arr, build_arr, virus_arr;
    private static int n, m, res;
    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        build_arr = new int[n][m];
        virus_arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
                build_arr[i][j] = arr[i][j];
            }
        }
        build(0, 0, 0);
        System.out.println(res);
    }

    private static void build(int x, int y, int count) {
        if (count == 3) {
            virus();
            int cnt = count();
            if (res < cnt) res = cnt;
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == x && j < y) continue;
                if (build_arr[i][j] == 0) {
                    build_arr[i][j] = 1;
                    build(x, y, count + 1);
                    build_arr[i][j] = 0;
                }
            }
        }
    }

    private static void virus() {
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                virus_arr[i][j] = build_arr[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_arr[i][j] == 2) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.poll().y;
            for (int i = 0; i < 4; i++) {
                int x2 = x + moveX[i];
                int y2 = y + moveY[i];
                if (x2 >= 0 && y2 >= 0 && x2 < n && y2 < m) {
                    if (virus_arr[x2][y2] == 0) {
                        virus_arr[x2][y2] = 2;
                        q.add(new Point(x2, y2));
                    }
                }
            }
        }
    }

    private static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (virus_arr[i][j] == 0)
                    cnt++;
            }
        }
        return cnt;
    }
}

