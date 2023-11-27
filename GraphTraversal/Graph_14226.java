package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Graph_14226 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(1, 0, 0));

        boolean[][] visited = new boolean[1001][1001];

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.emoticon][node.clipboard] = true;

            if (node.emoticon == S) {
                System.out.println(node.time);
                break;
            }

            // copy
            if (!visited[node.emoticon][node.emoticon]) {
                q.add(new Node(node.emoticon, node.emoticon, node.time + 1));
            }

            // paste
            if (node.clipboard != 0 && node.emoticon + node.clipboard <= S && !visited[node.emoticon + node.clipboard][node.clipboard]) {
                q.add(new Node(node.emoticon + node.clipboard, node.clipboard, node.time + 1));
            }

            // minus
            if (node.emoticon - 1 > 0 && !visited[node.emoticon - 1][node.clipboard]) {
                q.add(new Node(node.emoticon - 1, node.clipboard, node.time + 1));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int emoticon;
        int clipboard;
        int time;

        public Node(int emoticon, int clipboard, int time) {
            this.emoticon = emoticon;
            this.clipboard = clipboard;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}
