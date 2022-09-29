package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_13904 {
    static class Node implements Comparable<Node> {
        int day, score;

        public Node(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return o.score - score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        int[] result = new int[1001];
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");
            arr[i] = new Node(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int day = arr[i].day;
            for (int j = day; j > 0; j--) {
                if (result[j] == 0) {
                    result[j] = arr[i].score;
                    break;
                }
            }
        }
        int sum = 0;
        for (int i : result) {
            sum += i;
        }

        System.out.println(sum);
    }
}
