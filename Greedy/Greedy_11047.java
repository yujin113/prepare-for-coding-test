package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_11047 {
    static int count = 0;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= K) {
                stack.add(num);
            }
        }
        calc(stack.pop(), K);
        System.out.println(count);
    }

    private static void calc(int num, int K) {
//        System.out.println(num + " " + K);
//        count += (K / num);
//        K %= num;
//        if (K == 0)
//            return;
//        if (stack.size() > 0)
//            calc(stack.pop(), K);
        while (K > 0) {
            count += (K / num);
            K %= num;
            if (stack.size() > 0)
                num = stack.pop();
        }
    }
}
