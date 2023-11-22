package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Greedy_1781 {
    static class Node implements Comparable<Node> {
        int deadline;
        int num;

        public Node(int deadline, int num) {
            this.deadline = deadline;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            if (this.deadline == o.deadline) {
                return o.num - this.num;
            }
            return this.deadline - o.deadline;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = new Node(deadline, num);
        }

        Arrays.sort(arr);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Node node : arr) {
            int deadline = pq.size();

            if (node.deadline > deadline) {
                pq.add(node.num);
            } else {
                Integer peek = pq.peek();
                if (peek < node.num) {
                    pq.poll();
                    pq.add(node.num);
                }
            }
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}
