package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_5014 {
    static class Node {
        int stair, num;

        public Node(int stair, int num) {
            this.stair = stair;
            this.num = num;
        }
    }
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken()); //총높이
        S = Integer.parseInt(st.nextToken());//현재위치
        G = Integer.parseInt(st.nextToken()); //도착위치
        U = Integer.parseInt(st.nextToken()); //위
        D = Integer.parseInt(st.nextToken()); //아래

        int result = bfs();
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(S, 0));
        boolean[] visited = new boolean[F + 1];

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.stair == G) {
                return node.num;
            }

            if (node.stair + U <= F && !visited[node.stair + U]) {
                visited[node.stair + U] = true;
                q.add(new Node(node.stair + U, node.num + 1));
            }
            if (node.stair - D > 0 && !visited[node.stair - D]) {
                visited[node.stair - D] = true;
                q.add(new Node(node.stair - D, node.num + 1));
            }
        }

        return -1;
    }
}
