package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_1753 {
    static class Node implements Comparable<Node> {
        int num, weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int[] distance;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine()); // 시작
        list = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        distance = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        for (int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            list[start].add(new Node(end, w));
        }
        bfs(k);

        for (int i = 1; i <= v; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int k) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(k, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.num]) continue;
            visited[n.num] = true;
            for (Node o : list[n.num]) {
                if (distance[o.num] > o.weight + distance[n.num]) {
                    distance[o.num] = o.weight + distance[n.num];
                    q.add(new Node(o.num, distance[o.num]));
                }
            }
        }
    }
}
