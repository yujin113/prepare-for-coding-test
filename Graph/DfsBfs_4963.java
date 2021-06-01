package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_4963 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] moveY = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            arr = new int[h][w];
            visited = new boolean[h][w];
            int num = 0;
            for (int i = 0; i < h; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && arr[i][j] == 1) {
                        visited[i][j] = true;
                        bfs(i, j, w, h);
                        num++;
                    }
                }
            }
            sb.append(num + "\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int row, int col, int w, int h) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(row);
        qy.add(col);

        while(!qx.isEmpty() && !qy.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            for(int i = 0; i < 8; i++) {
                int x2 = x + moveX[i];
                int y2 = y + moveY[i];

                if (x2 >= 0 && y2 >= 0 && x2 < h && y2 < w) {
                    if (arr[x2][y2] == 1 && !visited[x2][y2]) {
                        qx.add(x2);
                        qy.add(y2);
                        visited[x2][y2] = true;
                    }
                }
            }
        }
    }
}
