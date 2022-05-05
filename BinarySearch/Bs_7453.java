package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_7453 {
    static int n;
    static int[] AB, CD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] ABCD = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                ABCD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        AB = new int[n * n];
        CD = new int[n * n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[temp] = ABCD[i][0] + ABCD[j][1];
                CD[temp] = ABCD[i][2] + ABCD[j][3];
                temp++;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);
        System.out.println(bs(0, n * n - 1));
    }

    private static long bs(int ab, int cd) {
        long cnt = 0;
        while (ab < n * n && cd >= 0) {
            long ABsum = AB[ab];
            long CDsum = CD[cd];
            long sum = ABsum + CDsum;

            if (sum > 0) {
                cd--;
            } else if (sum < 0) {
                ab++;
            } else {
                long ABcnt = 0, CDcnt = 0;
                while (ab < n * n && ABsum == AB[ab]) {
                    ab++;
                    ABcnt++;
                }
                while (cd >= 0 && CDsum == CD[cd]) {
                    cd--;
                    CDcnt++;
                }
                cnt += (ABcnt * CDcnt);
            }
        }
        return cnt;
    }
}
