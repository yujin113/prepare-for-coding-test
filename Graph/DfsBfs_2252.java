package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs_2252 {
    static ArrayList<Integer>[] list;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        indegree = new int[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st2.nextToken());
            int back = Integer.parseInt(st2.nextToken());
            list[front].add(back);
            indegree[back]++;
        }
        sort(n);
        System.out.println(sb);
    }

    private static void sort(int n) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            result.add(temp);

            for (int i = 0; i < list[temp].size(); i++) {
                int temp2 = list[temp].get(i);
                indegree[temp2]--;

                if (indegree[temp2] == 0) {
                    q.add(temp2);
                }
            }
        }

        while (!result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }
    }
}
