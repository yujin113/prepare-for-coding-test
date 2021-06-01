package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_1238 {
    static class Node implements Comparable<Node> {
        int index, weight;

        Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] list = new ArrayList[n + 1];
        ArrayList<Node>[] revList = new ArrayList[n + 1];
        int[] dis = new int[n + 1];
        int[] revDis = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(revDis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            list[s].add(new Node(e, w));
            revList[e].add(new Node(s, w));
        }

        bfs(list, dis, x);
        bfs(revList, revDis, x);

        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = dis[i] + revDis[i];
        }
        int max = 0;
        for (int i : res) {
            if (i > max)
                max = i;
        }
        System.out.println(max);
    }

    private static void bfs(ArrayList<Node>[] list, int[] dis, int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dis[start] = 0;

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.index]) continue;
            visited[n.index] = true;
            for (Node o : list[n.index]) {
                if (dis[o.index] > o.weight + dis[n.index]) {
                    dis[o.index] = o.weight + dis[n.index];
                    q.add(new Node(o.index, dis[o.index]));
                }
            }
        }

        Arrays.fill(visited, false);
    }
}
