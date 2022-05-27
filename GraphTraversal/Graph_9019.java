package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_9019 {
    static class Node {
        int num;
        String result;

        public Node(int num, String result) {
            this.num = num;
            this.result = result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            String result = bfs(new Node(A, ""), new Node(B, ""));
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static String bfs(Node nodeA, Node nodeB) {
        Queue<Node> q = new LinkedList<>();
        q.add(nodeA);
        boolean[] visited = new boolean[10000];

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.num == nodeB.num) {
                return node.result;
            }

            //D
            int D = (node.num * 2) % 10000;
            if (!visited[D]) {
                q.add(new Node(D, node.result + "D"));
                visited[D] = true;
            }

            //S
            int S;
            if (node.num == 0) {
                S = 9999;
            } else {
                S = node.num - 1;
            }
            if (!visited[S]) {
                q.add(new Node(S, node.result + "S"));
                visited[S] = true;
            }

            //L
            int L = (node.num % 1000) * 10 + (node.num / 1000);
            if (!visited[L]) {
                q.add(new Node(L, node.result + "L"));
                visited[L] = true;
            }

            //R
            int R = (node.num % 10) * 1000 + (node.num / 10);
            if (!visited[R]) {
                q.add(new Node(R, node.result + "R"));
                visited[R] = true;
            }
        }

        return null;
    }
}
