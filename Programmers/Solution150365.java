package Programmers;

public class Solution150365 {
	int[][] move = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}}; //아래 왼 오른 위
	String[] str = {"d", "l", "r", "u"};
	int n, m, r, c, k;
	String result = "";
	boolean stop = false;

	public void dfs(int row, int col, String path, int rest) {
		if (row == r && col == c && rest == 0) {
			result = path;
			stop = true;
			return;
		}
		if (stop) {
			return;
		}

		rest -= 1;

		for (int i = 0; i < 4; i++) {
			int dx = row + move[i][0];
			int dy = col + move[i][1];

			if (dx >= 0 && dy >= 0 && dx < n && dy < m) {
				int distance = Math.abs(dx - r) + Math.abs(dy - c);
				if (distance <= rest && (rest - distance) % 2 == 0) {
					dfs(dx, dy, path + str[i], rest);
				}
			}
		}
	}

	public String solution(int n, int m, int x, int y, int r, int c, int k) {
		this.n = n;
		this.m = m;
		this.r = r - 1;
		this.c = c - 1;
		this.k = k;

		String answer = "";
		int distance = Math.abs(x - r) + Math.abs(y - c);
		if (k < distance) {
			answer = "impossible";
		} else {
			dfs(x - 1, y - 1, "", k);
			if (result.equals("")) {
				answer = "impossible";
			} else {
				answer = result;
			}
		}

		return answer;
	}
}
