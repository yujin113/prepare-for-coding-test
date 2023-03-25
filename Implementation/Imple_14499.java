package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Imple_14499 {
	static class Dice {
		int x, y;
		int[] side;

		public Dice(int x, int y) {
			this.x = x;
			this.y = y;
			this.side = new int[7];
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] map;
	static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}}; //동0 서1 북2 남3
	static Dice dice;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		int x = Integer.parseInt(str[2]);
		int y = Integer.parseInt(str[3]);
		int K = Integer.parseInt(str[4]);

		dice = new Dice(x, y);

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		str = br.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			int order = Integer.parseInt(str[i]);
			move(order - 1);
		}

		System.out.println(sb);
	}

	private static void move(int order) {
		int x = dice.x + move[order][0];
		int y = dice.y + move[order][1];

		if (x >= 0 && y >= 0 && x < N && y < M) {
			dice.setXY(x, y);
			moveDice(order);

			sb.append(dice.side[1]).append("\n");

			if (map[x][y] != 0) {
				dice.side[6] = map[x][y];
				map[x][y] = 0;
			} else {
				map[x][y] = dice.side[6];
			}
		}
	}

	private static void moveDice(int order) {
		int[] temp = Arrays.copyOf(dice.side, 7);

		if (order == 0) {
			dice.side[1] = temp[4];
			dice.side[3] = temp[1];
			dice.side[4] = temp[6];
			dice.side[6] = temp[3];
		} else if (order == 1) {
			dice.side[1] = temp[3];
			dice.side[4] = temp[1];
			dice.side[6] = temp[4];
			dice.side[3] = temp[6];
		} else if (order == 2) {
			dice.side[1] = temp[5];
			dice.side[5] = temp[6];
			dice.side[6] = temp[2];
			dice.side[2] = temp[1];
		} else if (order == 3) {
			dice.side[1] = temp[2];
			dice.side[5] = temp[1];
			dice.side[6] = temp[5];
			dice.side[2] = temp[6];
		}
	}
}
