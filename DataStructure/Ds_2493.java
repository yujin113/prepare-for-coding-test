package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ds_2493 {
    static class Node {
        int index, num;

        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(str[i]);
            while (!stack.isEmpty()) {
                Node node = stack.peek();
                if (node.num >= num) {
                    sb.append(node.index).append(" ");
                    break;
                } else {
                    stack.pop();
                }
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new Node(i + 1, num));
        }

        System.out.println(sb);
    }
}