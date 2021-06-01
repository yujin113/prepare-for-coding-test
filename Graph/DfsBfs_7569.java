package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_7569 {
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<Integer> qm = new LinkedList<>();
    static Queue<Integer> qn = new LinkedList<>();
    static Queue<Integer> qh = new LinkedList<>();
    static int[] moveM = {0, 1, 0, -1, 0, 0};
    static int[] moveN = {-1, 0, 1, 0, 0, 0};
    static int[] moveH = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        visited = new boolean[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st2.nextToken());
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 1 && !visited[i][j][k]) {
                        qh.add(i);
                        qn.add(j);
                        qm.add(k);
                    }
                }
            }
        }
        bfs(n, m, h);
        int largest = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] > largest)
                        largest = arr[i][j][k];
                    if (arr[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(largest - 1);
    }

    public static void bfs(int n, int m, int h) {
        while (!qh.isEmpty()) {
            int x = qn.poll();
            int y = qm.poll();
            int z = qh.poll();
            for (int i = 0; i < 6; i++) {
                int x2 = x + moveN[i];
                int y2 = y + moveM[i];
                int z2 = z + moveH[i];
                if (x2 >= 0 && y2 >= 0 && z2 >= 0 && x2 < n && y2 < m && z2 < h) {
                    if (arr[z2][x2][y2] == 0 && !visited[z2][x2][y2]) {
                        visited[z2][x2][y2] = true;
                        arr[z2][x2][y2] = arr[z][x][y] + 1;
                        qh.add(z2);
                        qm.add(y2);
                        qn.add(x2);
                    }
                }
            }
        }
    }
}
