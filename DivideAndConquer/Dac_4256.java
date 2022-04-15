package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dac_4256 {
    static int[] pre, in;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            pre = new int[n];
            in = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pre[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                in[j] = Integer.parseInt(st.nextToken());
            }
            tree(0, 0, n - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void tree(int root, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (in[i] == pre[root]) {
                tree(root + 1, left, i - 1);
                tree(root + i + 1 - left, i + 1, right);
                sb.append(in[i]).append(" ");
            }
        }
    }
}
