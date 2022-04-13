package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_13549 {
    static class Node implements Comparable<Node> {
        int pos, time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            visited[node.pos] = true;

            if (node.pos == K) {
                return node.time;
            }

            if (node.pos * 2 <= 100000 && !visited[node.pos * 2]) {
                q.add(new Node(node.pos * 2, node.time));
            }
            if (node.pos + 1 <= 100000 && !visited[node.pos + 1]) {
                q.add(new Node(node.pos + 1, node.time + 1));
            }
            if (node.pos - 1 >= 0 && !visited[node.pos - 1]) {
                q.add(new Node(node.pos - 1, node.time + 1));
            }
        }

        return 0;
    }
}
