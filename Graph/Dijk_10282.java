package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijk_10282 {
    static class Computer implements Comparable<Computer> {
        int num, second;

        public Computer(int num, int second) {
            this.num = num;
            this.second = second;
        }

        @Override
        public int compareTo(Computer o) {
            return this.second - o.second;
        }
    }

    static ArrayList<Computer>[] list;
    static boolean[] visited;
    static int[] time;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            for (int j = 0; j <= n; j++)
                list[j] = new ArrayList<>();
            time = new int[n + 1];
            visited = new boolean[n + 1];
            Arrays.fill(time, Integer.MAX_VALUE);

            for (int j = 0; j < d; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                int s = Integer.parseInt(st2.nextToken());
                list[b].add(new Computer(a, s));
            }

            bfs(c);
        }
        System.out.println(sb);
    }

    private static void bfs(int c) {
        PriorityQueue<Computer> q = new PriorityQueue<>();
        q.add(new Computer(c, 0));
        time[c] = 0;

        while (!q.isEmpty()) {
            Computer com = q.poll();

            if (visited[com.num])
                continue;
            visited[com.num] = true;

            for (Computer o : list[com.num]) {
                if (time[o.num] > time[com.num] + o.second) {
                    time[o.num] = time[com.num] + o.second;
                    q.add(new Computer(o.num, time[o.num]));
                }
            }
        }

        int max = 0;
        int n = 0;
        for (int i = 1; i < time.length; i++) {
            if (time[i] != Integer.MAX_VALUE) {
                n++;
                max = Integer.max(max, time[i]);
            }
        }
        sb.append(n).append(" ").append(max).append("\n");

    }
}
