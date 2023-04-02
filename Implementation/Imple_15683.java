package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Imple_15683 {
	static class Node {
		int x, y;
		int cctv;

		public Node(int x, int y, int cctv) {
			this.x = x;
			this.y = y;
			this.cctv = cctv;
		}
	}

	static int[][] map;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상하좌우
	static int N, M;
	static int result = Integer.MAX_VALUE;
	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] != 0 && map[i][j] != 6) {
					list.add(new Node(i, j, map[i][j]));
				}
			}
		}

		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int depth) {
		if (depth == list.size()) {
			result = Math.min(result, search());
			return;
		}

		int[][] backup = new int[N][M];
		for (int i = 0; i < N; i++) {
			backup[i] = Arrays.copyOf(map[i], M);
		}

		Node node = list.get(depth);
		for (int i = 0; i < 4; i++) {
			if (node.cctv == 1) {
				watch(node.x, node.y, i);
				dfs(depth + 1);
			} else if (node.cctv == 2) {
				if (i == 3)
					break;
				watch(node.x, node.y, i);
				watch(node.x, node.y, (i + 2) % 4);
				dfs(depth + 1);
			} else if (node.cctv == 3) {
				watch(node.x, node.y, i);
				watch(node.x, node.y, (i + 1) % 4);
				dfs(depth + 1);
			} else if (node.cctv == 4) {
				watch(node.x, node.y, i);
				watch(node.x, node.y, (i + 1) % 4);
				watch(node.x, node.y, (i + 2) % 4);
				dfs(depth + 1);
			} else if (node.cctv == 5) {
				if (i == 2)
					break;
				watch(node.x, node.y, 0);
				watch(node.x, node.y, 1);
				watch(node.x, node.y, 2);
				watch(node.x, node.y, 3);
				dfs(depth + 1);
			}

			for (int j = 0; j < N; j++) {
				map[j] = Arrays.copyOf(backup[j], M);
			}
		}
	}

	private static int search() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	private static void watch(int row, int col, int direction) {
		while (true) {
			row += move[direction][0];
			col += move[direction][1];

			if (row < 0 || col < 0 || row >= N || col >= M || map[row][col] == 6) {
				return;
			}

			if (map[row][col] == 0) {
				map[row][col] = -1;
			}
		}
	}
}
