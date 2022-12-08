package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_9205 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Node home, festival;
    static Node[] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new Node[n];

            for (int j = 0; j < n + 2; j++) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);
                if (j == 0) {
                    home = new Node(x, y);
                } else if (j == n + 1) {
                    festival = new Node(x, y);
                } else {
                    arr[j - 1] = new Node(x, y);
                }
            }

            if (bfs(home, festival)) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }

        }
        System.out.println(sb);
    }

    static boolean bfs(Node start, Node end) {
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (Math.abs(end.x - node.x) + Math.abs(end.y - node.y) <= 1000) {
                return true;
            }

            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) continue;

                if (Math.abs(arr[i].x - node.x) + Math.abs(arr[i].y - node.y) <= 1000) {
                    q.add(new Node(arr[i].x, arr[i].y));
                    visited[i] = true;
                }
            }
        }

        return false;
    }
}
