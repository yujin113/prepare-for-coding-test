package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class backtracking_2661 {

    static boolean end = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = "";
        bt(str, n);
    }

    static boolean test(String str) {
        int len = str.length() / 2;

        for (int i = 1; i <= len; i++) {
            String str1 = str.substring(str.length() - i - i, str.length() - i);
            String str2 = str.substring(str.length() - i, str.length());
            if (str1.equals(str2))
                return false;
        }

        return true;
    }

    static void bt(String str, int n) {
        if (end)
            return;

        if (str.length() == n) {
            System.out.println(str);
            end = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (test(str + i))
                bt(str + i, n);
        }
    }
}
