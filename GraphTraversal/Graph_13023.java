package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Graph_13023 {
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            arr[a].add(b);
            arr[b].add(a);
        }

        result = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            if (result == 0) {
                dfs(i, 0);
            }
        }

        System.out.println(result);
    }

    static void dfs(int index, int depth) {
        if (depth == 4) {
            result = 1;
            return;
        }

        visited[index] = true;
        for (Integer i : arr[index]) {
            if (visited[i]) continue;
            dfs(i, depth + 1);
        }
        visited[index] = false;
    }
}
