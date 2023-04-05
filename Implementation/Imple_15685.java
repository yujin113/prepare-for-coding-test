package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Imple_15685 {
	static int[][] move = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; //0,1,2,3
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int d = Integer.parseInt(str[2]);
			int g = Integer.parseInt(str[3]);
			curve(y, x, d, g);
		}

		System.out.println(findSquare());
	}

	private static void curve(int x, int y, int d, int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		map[x][y] = 1;

		while (g-- > 0) {
			for (int i = list.size() - 1; i >= 0; i--) {
				int direction = list.get(i);

				int nextDirection = (direction + 1) % 4;
				list.add(nextDirection);
			}
		}

		for (Integer direction : list) {
			x += move[direction][0];
			y += move[direction][1];

			map[x][y] = 1;
		}
	}

	private static int findSquare() {
		int count = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
					count++;
				}
			}
		}
		return count;
	}
}
