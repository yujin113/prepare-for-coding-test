package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_10423 {
    static class Node implements Comparable<Node> {
        int v1, v2, weight;

        public Node(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static ArrayList<Integer> power;
    static int[] parent;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //도시
        int M = Integer.parseInt(st.nextToken()); //케이블
        int K = Integer.parseInt(st.nextToken()); //발전소

        power = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            power.add(Integer.parseInt(st.nextToken()));
        }
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        q = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            q.add(new Node(u, v, w));
        }

        int res = 0;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (find(n.v1) != find(n.v2)) {
                if (power.contains(find(n.v1)) && power.contains(find(n.v2))) continue;
                res += n.weight;
                union(n.v1, n.v2);
            }
        }

        System.out.println(res);
    }

    private static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (power.contains(x))
                parent[y] = x;
            if (power.contains(y))
                parent[x] = y;
            if (!power.contains(x) && !power.contains(y))
                parent[y] = x;
        }
    }
}
