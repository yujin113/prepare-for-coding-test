package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_1647 {
    static class House implements Comparable<House> {
        int v1, v2, cost;

        public House(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(House o) {
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<House> q;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        q = new PriorityQueue<>();
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st2.nextToken());
            int e = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            q.add(new House(s, e, c));
        }

        int res = 0;
        int num = 0;
        while (!q.isEmpty()) {
            House h = q.poll();
            if (find(h.v1) != find(h.v2)) {
                num++;
                res += h.cost;
                union(h.v1, h.v2);
//                System.out.println(h.v1 + " " + h.v2);
            }
            if (num == n - 2)
                break;
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
        if (x != y)
            parent[y] = x;
    }
}
