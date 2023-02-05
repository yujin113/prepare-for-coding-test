package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bt_15686 {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int[] arr;
	static List<Node> chicken;
	static int N, M;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][N];
		chicken = new ArrayList<>();
		arr = new int[M];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 2) {
					chicken.add(new Node(i, j));
				}
			}
		}

		result = Integer.MAX_VALUE;
		backtracking(0);

		System.out.println(result);
	}

	static void backtracking(int depth) {
		if (depth == M) {
			chickenDistance(arr);
			return;
		}

		for (int i = 0; i < chicken.size(); i++) {
			if (depth > 0 && arr[depth - 1] >= i) {
				continue;
			}
			arr[depth] = i;
			backtracking(depth + 1);
		}
	}

	static void chickenDistance(int[] arr) {
		int distance = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					distance += getMinDistance(i, j, arr);
				}
			}
		}
		result = Math.min(result, distance);
	}

	static int getMinDistance(int x, int y, int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i : arr) {
			Node node = chicken.get(i);
			int distance = Math.abs(x - node.x) + Math.abs(y - node.y);
			min = Math.min(min, distance);
		}
		return min;
	}
}
