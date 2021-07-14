package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class brute_2589 {
    static class Node{
        int x, y, distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int N, M;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'W')
                    arr[i][j] = 0; //바다
                if (line.charAt(j) == 'L')
                    arr[i][j] = 1; //육지
            }
        }

        int res = 0;
        int dis;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    dis = bfs(i, j);
                    res = Math.max(dis, res);
                }
            }
        }

        System.out.println(res);
    }

    private static int bfs(int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));
        visited = new boolean[N][M];
        visited[startX][startY] = true;
        int max = 0;

        while (!q.isEmpty()) {
            Node n = q.poll();

            max = Math.max(max, n.distance);

            for (int i = 0; i < 4; i++) {
                int x = n.x + moveX[i];
                int y = n.y + moveY[i];

                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (visited[x][y]) continue;

                    if (arr[x][y] == 1) {
                        q.add(new Node(x, y, n.distance + 1));
                        visited[x][y] = true;
                    }
                }
            }
        }

        return max;
    }
}
