package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_2606 {
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());
        int N2 = Integer.parseInt(br.readLine());

        list = new ArrayList[N1 + 1];
        for (int i = 0; i <= N1; i++) {
            list[i] = new ArrayList<>();
        }
        visited = new boolean[N1 + 1];

        for (int i = 0; i < N2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        int count = 0;
        System.out.println(bfs(count));
    }

    private static int bfs(int count) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int num = q.poll();
            visited[num] = true;

            for (Integer n : list[num]) {
                if (visited[n]) continue;
                visited[n] = true;
                count++;
                q.add(n);
            }
        }

        return count;
    }
}
