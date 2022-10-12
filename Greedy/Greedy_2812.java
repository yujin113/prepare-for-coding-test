package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Greedy_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        String num = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(num.substring(i, i + 1));
            while (!stack.isEmpty() && K > 0 && stack.peek() < n) {
                stack.pop();
                K--;
            }
            stack.push(n);
        }
        while (K > 0) {
            stack.pop();
            K--;
        }

        StringBuilder result = new StringBuilder();
        for (Integer i : stack) {
            result.append(i);
        }
        System.out.println(result);
    }
}
