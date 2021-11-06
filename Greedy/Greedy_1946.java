package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_1946 {
    static class Node implements Comparable<Node> {
        int a, b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Node o) {
            return a - o.a;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Node[] arr = new Node[N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[j] = new Node(a, b);
            }

            greedy(arr);
        }

        System.out.println(sb);
    }

    private static void greedy(Node[] arr) {
        int count = 1;
        Arrays.sort(arr);
        Node standard = arr[0];

        for (int i = 1; i < arr.length; i++) {
            Node node = arr[i];

            if (node.b < standard.b) {
                standard = arr[i];
                count++;
            }
        }

        sb.append(count).append("\n");
    }
}
