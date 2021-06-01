package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class backtracking_2239 {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] arr = new int[9][9];
    static ArrayList<Point> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
                if (arr[i][j] == 0)
                    list.add(new Point(i, j));
            }
        }
        bt(0);
    }

    private static void bt(int index) {
        if (index >= list.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        int row = list.get(index).x;
        int col = list.get(index).y;
        for (int i = 1; i <= 9; i++) {
            int temp = arr[row][col];
            if (test(row, col, i)) {
                arr[row][col] = i;
                bt(index + 1);
                arr[row][col] = temp;
            }
        }
    }

    private static boolean test(int row, int col, int n) {
        int r, c;
        if (row >= 0 && row < 3) r = 0;
        else if (row >= 3 && row < 6) r = 3;
        else r = 6;

        if (col >= 0 && col < 3) c = 0;
        else if (col >= 3 && col < 6) c = 3;
        else c = 6;

        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == n)
                return false;
            if (arr[i][col] == n)
                return false;
        }
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (arr[i][j] == n)
                    return false;
            }
        }
        return true;
    }
}
