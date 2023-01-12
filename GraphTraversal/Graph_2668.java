package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph_2668 {
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, i);
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int n, int start) {
        if (arr[n] == start) {
            list.add(n);
            return;
        }

        visited[n] = true;
        if (!visited[arr[n]]) {
            dfs(arr[n], start);
        }
    }
}
