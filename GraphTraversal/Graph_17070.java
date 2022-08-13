package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_17070 {
    static int[][] arr;
    static int result = 0;
    static int N;

    //0 가로, 1 세로, 2 대각선
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);
        System.out.println(result);
    }

    static void dfs(int row, int col, int dir) {
        if (row == N - 1 && col == N - 1) {
            result++;
            return;
        }

        if (row + 1 < N && col + 1 < N && arr[row + 1][col + 1] == 0 && arr[row + 1][col] == 0 && arr[row][col + 1] == 0) {
            dfs(row + 1, col + 1, 2);
        }
        if (dir == 0) {
            if (col + 1 < N && arr[row][col + 1] == 0) {
                dfs(row, col + 1, 0);
            }
        }
        if (dir == 1) {
            if (row + 1 < N && arr[row + 1][col] == 0) {
                dfs(row + 1, col, 1);
            }
        }
        if (dir == 2) {
            if (col + 1 < N && arr[row][col + 1] == 0) {
                dfs(row, col + 1, 0);
            }
            if (row + 1 < N && arr[row + 1][col] == 0) {
                dfs(row + 1, col, 1);
            }
        }
    }
}
