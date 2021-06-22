package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_5972 {
    static class Node implements Comparable<Node> {
        int index, cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] dis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();
        visited = new boolean[N + 1];
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        bfs();

        System.out.println(dis[N]);
    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0));
        dis[1] = 0;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.index]) continue;
            visited[n.index] = true;
            for (Node node : list[n.index]) {
                if (dis[node.index] > dis[n.index] + node.cost) {
                    dis[node.index] = dis[n.index] + node.cost;
                    q.add(new Node(node.index, dis[node.index]));
                }
            }
        }

    }
}
