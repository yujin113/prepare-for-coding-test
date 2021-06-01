package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DfsBfs_2583 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[m][n];
        visited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int n_start = Integer.parseInt(st2.nextToken());
            int m_start = Integer.parseInt(st2.nextToken());
            int n_end = Integer.parseInt(st2.nextToken());
            int m_end = Integer.parseInt(st2.nextToken());
            for (int j = m_start; j < m_end; j++) {
                for (int l = n_start; l < n_end; l++) {
                    arr[j][l] = 1;
                }
            }
        }
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    int data = bfs(i, j, m, n);
                    list.add(data);
                    res++;
                }
            }
        }
        System.out.println(res);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static int bfs(int row, int col, int m, int n) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(row);
        qy.add(col);
        visited[row][col] = true;
        int temp = 1;

        while (!qx.isEmpty() && !qy.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = x + moveX[i];
                int y2 = y + moveY[i];
                if (x2 >= 0 && y2 >= 0 && x2 < m && y2 < n) {
                    if (arr[x2][y2] == 0 && !visited[x2][y2]) {
                        temp++;
                        visited[x2][y2] = true;
                        qx.add(x2);
                        qy.add(y2);
                    }
                }
            }
        }
        return temp;
    }
}
