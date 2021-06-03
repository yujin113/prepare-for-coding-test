package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_16398 {
    static class Planet implements Comparable<Planet> {
        int v1, v2, cost;

        public Planet(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Planet o) {
            return this.cost - o.cost;
        }
    }

    static PriorityQueue<Planet> q;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        q = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] line = new int[N];
            for (int j = 0; j < N; j++) {
                line[j] = Integer.parseInt(st.nextToken());
                if (j > i)
                    q.add(new Planet(i + 1, j + 1, line[j]));
            }
        }

        long res = 0;
        while (!q.isEmpty()) {
            Planet planet = q.poll();
            if (find(planet.v1) != find(planet.v2)) {
                res += planet.cost;
                union(planet.v1, planet.v2);
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
        if (x != y)
            parent[y] = x;
    }
}
