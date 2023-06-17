package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ds_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= boom.length()) {
                boolean flag = true;

                for (int j = 0; j < boom.length(); j++) {
                    char char1 = stack.get(stack.size() - boom.length() + j);
                    char char2 = boom.charAt(j);
                    if (char1 != char2) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = 0; j < boom.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Character c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
