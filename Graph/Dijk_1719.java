package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dijk_1719 {
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
    static int[] dis;
    static int[] place;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dis = new int[n + 1];
        place = new int[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }
        for (int i = 1; i <= n; i++)
            bfs(i, n);

        System.out.println(sb);
    }

    private static void bfs(int start, int k) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.num]) continue;
            visited[n.num] = true;
            for (Node o : list[n.num]) {
                if (dis[o.num] > o.weight + dis[n.num]) {
                    dis[o.num] = o.weight + dis[n.num];
                    place[o.num] = n.num;
                    q.add(new Node(o.num, dis[o.num]));
                }
            }
        }

        for (int i = 1; i <= k; i++) {
            int end = i;
            if (end == start) {
                sb.append("- ");
                continue;
            }
            while (place[end] != start) {
                end = place[end];
            }
            sb.append(end).append(" ");
        }
        sb.append("\n");
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(place, 0);
        Arrays.fill(visited, false);
    }
}
