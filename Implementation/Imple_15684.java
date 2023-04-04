package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Imple_15684 {
	static int N, M, H;
	static int[][] map;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		H = Integer.parseInt(str[2]);

		map = new int[H + 1][N + 1];
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			map[a][b] = 1;
		}

		dfs(0, 1);
		if (result == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(result);
		}
	}

	private static void dfs(int depth, int row) {
		if (depth > result || depth == 4) {
			return;
		}

		if (move()) {
			result = Math.min(result, depth);
		}

		for (int i = row; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 0 && map[i][j - 1] == 0 && map[i][j + 1] == 0) {
					map[i][j] = 1;
					dfs(depth + 1, i);
					map[i][j] = 0;
				}
			}
		}
	}

	private static boolean move() {
		boolean flag = true;

		for (int i = 1; i <= N; i++) {
			int destination = i;
			for (int j = 1; j <= H; j++) {
				if (map[j][destination] == 1) {
					destination += 1;
				} else if (map[j][destination - 1] == 1) {
					destination -= 1;
				}
			}
			if (i != destination) {
				flag = false;
				break;
			}
		}

		return flag;
	}
}
