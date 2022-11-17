package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]); // 책 개수
        int M = Integer.parseInt(str1[1]); // 한 번에 들 수 있는 책 개수

        String[] str2 = br.readLine().split(" ");
        Queue<Integer> minus = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(str2[i]);
            if (temp > 0) plus.add(temp);
            if (temp < 0) minus.add(Math.abs(temp));
        }

        int max = 0;

        if (plus.isEmpty()) {
            max = minus.peek();
        } else if (minus.isEmpty()) {
            max = plus.peek();
        } else {
            max = Math.max(minus.peek(), plus.peek());
        }

        int result = 0;

        while (!plus.isEmpty()) {
            result += (plus.poll() * 2);
            for (int i = 0; i < M - 1; i++) {
                if (!plus.isEmpty()) {
                    plus.poll();
                }
            }
        }
        while (!minus.isEmpty()) {
            result += (minus.poll() * 2);
            for (int i = 0; i < M - 1; i++) {
                if (!minus.isEmpty()) {
                    minus.poll();
                }
            }
        }

        System.out.println(result - max);
    }
}
