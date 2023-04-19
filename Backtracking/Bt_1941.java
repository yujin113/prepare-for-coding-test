package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bt_1941 {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[] arr = new int[7];
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new int[5][5];
		for (int i = 0; i < 5; i++) {
			String line = br.readLine();
			for (int j = 0; j < 5; j++) {
				if (line.charAt(j) == 'Y') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}

		dfs(0, 0, 0);

		System.out.println(result);
	}

	private static void dfs(int depth, int start, int sum) {
		if (depth == 7) {
			if (sum >= 4) {
				int[][] path = new int[5][5];
				for (int i : arr) {
					path[i / 5][i % 5] = 1;
				}
				bfs(path, arr[0] / 5, arr[0] % 5);
			}
			return;
		}

		for (int i = start; i < 25; i++) {
			arr[depth] = i;
			dfs(depth + 1, i + 1, sum + map[i / 5][i % 5]);
		}
	}

	private static void bfs(int[][] path, int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		boolean[][] visited = new boolean[5][5];
		visited[x][y] = true;

		int count = 1;
		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = node.x + move[i][0];
				int dy = node.y + move[i][1];

				if (dx >= 0 && dy >= 0 && dx < 5 && dy < 5 && !visited[dx][dy] && path[dx][dy] == 1) {
					visited[dx][dy] = true;
					count++;
					q.add(new Node(dx, dy));
				}
			}
		}

		if (count == 7) {
			result++;
		}
	}
}
