package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_5427 {
    static class Node {
        int x, y;
        int count;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static char[][] map;
    static int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static Queue<Node> fires;
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int testcase = 0; testcase < T; testcase++) {
            String[] mapInfo = br.readLine().split(" ");
            w = Integer.parseInt(mapInfo[0]);
            h = Integer.parseInt(mapInfo[1]);

            map = new char[h][w];
            fires = new LinkedList<>();
            Node start = null;
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        start = new Node(i, j);
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') {
                        fires.add(new Node(i, j));
                    }
                }
            }

            int count = bfs(start);
            if (count == -1) {
                sb.append("IMPOSSIBLE").append("\n");
            } else {
                sb.append(count).append("\n");
            }
        }

        System.out.println(sb);
    }

    static int bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start.x, start.y, 0));
        boolean[][] visited = new boolean[h][w];
        int num = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.count == num) {
                burn();
                num++;
            }

            for (int i = 0; i < 4; i++) {
                int dx = node.x + move[i][0];
                int dy = node.y + move[i][1];

                if (dx >= 0 && dy >= 0 && dx < h && dy < w) {
                    if (map[dx][dy] == '.' && !visited[dx][dy]) {
                        q.add(new Node(dx, dy, node.count + 1));
                        visited[dx][dy] = true;
                    }
                } else {
                    return node.count + 1;
                }
            }
        }

        return -1;
    }

    static void burn() {
        int size = fires.size();

        for (int i = 0; i < size; i++) {
            Node node = fires.poll();

            for (int j = 0; j < 4; j++) {
                int dx = node.x + move[j][0];
                int dy = node.y + move[j][1];

                if (dx > 0 && dy > 0 && dx < h && dy < w && map[dx][dy] == '.') {
                    fires.add(new Node(dx, dy));
                    map[dx][dy] = '*';
                }
            }
        }
    }
}
