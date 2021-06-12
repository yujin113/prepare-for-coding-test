package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_2887 {
    static class Planet {
        int x, y, z, num;

        public Planet(int x, int y, int z, int num) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }

    static class Node implements Comparable<Node> {
        int v1, v2, cost;

        public Node(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static Planet[] planet;
    static int[] parent;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        planet = new Planet[N];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planet[i] = new Planet(x, y, z, i + 1);
        }

        // x, y, z 별로 오름차순 한 후 큐에 넣기
        Arrays.sort(planet, ((o1, o2) -> o1.x - o2.x));
        for (int i = 0; i < N - 1; i++)
            q.add(new Node(planet[i].num, planet[i + 1].num, Math.abs(planet[i].x - planet[i + 1].x)));
        Arrays.sort(planet, ((o1, o2) -> o1.y - o2.y));
        for (int i = 0; i < N - 1; i++)
            q.add(new Node(planet[i].num, planet[i + 1].num, Math.abs(planet[i].y - planet[i + 1].y)));
        Arrays.sort(planet, ((o1, o2) -> o1.z - o2.z));
        for (int i = 0; i < N - 1; i++)
            q.add(new Node(planet[i].num, planet[i + 1].num, Math.abs(planet[i].z - planet[i + 1].z)));

        int res = 0;
        while(!q.isEmpty()) {
            Node n = q.poll();

            if (find(n.v1) != find(n.v2)) {
                union(n.v1, n.v2);
                res += n.cost;
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
