package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_11559 {
    static class Node {
        char booyo;
        int x;
        int y;

        public Node(char booyo, int x, int y) {
            this.booyo = booyo;
            this.x = x;
            this.y = y;
        }
    }

    static char[][] map;
    static int result = 0;
    static boolean[][] visited;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        while (true) {
            boolean isBurst = false;
            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        list = new ArrayList<>();
                        visited[i][j] = true;
                        if (bfs(i, j)) {
                            isBurst = true;
                        }
                        if (list.size() >= 4) {
                            down();
                        }
                    }
                }
            }

            if (isBurst) {
                result++;
            } else {
                break;
            }
        }

        System.out.println(result);
    }

    static boolean bfs(int startX, int startY) {
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(map[startX][startY], startX, startY));
        int count = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            count++;
            list.add(node);

            for (int i = 0; i < 4; i++) {
                int x = node.x + move[i][0];
                int y = node.y + move[i][1];

                if (x >= 0 && y >= 0 && x < 12 && y < 6 && !visited[x][y]) {
                    if (map[x][y] == node.booyo) {
                        visited[x][y] = true;
                        q.add(new Node(map[x][y], x, y));
                    }
                }
            }
        }

        if (count >= 4) {
            return true;
        } else {
            return false;
        }
    }

    static void down() {
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            map[node.x][node.y] = '.';
        }

        for (int i = 0; i < 6; i++) {
            Queue<Character> q = new LinkedList<>();
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    q.add(map[j][i]);
                    map[j][i] = '.';
                }
            }

            int index = 11;
            while (!q.isEmpty()) {
                map[index][i] = q.poll();
                index--;
            }
        }

    }
}
