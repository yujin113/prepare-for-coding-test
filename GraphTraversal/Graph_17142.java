package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph_17142 {
    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int N, M, minTime, emptySpace;
    static int[][] arr;
    static int[] active;
    static List<Node> virus;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][N];
        virus = new ArrayList<>();

        emptySpace = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(str[j]);
                arr[i][j] = n;
                if (n == 0) {
                    emptySpace++;
                }
                if (n == 2) {
                    virus.add(new Node(i, j, 0));
                }
            }
        }

        if (emptySpace == 0) {
            System.out.println(0);
            return;
        }

        minTime = Integer.MAX_VALUE;

        active = new int[M];
        bt(0);

        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }

    static void bt(int cnt) {
        if (cnt == M) {
            bfs(emptySpace);
            return;
        }

        for (int i = 1; i <= virus.size(); i++) {
            if (cnt > 0 && active[cnt - 1] >= i) continue;
            active[cnt] = i;
            bt(cnt + 1);
        }
    }

    static void bfs(int emptySpace) {
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {-1, 0, 1, 0};
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i : active) {
            Node node = virus.get(i - 1);
            q.add(node);
            visited[node.x][node.y] = true;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = node.x + moveX[i];
                int y = node.y + moveY[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (visited[x][y] || arr[x][y] == 1) continue;
                    visited[x][y] = true;

                    if (arr[x][y] == 0) {
                        emptySpace--;
                    }

                    if (emptySpace == 0) {
                        minTime = Math.min(minTime, node.time + 1);
                        return;
                    }
                    q.add(new Node(x, y, node.time + 1));
                }
            }
        }
    }
}