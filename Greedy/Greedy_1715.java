package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Greedy_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (pq.size() > 1) {
//            for (Integer i : pq) {
//                System.out.print(i + " ");
//            }
//            System.out.println();

            int n1 = pq.poll();
            int n2 = pq.poll();
            result += (n1 + n2);
            pq.add(n1 + n2);
        }

        System.out.println(result);
    }

}
