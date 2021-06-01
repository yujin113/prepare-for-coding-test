package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Spanning_1922 {
    static class Computer implements Comparable<Computer> {
        int a, b, cost;

        Computer(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Computer o) {
            return cost - o.cost;
        }
    }

    static ArrayList<Computer> list;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Computer(a, b, c));
        }

        Collections.sort(list); // 가중치 기준으로 오름차순 정렬

        int res = 0;

        for (int i = 0; i < list.size(); i++) {
            Computer com = list.get(i);

            if (find(com.a) != find(com.b)) {
                res += com.cost;
                union(com.a, com.b);
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
            parent[y] = x;
        }
    }

}
