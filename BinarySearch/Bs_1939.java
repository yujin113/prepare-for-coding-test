package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bs_1939 {
    static class Node {
        int n, weight;

        public Node(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }
    }

    static int start, end, N, M;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
            max = Math.max(max, C);
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        bs(1, max);
    }

    private static void bs(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (bfs(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }

    private static boolean bfs(int mid) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;

        while (!q.isEmpty()) {
            Integer num = q.poll();
            if (num == end) {
                return true;
            }

            for (Node node : list[num]) {
                if (!visited[node.n] && node.weight >= mid) {
                    q.add(node.n);
                    visited[node.n] = true;
                }
            }
        }

        return false;
    }
}
