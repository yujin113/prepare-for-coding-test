package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph_17472 {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Bridge implements Comparable<Bridge> {
		int start;
		int end;
		int length;

		public Bridge(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}

		@Override
		public int compareTo(Bridge o) {
			return this.length - o.length;
		}
	}

	static int[][] map;
	static int[] parent;
	static int N, M;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N][M];
		Queue<Node> island = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 1) {
					island.add(new Node(i, j));
				}
			}
		}

		int count = 1;
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j, visited, count);
					count++;
				}
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < M; j++) {
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		parent = new int[count];
		for (int i = 0; i < count; i++) {
			parent[i] = i;
		}

		Queue<Bridge> bridges = new PriorityQueue<>();
		makeBridge(island, bridges);
		int result = countBridgeLength(bridges);

		if (canConnect()) {
			System.out.println(result);
		} else {
			System.out.println("-1");
		}
	}

	static void makeBridge(Queue<Node> island, Queue<Bridge> bridges) {
		while (!island.isEmpty()) {
			Node node = island.poll();
			int start = map[node.x][node.y];

			for (int i = 0; i < 4; i++) {
				int len = 0;
				int x = node.x;
				int y = node.y;

				while (true) {
					x += move[i][0];
					y += move[i][1];

					if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == start) {
						break;
					}

					if (map[x][y] == 0) {
						len++;
					} else {
						if (len > 1) {
							bridges.add(new Bridge(start, map[x][y], len));
						}
						break;
					}
				}
			}
		}
		// for (Bridge b : bridges) {
		// 	System.out.println(b.start + " " + b.end + " " + b.length);
		// }
	}

	private static int countBridgeLength(Queue<Bridge> bridges) {
		int result = 0;
		while (!bridges.isEmpty()) {
			Bridge bridge = bridges.poll();
			if (union(bridge.start, bridge.end)) {
				result += bridge.length;
			}
		}

		return result;
	}

	static boolean canConnect() {
		int root = find(1);

		for (int i = 2; i < parent.length; i++) {
			if (root != find(i)) {
				return false;
			}
		}
		return true;
	}

	static void bfs(int row, int col, boolean[][] visited, int count) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(row, col));
		visited[row][col] = true;
		map[row][col] = count;

		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int x = node.x + move[i][0];
				int y = node.y + move[i][1];

				if (x >= 0 && y >= 0 && x < N && y < M) {
					if (visited[x][y])
						continue;
					visited[x][y] = true;
					if (map[x][y] == 1) {
						map[x][y] = count;
						q.add(new Node(x, y));
					}
				}
			}
		}
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
			return true;
		}
		return false;
	}

	static int find(int x) {
		if (x == parent[x])
			return x;

		return find(parent[x]);
	}
}
