package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_1504 {
    static class Node implements Comparable<Node> {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static ArrayList<Node>[] list;
    static int[] dis;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        dis = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            list[start].add(new Node(end, w));
            list[end].add(new Node(start, w));
        }
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st3.nextToken());
        int v2 = Integer.parseInt(st3.nextToken());

        int res = 0;
        int res2 = 0;
        bfs(1);
        res += dis[v1];
        res2 += dis[v2];
        bfs(v1);
        res += dis[v2];
        bfs(v2);
        res += dis[n];
        res2 += dis[v1];
        bfs(v1);
        res2 += dis[n];

        if (dis[v2] == Integer.MAX_VALUE || dis[v1] == Integer.MAX_VALUE || dis[n] == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(Integer.min(res, res2));
    }

    public static void bfs(int start) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dis[start] = 0;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.idx]) continue;
            visited[n.idx] = true;
            for (Node o : list[n.idx]) {
                if (dis[o.idx] > o.weight + dis[n.idx]) {
                    dis[o.idx] = o.weight + dis[n.idx];
                    q.add(new Node(o.idx, dis[o.idx]));
                }
            }
        }

        Arrays.fill(visited, false);
    }
}
