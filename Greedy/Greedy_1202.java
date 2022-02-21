package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_1202 {
    static class Node implements Comparable<Node> {
        int m, v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return m - o.m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] bag = new int[K];
        Node[] jewel = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel);
        Arrays.sort(bag);

        long result = 0;
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        for (int i = 0, j = 0; i < bag.length; i++) {
            while (j < N && jewel[j].m <= bag[i]) {
                q.add(jewel[j].v);
                j++;
            }

            if (!q.isEmpty()) {
//                for (Integer integer : q) {
//                    System.out.print(integer + " ");
//                }
//                System.out.println("~~~~~~~~~");
                result += q.poll();
//                System.out.println(result);
            }
        }

        System.out.println(result);
    }
}
