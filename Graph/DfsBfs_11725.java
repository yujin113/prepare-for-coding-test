package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DfsBfs_11725 {
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <=n; i++) list[i] = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int num) {
        visited[num] = true;

        for (int i : list[num]) {
            if (!visited[i]) {
                parent[i] = num;
                dfs(i);
            }
        }
    }


}