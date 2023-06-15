package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy_2109 {
    static class Node implements Comparable<Node> {
        int p, d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return o.p - this.p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Node> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);

            q.add(new Node(p, d));
        }

        int[] day = new int[10001];
        while (!q.isEmpty()) {
            Node node = q.poll();

            if (day[node.d] == 0) {
                day[node.d] = node.p;
            } else {
                for (int i = node.d; i > 0; i--) {
                    if (day[i] == 0) {
                        day[i] = node.p;
                        break;
                    } else {
                        if (node.p > day[i]) {
                            day[i] = node.p;
                            break;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i : day) {
            result += i;
        }
        System.out.println(result);
    }
}
