package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bt_18428 {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] map;
	static int[] arr;
	static int N;
	static List<Node> teachers;
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		teachers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = str[j].charAt(0);
				if (map[i][j] == 'T') {
					teachers.add(new Node(i, j));
				}
			}
		}
		arr = new int[3];
		result = false;

		backtracking(0);
		if (result) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	static void backtracking(int depth) {
		if (depth == 3) {
			Node[] nodes = new Node[3];
			for (int i = 0; i < 3; i++) {
				int x = arr[i] / N;
				int y = arr[i] % N;
				nodes[i] = new Node(x, y);
			}
			if (bfs(nodes)) {
				result = true;
			}
			return;
		}

		for (int i = 0; i < N * N; i++) {
			if (depth > 0 && arr[depth - 1] >= i)
				continue;
			if (checkedX(i)) {
				arr[depth] = i;
				backtracking(depth + 1);
			}
		}
	}

	static boolean bfs(Node[] nodes) {
		int[] moveX = {0, 1, 0, -1};
		int[] moveY = {1, 0, -1, 0};
		char[][] copyMap = copyMap();
		for (int i = 0; i < 3; i++) {
			copyMap[nodes[i].x][nodes[i].y] = 'O';
		}
		Queue<Node> q = new LinkedList<>(teachers);

		while (!q.isEmpty()) {
			Node node = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = node.x + moveX[i];
				int y = node.y + moveY[i];
				int obstacleCount = 0;
				while (x >= 0 && y >= 0 && x < N && y < N) {
					if (copyMap[x][y] == 'O') {
						obstacleCount++;
					}
					if (copyMap[x][y] == 'S' && obstacleCount == 0) {
						return false;
					}
					x += moveX[i];
					y += moveY[i];
				}
			}
		}
		return true;
	}

	static boolean checkedX(int num) {
		int x = num / N;
		int y = num % N;

		return map[x][y] == 'X';
	}

	static char[][] copyMap() {
		char[][] copyMap = new char[N][N];
		for (int i = 0; i < N; i++) {
			copyMap[i] = Arrays.copyOf(map[i], N);
		}
		return copyMap;
	}
}
