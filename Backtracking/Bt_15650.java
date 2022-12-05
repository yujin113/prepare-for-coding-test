package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bt_15650 {
    static int N, M;
    static StringBuilder sb;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        sb = new StringBuilder();
        arr = new int[M];

        bt(0);
        System.out.println(sb);
    }

    static void bt(int cnt) {
        if (cnt == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (cnt > 0 && arr[cnt - 1] >= i) continue;
            arr[cnt] = i;
            bt(cnt + 1);
        }
    }
}
