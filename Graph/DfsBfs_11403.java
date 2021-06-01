package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_11403 {

    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1 && !visited[j]) {
                    bfs(i, j, n);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int row, int col, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(col);

        while(!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < n; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    arr[row][i] = 1;
                    visited[i] = true;
                }
            }
        }

    }
}
