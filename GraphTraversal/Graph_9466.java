package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Graph_9466 {
    static boolean[] searched, visited;
    static int[] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            searched = new boolean[n + 1];
            visited = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            for (int j = 1; j <= n; j++) {
                dfs(j);
            }
            sb.append(n - result).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int n) {
        if (visited[n]) {
            return;
        }

        visited[n] = true;
        int next = arr[n];
        if (!visited[next]) {
            dfs(next);
        } else {
            if (!searched[next]) {
                result++;
                while (next != n) {
                    next = arr[next];
                    result++;
                }
            }
        }
        searched[n] = true;
    }

}
