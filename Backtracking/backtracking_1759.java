package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backtracking_1759 {
    static String[] alpha;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        alpha = new String[c];
        visited = new boolean[c];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            alpha[i] = st2.nextToken();
        }
        Arrays.sort(alpha);
        String res = "";
        bt(l, res, 0);
        System.out.println(sb);
    }

    static void bt(int l, String str, int count) {
        if (count == l) {
            if (test(str))
                sb.append(str).append("\n");
            return;
        }
        for (int i = 0; i < alpha.length; i++) {
            if (count > 0 && str.charAt(count - 1) - '0' > alpha[i].charAt(0) - '0')
                continue;
            if (!visited[i]) {
                visited[i] = true;
                bt(l, str + alpha[i], count + 1);
                visited[i] = false;
            }
        }
    }

    static boolean test(String str) {
        int ja = 0;
        int mo = 0;
        for (int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if (temp.equals("a") || temp.equals("e") || temp.equals("i") || temp.equals("o") || temp.equals("u")) {
                mo++;
            } else ja++;
        }
        return ja > 1 && mo > 0;
    }
}
