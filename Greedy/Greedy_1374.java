package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Greedy_1374 {
    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (start > o.start) {
                return 1;
            } else if (start == o.start) {
                return end - o.end;
            }
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split(" ");
            arr[i] = new Node(Integer.parseInt(strings[1]), Integer.parseInt(strings[2]));
        }

        Arrays.sort(arr);

        int result = greedy(N, arr);
        System.out.println(result);
    }

    private static int greedy(int N, Node[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0].end);

        for (int i = 1; i < N; i++) {
            if (arr[i].start >= pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i].end);
        }

        return pq.size();
    }
}
