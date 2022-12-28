package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph_13913 {
    static class Node {
        int pos, time;
        Node node;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        Node result = bfs(N, k);
        System.out.println(result.time);

        Stack<Integer> stack = new Stack<>();
        while (result.node != null) {
            stack.add(result.pos);
            result = result.node;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(N);
        while (!stack.isEmpty()) {
            sb.append(" ").append(stack.pop());
        }
        System.out.println(sb);
    }

    static Node bfs(int N, int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));
        boolean[] visited = new boolean[100001];

        while (!q.isEmpty()) {
            Node node = q.poll();


            if (node.pos == k) {
                return node;
            }

            if (node.pos * 2 <= 100000 && !visited[node.pos * 2]) {
                visited[node.pos] = true;
                Node newNode = new Node(node.pos * 2, node.time + 1);
                newNode.node = node;
                q.add(newNode);
            }
            if (node.pos + 1 <= 100000 && !visited[node.pos + 1]) {
                visited[node.pos] = true;
                Node newNode = new Node(node.pos + 1, node.time + 1);
                newNode.node = node;
                q.add(newNode);
            }
            if (node.pos - 1 >= 0 && node.pos - 1 <= 100000 && !visited[node.pos - 1]) {
                visited[node.pos] = true;
                Node newNode = new Node(node.pos - 1, node.time + 1);
                newNode.node = node;
                q.add(newNode);
            }
        }

        return null;
    }
}
