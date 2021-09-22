package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_2667 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    list.add(bfs(i, j, N));
                    num++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(num);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    private static int bfs(int x, int y, int N) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        int count = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int row = node.x + moveX[i];
                int col = node.y + moveY[i];

                if (row >= 0 && col >= 0 && row < N && col < N) {
                    if (visited[row][col]) continue;
                    visited[row][col] = true;
                    if (arr[row][col] == 1) {
                        q.add(new Node(row, col));
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
