package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_2644 {
    static class Node {
        int num, count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            list[n1].add(n2);
            list[n2].add(n1);
        }

        System.out.println(bfs(p1, p2));
    }

    private static int bfs(int p1, int p2) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(p1, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.num] = true;

            if (node.num == p2) {
                return node.count;
            }

            for (int i : list[node.num]) {
                if (visited[i]) continue;
                q.add(new Node(i, node.count + 1));
            }
        }

        return -1;
    }
}
