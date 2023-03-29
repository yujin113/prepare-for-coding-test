package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Imple_14503 {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static int N, M;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int d = Integer.parseInt(str[2]); //북0 동1 남2 서3

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		dfs(r, c, d);
		System.out.println(result);
	}

	private static void dfs(int row, int col, int direction) {
		if (map[row][col] == 0) {
			map[row][col] = 2;
			result++;
		}

		if (!canSearch(row, col)) {
			row -= move[direction][0];
			col -= move[direction][1];

			if (row >= 0 && col >= 0 && row < N && col < M && map[row][col] != 1) {
				dfs(row, col, direction);
			}
		} else {
			for (int i = 0; i < 4; i++) {
				direction = (direction + 3) % 4;

				int x = row + move[direction][0];
				int y = col + move[direction][1];

				if (x >= 0 && y >= 0 && x < N && y < M && map[x][y] == 0) {
					dfs(x, y, direction);
					return;
				}
			}
		}
	}

	private static boolean canSearch(int row, int col) {
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int x = row + move[i][0];
			int y = col + move[i][1];

			if (map[x][y] == 0) {
				flag = true;
				break;
			}
		}

		return flag;
	}
}
