package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recursion_11729 {

    static StringBuilder sb = new StringBuilder();
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        move(n, 1, 2, 3);
        System.out.println(res);
        System.out.println(sb);
    }

    public static void move(int n, int start, int mid, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            res++;
            return;
        }

        move(n - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        res++;
        move(n - 1, mid, start, end);
    }
}
