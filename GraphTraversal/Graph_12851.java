package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph_12851 {
    static class Node implements Comparable<Node> {
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int minTime;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        bfs(N, K);

        System.out.println(minTime);
        System.out.println(count);
    }

    static void bfs(int N, int K) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 0));
        boolean[] visited = new boolean[200001];
        visited[N] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.position == K) {
                minTime = node.time;

                while (!q.isEmpty()) {
                    Node restNode = q.poll();

                    if (restNode.time == minTime && restNode.position == K) {
                        count++;
                    }
                }
            }

            visited[node.position] = true;

            if (node.position * 2 < 100001 && !visited[node.position * 2]) {
                q.add(new Node(node.position * 2, node.time + 1));
            }
            if (node.position - 1 >= 0 && !visited[node.position - 1]) {
                q.add(new Node(node.position - 1, node.time + 1));
            }
            if (node.position + 1 < 100001 && !visited[node.position + 1]) {
                q.add(new Node(node.position + 1, node.time + 1));
            }
        }
    }
}