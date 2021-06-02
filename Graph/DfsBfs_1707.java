package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class DfsBfs_1707 {
    static ArrayList<Integer>[] list;
    static int[] visited;
    static String res;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list = new ArrayList[v + 1];
            for (int j = 1; j <= v; j++)
                list[j] = new ArrayList<>();
            visited = new int[v + 1];

            for (int j = 0; j < e; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st2.nextToken());
                int v2 = Integer.parseInt(st2.nextToken());
                list[v1].add(v2);
                list[v2].add(v1);
            }

            res = "YES";
            for (int j = 1; j <= v; j++) {
                if (visited[j] == 0)
                    if (!bfs(j)) break;
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (Integer i : list[v]) {
                if (visited[i] == 0) {
                    visited[i] = visited[v] * -1;
                    q.add(i);
                }
                if (visited[i] == visited[v]) {
                    res = "NO";
                    return false;
                }
            }

        }

        return true;
    }
}
