package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_3055 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String[][] arr;
    static boolean[][] visited;
    static Queue<Node> q, water;
    static int R, S;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new String[R][S];
        visited = new boolean[R][S];
        q = new LinkedList<>();
        water = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < S; j++) {
                String temp = line.substring(j, j + 1);
                arr[i][j] = temp;
                if (temp.equals("S")) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;
                }
                if (temp.equals("*")) {
                    water.add(new Node(i, j));
                }
            }
        }

        int res = bfs();
        if (res == 0)
            System.out.println("KAKTUS");
        else
            System.out.println(res);
    }

    private static int bfs() {
        int cost = 0;

        while (true) {
            cost++;

            int size = water.size();
            for (int i = 0; i < size; i++) {
                Node w = water.poll();
                for (int j = 0; j < 4; j++) {
                    int x = w.x + moveX[j];
                    int y = w.y + moveY[j];
                    if (x >= 0 && y >= 0 && x < R && y < S) {
                        if (arr[x][y].equals(".") || arr[x][y].equals("S")) {
                            water.add(new Node(x, y));
                            arr[x][y] = "*";
                        }
                    }
                }
            }

            if (q.size() == 0)
                return 0;

            int size2 = q.size();
            for (int i = 0; i < size2; i++) {
                Node n = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = n.x + moveX[j];
                    int y = n.y + moveY[j];
                    if (x >= 0 && y >= 0 && x < R && y < S) {
                        if (visited[x][y]) continue;
                        if (arr[x][y].equals("D")) return cost;
                        if (arr[x][y].equals(".")) {
                            visited[x][y] = true;
                            arr[x][y] = "S";
                            arr[n.x][n.y] = ".";
                            q.add(new Node(x, y));
                        }
                    }
                }
            }
        }

    }
}
