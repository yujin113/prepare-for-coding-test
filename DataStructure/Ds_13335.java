package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ds_13335 {
    static class Node {
        int num, time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int n = Integer.parseInt(strings[0]); // 트럭 수
        int w = Integer.parseInt(strings[1]); // 다리 길이
        int L = Integer.parseInt(strings[2]); // 다리 최대 하중

        int[] arr = new int[n];
        strings = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strings[i]);
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(arr[0], 1));
        int index = 1;
        int time = 0;
        while (!q.isEmpty()) {
            time++;
//            System.out.println("time = " + time);
//            System.out.println("index = " + index);
//            for (Node no : q) {
//                System.out.print(no.num + "(" + no.time + ") ");
//            }
//            System.out.println();
//            System.out.println();

            addTime(q);
            Node node = q.peek();
            if (node.time > w) {
                q.poll();
            }

            if (index >= n) continue;
            if (q.size() < w) {
                int sum = 0;
                for (Node node2 : q) {
                    sum += node2.num;
                }
                if (sum + arr[index] <= L) {
                    q.add(new Node(arr[index], 1));
                    index++;
                }
            }
        }

        System.out.println(time + 1);
    }

    static void addTime(Queue<Node> q) {
        for (Node node : q) {
            node.time += 1;
        }
    }
}