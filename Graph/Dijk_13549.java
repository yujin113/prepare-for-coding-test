package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_13549 {
    static class Node implements Comparable<Node> {
        int num, second;

        public Node(int num, int second) {
            this.num = num;
            this.second = second;
        }

        @Override
        public int compareTo(Node o) {
            return second - o.second;
        }
    }

    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[200001];

        System.out.println(func());
    }

    private static int func() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();

            visited[n.num] = true;

            if (n.num == K) {
                return n.second;
            }

            if (2 * n.num <= 100000 && !visited[2 * n.num])
                q.add(new Node(2 * n.num, n.second));
            if (n.num + 1 <= 100000 && !visited[n.num + 1])
                q.add(new Node(n.num + 1, n.second + 1));
            if (n.num - 1 >= 0 && !visited[n.num - 1])
                q.add(new Node(n.num - 1, n.second + 1));
        }

        return 0;
    }
}