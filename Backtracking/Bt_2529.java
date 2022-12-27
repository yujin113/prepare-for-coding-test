package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bt_2529 {
    static int k;
    static int[] arr;
    static boolean[] visited = new boolean[10];
    static Character[] sign;
    static Deque<String> res = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[k + 1];
        sign = new Character[k];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            sign[i] = str[i].charAt(0);
        }

        bt(0);

        System.out.println(res.getLast());
        System.out.println(res.getFirst());
    }

    static void bt(int cnt) {
        if (cnt == k + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i);
            }
            res.add(String.valueOf(sb));
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            if (cnt > 0) {
                if (sign[cnt - 1] == '<' && arr[cnt - 1] >= i) continue;
                if (sign[cnt - 1] == '>' && arr[cnt - 1] <= i) continue;
            }
            arr[cnt] = i;
            visited[i] = true;
            bt(cnt + 1);
            visited[i] = false;
        }
    }
}
