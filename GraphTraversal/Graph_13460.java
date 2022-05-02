package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_13460 {
    static class Node {
        int rowR, colR, rowB, colB, num;

        public Node(int rowR, int colR, int rowB, int colB, int num) {
            this.rowR = rowR;
            this.colR = colR;
            this.rowB = rowB;
            this.colB = colB;
            this.num = num;
        }
    }

    static int[] moveR = {-1, 1, 0, 0};
    static int[] moveC = {0, 0, 1, -1};
    static int N, M;
    static char[][] arr;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][N][M];

        Queue<Node> q = new LinkedList<>();
        int rowR = 0, colR = 0, rowB = 0, colB = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'R') {
                    rowR = i;
                    colR = j;
                }
                if (arr[i][j] == 'B') {
                    rowB = i;
                    colB = j;
                }
            }
        }
        q.add(new Node(rowR, colR, rowB, colB, 0));
        visited[rowR][colR][rowB][colB] = true;

        System.out.println(bfs(q));

    }

    private static int bfs(Queue<Node> q) {
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.num + 1 > 10) {
                return -1;
            }


            for (int i = 0; i < 4; i++) {
                int rowR = node.rowR;
                int colR = node.colR;
                int rowB = node.rowB;
                int colB = node.colB;

                while (arr[rowR + moveR[i]][colR + moveC[i]] != '#') {
                    rowR += moveR[i];
                    colR += moveC[i];
                    if (arr[rowR][colR] == 'O') break;
                }
                while (arr[rowB + moveR[i]][colB + moveC[i]] != '#') {
                    rowB += moveR[i];
                    colB += moveC[i];
                    if (arr[rowB][colB] == 'O') break;
                }


                if (arr[rowB][colB] == 'O') continue;
                if (arr[rowR][colR] == 'O') {
                    return node.num + 1;
                }

                if (rowR == rowB && colR == colB) {
                    int movingR = Math.abs(rowR - node.rowR) + Math.abs(colR - node.colR);
                    int movingB = Math.abs(rowB - node.rowB) + Math.abs(colB - node.colB);

                    if (movingR > movingB) {
                        rowR -= moveR[i];
                        colR -= moveC[i];
                    } else {
                        rowB -= moveR[i];
                        colB -= moveC[i];
                    }
                }

                if (!visited[rowR][colR][rowB][colB]) {
                    visited[rowR][colR][rowB][colB] = true;
                    q.add(new Node(rowR, colR, rowB, colB, node.num + 1));
                }
            }
        }

        return -1;
    }
}
