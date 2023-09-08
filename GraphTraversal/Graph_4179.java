package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_4179 {
    static char[][] map;
    static int R, C;
    static Queue<Node> fires = new LinkedList<>();
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        Node start = null;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'F') {
                    fires.add(new Node(i, j));
                }
                if (map[i][j] == 'J') {
                    start = new Node(i, j, 0);
                    map[i][j] = '.';
                }
            }
        }

        int result = bfs(start);
        if (result == 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        boolean[][] visited = new boolean[R][C];
        visited[start.x][start.y] = true;

        int nowTime = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.time == nowTime) {
                spreadFire();
                nowTime++;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.x + move[i][0];
                int dy = node.y + move[i][1];

                if (dx >= 0 && dy >= 0 && dx < R && dy < C) {
                    if (!visited[dx][dy] && map[dx][dy] == '.') {
                        visited[dx][dy] = true;
                        q.add(new Node(dx, dy, node.time + 1));
                    }
                } else {
                    return node.time + 1;
                }
            }
        }

        return 0;
    }

    private static void spreadFire() {
        int size = fires.size();
        while (size-- > 0) {
            Node fire = fires.poll();
            for (int i = 0; i < 4; i++) {
                int dx = fire.x + move[i][0];
                int dy = fire.y + move[i][1];

                if (dx >= 0 && dy >= 0 && dx < R && dy < C && map[dx][dy] == '.') {
                    map[dx][dy] = 'F';
                    fires.add(new Node(dx, dy));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
