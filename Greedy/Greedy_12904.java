package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        find(S, T);
    }

    static void find(String S, String T) {
        if (T.equals(S)) {
            System.out.println(1);
            return;
        }
        if (T.length() < S.length()) {
            System.out.println(0);
            return;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            find(S, T.substring(0, T.length() - 1));
        } else {
            find(S, reverse(T.substring(0, T.length() - 1)));
        }
    }

    static String reverse(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse += str.substring(i, i + 1);
        }
        return reverse;
    }
}
