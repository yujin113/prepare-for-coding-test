package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_1774 {
    static class Space {
        int x, y, num;

        public Space(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static class Node implements Comparable<Node> {
        int v1, v2;
        double length;

        public Node(int v1, int v2, double length) {
            this.v1 = v1;
            this.v2 = v2;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            if (this.length > o.length)
                return 1;
            return -1;
        }
    }

    static Space[] arr;
    static int[] parent;
    static PriorityQueue<Node> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new Space[N];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        q = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Space(x, y, i + 1);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            union(v1, v2);
        }

        for (int i = 0; i < N - 1; i++) {
            Space s1 = arr[i];
            for (int j = i + 1; j < N; j++) {
                Space s2 = arr[j];
                double dis = distance(s1, s2);
                q.add(new Node(s1.num, s2.num, dis));
            }
        }

        double res = 0;
        while (!q.isEmpty()) {
            Node n = q.poll();
            if (find(n.v1) != find(n.v2)) {
                res += n.length;
                union(n.v1, n.v2);
            }
        }

        System.out.println(String.format("%.2f", res));
    }

    private static double distance(Space s1, Space s2) {
        return Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));
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
