package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_1697 {
    static class Node {
        int num, cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        bfs(N, T);
    }

    private static void bfs(int N, int T) {
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.num == T) {
                System.out.println(node.cnt);
                return;
            }

            if (node.num * 2 >= 0 && node.num * 2 < visited.length && !visited[node.num * 2]) {
                q.add(new Node(node.num * 2, node.cnt + 1));
                visited[node.num * 2] = true;
            }
            if (node.num + 1 >= 0 && node.num + 1 < visited.length && !visited[node.num + 1]) {
                q.add(new Node(node.num + 1, node.cnt + 1));
                visited[node.num + 1] = true;
            }
            if (node.num - 1 >= 0 && node.num - 1 < visited.length && !visited[node.num - 1]) {
                q.add(new Node(node.num - 1, node.cnt + 1));
                visited[node.num - 1] = true;
            }
        }
    }
}
