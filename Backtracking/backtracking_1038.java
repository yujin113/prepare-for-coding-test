package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class backtracking_1038 {
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 9; i++) {
            bt(i);
        }

        Collections.sort(list);
        if (n >= list.size())
            System.out.println("-1");
        else System.out.println(list.get(n));
    }

    private static void bt(long num) {

        list.add(num);
//        System.out.println(num);

        for (int i = 0; i <= 9; i++) {
            if (num % 10 > i) {
                bt(num * 10 + i);
            }
        }
    }
}
