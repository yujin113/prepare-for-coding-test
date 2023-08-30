package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_2141 {
    static class Node implements Comparable<Node> {
        int pos;
        int num;

        public Node(int pos, int num) {
            this.pos = pos;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            if (this.pos == o.pos) {
                return this.num - o.num;
            }
            return this.pos - o.pos;
        }
    }

    static Node[] arr;
    static int N;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sum += arr[i].num;
        }

        Arrays.sort(arr);

        long temp = 0;
        int result = 0;
        for (Node node : arr) {
            temp += node.num;

            if (temp >= (sum + 1) / 2) {
                result = node.pos;
                break;
            }
        }

        System.out.println(result);
    }
}