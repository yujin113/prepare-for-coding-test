package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_4386 {
    static class Point {
        int num;
        double x, y;

        Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Star implements Comparable<Star> {
        int v1, v2;
        double weight;

        public Star(int v1, int v2, double weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Star o) {
            if (this.weight > o.weight)
                return 1;
            return -1;
        }
    }

    static Point[] arr;
    static int[] parent;
    static PriorityQueue<Star> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new Point[n];
        parent = new int[n + 1];
        q = new PriorityQueue<>();
        for (int i = 0; i <= n; i++)
            parent[i] = i;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i] = new Point(i, x, y);
        }

        for (int i = 0; i < n - 1; i++) {
            Point p1 = arr[i];
            for (int j = i + 1; j < n; j++) {
                Point p2 = arr[j];
                double w = dist(p1, p2);
                q.add(new Star(i, j, w));
            }
        }

        double res = 0;
        while (!q.isEmpty()) {
            Star star = q.poll();
            if (find(star.v1) != find(star.v2)) {
                res += star.weight;
                union(star.v1, star.v2);
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

    private static double dist(Point p1, Point p2) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;

        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
