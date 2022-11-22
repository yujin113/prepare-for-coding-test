package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_10775 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int root = findRoot(g);

            if (root == 0) {
                break;
            }
            cnt++;
            union(root, root - 1);
        }
        System.out.println(cnt);
    }

    static int findRoot(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = findRoot(parent[x]);
    }

    static void union(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x != y) {
            parent[x] = y;
        }
    }
}
