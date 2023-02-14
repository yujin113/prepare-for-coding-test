package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph_4485 {
	static class Node implements Comparable<Node> {
		int x;
		int y;
		int count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public int compareTo(Node o) {
			return this.count - o.count;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		int num = 1;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str[j]);
				}
			}
			int result = bfs(N, arr);
			sb.append("Problem ").append(num).append(": ").append(result).append("\n");
			num++;
		}
		System.out.println(sb);
	}

	static int bfs(int N, int[][] arr) {
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, arr[0][0]));
		boolean[][] visited = new boolean[N][N];
		int[] moveX = {0, 1, 0, -1};
		int[] moveY = {-1, 0, 1, 0};

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.x == N - 1 && node.y == N - 1) {
				return node.count;
			}

			for (int i = 0; i < 4; i++) {
				int x = node.x + moveX[i];
				int y = node.y + moveY[i];

				if (x >= 0 && y >= 0 && x < N && y < N) {
					if (visited[x][y]) continue;
					visited[x][y] = true;
					q.add(new Node(x, y, node.count + arr[x][y]));
				}
			}
		}

		return 0;
	}
}
