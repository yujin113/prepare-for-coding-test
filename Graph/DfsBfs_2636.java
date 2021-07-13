package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_2636 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr;
    static boolean[][] visited;
    static int N, M, count = 0;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    count++;
            }
        }

        int time = 0;
        int num = 0;
        while (count != 0) {
            time++;
            num = count;
            bfs();
        }

        System.out.println(time);
        System.out.println(num);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));
        visited = new boolean[N][M];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int x2 = n.x + moveX[i];
                int y2 = n.y + moveY[i];

                if (x2 >= 0 && y2 >= 0 && x2 < N && y2 < M) {
                    if (visited[x2][y2]) continue;

                    if (arr[x2][y2] == 0) {
                        q.add(new Node(x2, y2));
                        visited[x2][y2] = true;
                    }
                    if (arr[x2][y2] == 1) {
                        count--;
                        arr[x2][y2] = 0;
                        visited[x2][y2] = true;
                    }
                }
            }
        }
    }
}
