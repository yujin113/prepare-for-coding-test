package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backtracking_1987 {
    static int[][] arr;
    static int count = 1, res_count = 1;
    static int[] num = new int[43]; // 17~42
    static int[] moveX = {0, 1, 0, -1};
    static int[] moveY = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        num[arr[0][0]] = 1;
        dfs(0, 0, r, c);
        System.out.println(res_count);
    }

    private static void dfs(int row, int col, int r, int c) {

        num[arr[row][col]] = 1;

        for (int i = 0; i < 4; i++) {
            int x = row + moveX[i];
            int y = col + moveY[i];
            if (x >= 0 && y >= 0 && x < r && y < c) {
                if (num[arr[x][y]] == 0) {
                    count++;
//                    System.out.println(x + " " + y + "  !" + count);
                    res_count = Math.max(count, res_count);

                    dfs(x, y, r, c);

                    count--;
                }
            }
        }

        num[arr[row][col]] = 0;

    }
}
