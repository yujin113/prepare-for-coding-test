package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ds_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> result = new Stack<>();
        Stack<Character> oper = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char now = line.charAt(i);

            if ((int) now >= 65 && (int) now <= 90) {
                result.push(now);
            } else if (now == '+' || now == '-' || now == '*' || now == '/') {
                while (!oper.isEmpty() && priority(oper.peek()) >= priority(now)) {
                    result.push(oper.pop());
                }
                oper.push(now);
            } else if (now == ')') {
                while (!oper.isEmpty()) {
                    if (oper.peek() == '(') {
                        oper.pop();
                        break;
                    }
                    result.push(oper.pop());
                }
            } else {
                oper.push(now);
            }
        }
        while (!oper.isEmpty()) {
            result.push(oper.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : result) {
            sb.append(c);
        }
        System.out.println(sb);
    }

    static int priority(Character c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }
}
