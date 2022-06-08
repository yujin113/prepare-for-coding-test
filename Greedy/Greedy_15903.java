package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Greedy_15903 {
    static Queue<Long> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            q.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            addCard();
        }

        long result = 0;
        for (long i : q) {
            result += i;
        }
        System.out.println(result);
    }

    private static void addCard() {
        long sum = q.poll() + q.poll();
        q.add(sum);
        q.add(sum);
    }
}
