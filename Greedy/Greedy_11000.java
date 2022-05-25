package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Greedy_11000 {
    static class Node implements Comparable<Node> {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (start == o.start)
                return end - o.end;
            return start - o.start;
        }
    }

    static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        System.out.println(find(N));
    }

    private static int find(int N) {
        Queue<Integer> q = new PriorityQueue<>();
        q.add(arr[0].end);

        for (int i = 1; i < N; i++) {
            if (q.peek() <= arr[i].start) {
                q.poll();
            }
            q.add(arr[i].end);
        }

        return q.size();
    }
}
