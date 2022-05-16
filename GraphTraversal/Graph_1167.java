package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_1167 {
    static class Node {
        int v, len;

        public Node(int v, int len) {
            this.v = v;
            this.len = len;
        }
    }

    static int V, result;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) break;

                list[start].add(new Node(n, Integer.parseInt(st.nextToken())));
            }
        }

        int max = bfs(1);
        bfs(max);

        System.out.println(result);
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[V + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;
        int max_v = 0;
        int max_len = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (max_len < node.len) {
                max_len = node.len;
                max_v = node.v;
            }

            for (Node n : list[node.v]) {
                if (visited[n.v]) continue;
                visited[n.v] = true;
                q.add(new Node(n.v, node.len + n.len));
            }

        }

        result = max_len;
        return max_v;
    }
}
