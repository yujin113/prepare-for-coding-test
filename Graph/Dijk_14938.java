package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dijk_14938 {
    static class Node implements Comparable<Node>{
        int num, length;

        public Node(int num, int length) {
            this.num = num;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return length - o.length;
        }
    }

    static int[] item, distance;
    static boolean[] visited;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        item = new int[n + 1];
        distance = new int[n + 1];
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i + 1] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 0; i < r; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st3.nextToken());
            int b = Integer.parseInt(st3.nextToken());
            int l = Integer.parseInt(st3.nextToken());
            list[a].add(new Node(b, l));
            list[b].add(new Node(a, l));
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Integer.max(bfs(i, m), max);
        }

        System.out.println(max);
    }

    private static int bfs(int start, int m) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        Arrays.fill(visited, false);
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        int res = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (visited[node.num]) continue;
            visited[node.num] = true;

            for (Node n : list[node.num]) {
                if (distance[n.num] > distance[node.num] + n.length) {
                    distance[n.num] = distance[node.num] + n.length;
                    q.add(new Node(n.num, distance[n.num]));
                }
            }

        }
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= m)
                res += item[i];
        }

        return res;
    }
}
