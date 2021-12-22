package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Greedy_16953 {
    static class Node {
        long num;
        int count;

        public Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        greedy(A, B);
    }

    private static void greedy(long A, long B) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            long n1 = node.num * 2;
            long n2 = node.num * 10 + 1;

            if (n1 == B || n2 == B) {
                System.out.println(node.count + 2);
                return;
            }

            if (n1 < B) q.add(new Node(n1, node.count + 1));
            if (n2 < B) q.add(new Node(n2, node.count + 1));
        }

        System.out.println("-1");
    }
}
