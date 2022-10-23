package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ds_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int temp = 1;

        for (int i = 0; i < line.length(); i++) {
            char now = line.charAt(i);

            if (now == '(') {
                stack.push(now);
                temp *= 2;
            } else if (now == '[') {
                stack.push(now);
                temp *= 3;
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (line.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (line.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }

//            System.out.println(now);
//            System.out.println("temp = " + temp);
//            System.out.println("result = " + result);
//            System.out.println();
        }

        if (!stack.isEmpty()) {
            result = 0;
        }
        System.out.println(result);

    }
}
