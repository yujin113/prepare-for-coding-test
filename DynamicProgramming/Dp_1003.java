package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_1003 {
    static class Node {
        int zero, one;

        public Node(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        Node[] arr = new Node[41];
        arr[0] = new Node(1, 0);
        arr[1] = new Node(0, 1);
        for (int i = 2; i < 41; i++) {
            int zero = arr[i - 2].zero + arr[i - 1].zero;
            int one = arr[i - 2].one + arr[i - 1].one;
            arr[i] = new Node(zero, one);
        }

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(arr[num].zero).append(" ").append(arr[num].one).append("\n");
        }
        System.out.println(sb);
    }
}
