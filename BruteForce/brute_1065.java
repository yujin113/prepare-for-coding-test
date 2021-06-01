package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class brute_1065 {
    static int n, res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i < 10; i++) {
            func(String.valueOf(i));
        }

        System.out.println(res);
    }

    private static void func(String num) {
        if (n < Integer.parseInt(num)) {
            return;
        } else res++;
//        System.out.print(num + " ");

        for (int i = 0; i < 10; i++) {
            if (check(num + i)) {
//                System.out.println(num + i);
                func(num + i);
            }
        }
    }

    private static boolean check(String num) {
        int len = num.length();
        int gap = 0;

        if (len > 2) {
            gap = (num.charAt(1) - '0') - (num.charAt(0) - '0');

            for (int i = 0; i < len - 1; i++) {
                int a = num.charAt(i) - '0';
                int b = num.charAt(i + 1) - '0';
                if ((b - a) != gap)
                    return false;
            }
        }

        return true;
    }
}
