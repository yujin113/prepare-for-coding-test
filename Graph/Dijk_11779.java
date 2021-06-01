package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dijk_11779 {
    static class Node implements Comparable<Node> {
        int num, weight;

        Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight; // 오름차순
        }
    }

    static ArrayList<Node>[] list;
    static int[] city;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        city = new int[n + 1];
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e, w));
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st2.nextToken());
        int end = Integer.parseInt(st2.nextToken());
        distance[start] = 0;

        bfs(start);

        sb.append(distance[end]).append("\n");
        Stack<Integer> st = new Stack<>();
        st.push(end);
        while (city[end] != 0) {
            st.push(city[end]);
            end = city[end];
        }
        sb.append(st.size()).append("\n");
        while (!st.isEmpty()) {
            sb.append(st.pop()).append(" ");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (visited[n.num]) continue;
            visited[n.num] = true;
            for (Node o : list[n.num]) {
                if (distance[o.num] > o.weight + distance[n.num]) {
                    distance[o.num] = o.weight + distance[n.num];
                    city[o.num] = n.num;
                    q.add(new Node(o.num, distance[o.num]));
                }
            }
        }
    }
}
