package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spanning_1197 {
    static class Tree implements Comparable<Tree> {
        int v1, v2, weight;

        Tree(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Tree o) {
            return weight - o.weight;
        }
    }

    static PriorityQueue<Tree> list;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new PriorityQueue<>();
        parent = new int[v + 1];
        for (int i = 1; i <= v; i++)
            parent[i] = i;

        for (int i = 0; i < e; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int w = Integer.parseInt(st2.nextToken());
            list.add(new Tree(start, end, w));
        }

        int res = 0;
        while(!list.isEmpty()) {
            Tree tree = list.poll();
            if (find(tree.v1) != find(tree.v2)) {
                res += tree.weight;
                union(tree.v1, tree.v2);
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
