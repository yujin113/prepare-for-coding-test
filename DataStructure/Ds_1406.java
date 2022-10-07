package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ds_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            left.push(line.substring(i, i + 1));
        }
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] command = br.readLine().split(" ");

            if (command.length == 1) {
                switch (command[0]) {
                    case "L":
                        if (left.size() != 0) {
                            right.push(left.pop());
                        }
                        break;
                    case "D":
                        if (right.size() != 0) {
                            left.push(right.pop());
                        }
                        break;
                    case "B":
                        if (left.size() == 0) continue;
                        left.pop();
                        break;
                }
            } else {
                String word = command[1];
                left.push(word);
            }

        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        StringBuilder result = new StringBuilder();
        while (!right.isEmpty()) {
            result.append(right.pop());
        }
        System.out.println(result);
    }
}