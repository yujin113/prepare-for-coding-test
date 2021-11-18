package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dac_1074 {
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dac(N, 0, 0, 0);

    }

    private static void dac(int n, int row, int col, int count) {
        if (n == 2) {
            for (int i = row; i < row + n; i++) {
                for (int j = col; j < col + n; j++) {
                    if (i == r && j == c) {
                        System.out.println(count);
                        return;
                    }
                    count++;
                }
            }
        }

        if (r < row + n / 2 && c < col + n / 2) {
            dac(n / 2, row, col, count);
        }
        if (r < row + n / 2 && c >= col + n / 2) {
            dac(n / 2, row, col + n / 2, count + (n / 2) * (n / 2));
        }
        if (r >= row + n / 2 && c < col + n / 2) {
            dac(n / 2, row + n / 2, col, count + (n / 2) * (n / 2) * 2);
        }
        if (r >= row + n / 2 && c >= col + n / 2) {
            dac(n / 2, row + n / 2, col + n / 2, count + (n / 2) * (n / 2) * 3);
        }
    }
}