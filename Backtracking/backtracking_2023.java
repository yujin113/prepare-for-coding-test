package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backtracking_2023 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = "";
        bt(n, str);
        System.out.println(sb);
    }

    static void bt(int n, String str) {
        if (str.length() == n) {
            sb.append(str).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (i == 1 && str.length() == 0 || i == 4 || i == 6 || i == 8)
                continue;
            if (test(n, str + i)) {
                bt(n, str + i);
            }
        }
    }

    static boolean test(int n, String str) {
        int num = Integer.parseInt(str);
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0)
                return false;
        }
        return true; // 소수
    }
}
