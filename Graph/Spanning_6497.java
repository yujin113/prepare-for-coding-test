package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_6497 {
    static class House implements Comparable<House> {
        int v1, v2, meter;

        public House(int v1, int v2, int meter) {
            this.v1 = v1;
            this.v2 = v2;
            this.meter = meter;
        }

        @Override
        public int compareTo(House o) {
            return this.meter - o.meter;
        }
    }

    static int[] parent;
    static PriorityQueue<House> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            parent = new int[m + 1];
            q = new PriorityQueue<>();
            for (int i = 1; i <= m; i++)
                parent[i] = i;

            int total = 0;
            for (int i = 0; i < n; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st2.nextToken());
                int end = Integer.parseInt(st2.nextToken());
                int meter = Integer.parseInt(st2.nextToken());
                total += meter;
                q.add(new House(start, end, meter));
            }

            int res = 0;
            while (!q.isEmpty()) {
                House house = q.poll();
                if (find(house.v1) != find(house.v2)) {
                    res += house.meter;
                    union(house.v1, house.v2);
                }
            }

            sb.append(total - res).append("\n");
        }
        System.out.println(sb);
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
