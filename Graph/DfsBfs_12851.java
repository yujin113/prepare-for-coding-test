package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DfsBfs_12851 {
    static class Node implements Comparable<Node> {
        int num, second;

        public Node(int num, int second) {
            this.num = num;
            this.second = second;
        }

        @Override
        public int compareTo(Node o) {
            return second - o.second;
        }
    }

    static int N, K;
    static int time, res = 1;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[200001];

        bfs();

        System.out.println(time);
        System.out.println(res);
    }

    private static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.num == K) {
                time = n.second;
                while (!q.isEmpty()) {
                    Node node = q.poll();
                    if (node.second != time)
                        break;

//                    System.out.println(node.num);
                    if (node.num == K)
                        res++;
                }
                return;
            }

            visited[n.num] = true;

            if (2 * n.num <= 100000 && !visited[2 * n.num])
                q.add(new Node(2 * n.num, n.second + 1));
            if (n.num + 1 <= 100000 && !visited[n.num + 1])
                q.add(new Node(n.num + 1, n.second + 1));
            if (n.num - 1 >= 0 && !visited[n.num - 1])
                q.add(new Node(n.num - 1, n.second + 1));
        }
    }

}
