package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_1707 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    static int V, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            for (int j = 0; j <= V; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            visited = new int[V + 1];
            boolean result = true;
            for (int j = 1; j <= V; j++) {
                if (visited[j] == 0) {
                    result = bfs(j);
                    if (!result) break;
                }
            }
            if (result) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            Integer num = q.poll();

            for (Integer i : list[num]) {
                if (visited[i] == 0) {
                    q.add(i);
                    visited[i] = visited[num] * -1;
                }
                if (visited[i] == visited[num]) {
                    return false;
                }
            }
        }

        return true;
    }
}
