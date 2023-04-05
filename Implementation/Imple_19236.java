package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Imple_19236 {
	static class Node {
		int fish;
		int direction;

		public Node(int fish, int direction) {
			this.fish = fish;
			this.direction = direction;
		}
	}

	static class Fish {
		int x, y;

		public Fish(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] move = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	static Node[][] map;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new Node[4][4];
		for (int i = 0; i < 4; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 8; j += 2) {
				int a = Integer.parseInt(str[j]);
				int b = Integer.parseInt(str[j + 1]);
				map[i][j / 2] = new Node(a, b - 1);
			}
		}

		int count = map[0][0].fish;
		map[0][0].fish = -1;
		moveShark(0, 0, count);

		System.out.println(result);
	}

	private static void moveShark(int x, int y, int sum) {
		result = Math.max(result, sum);

		Node node = map[x][y];

		Fish[] fishes = new Fish[17];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j].fish > 0) {
					fishes[map[i][j].fish] = new Fish(i, j);
				}
			}
		}

		moveFish(fishes);

		Node[][] backup = new Node[4][4];
		for (int i = 0; i < 4; i++) {
			backup[i] = Arrays.copyOf(map[i], 4);
		}

		for (int i = 1; i < 4; i++) {
			int direction = node.direction;
			int dx = x + move[direction][0] * i;
			int dy = y + move[direction][1] * i;

			if (dx >= 0 && dy >= 0 && dx < 4 && dy < 4 && map[dx][dy].fish != 0) {
				int eatFish = map[dx][dy].fish;
				map[x][y].fish = 0;
				map[dx][dy].fish = -1;

				moveShark(dx, dy, sum + eatFish);

				for (int j = 0; j < 4; j++) {
					map[j] = Arrays.copyOf(backup[j], 4);
				}
				map[x][y].fish = -1;
				map[dx][dy].fish = eatFish;
			}
		}

	}

	private static void moveFish(Fish[] fishes) {
		for (int i = 1; i < 17; i++) {
			if (fishes[i] == null) {
				continue;
			}
			Fish now = fishes[i];
			int x = now.x;
			int y = now.y;

			int fish = map[x][y].fish;
			int direction = map[x][y].direction;

			for (int j = 0; j < 8; j++) {
				int dx = x + move[direction][0];
				int dy = y + move[direction][1];

				if (dx < 0 || dy < 0 || dx >= 4 || dy >= 4 || map[dx][dy].fish == -1) {
					direction = (direction + 1) % 8;
					continue;
				}

				map[x][y] = map[dx][dy];
				fishes[i] = new Fish(dx, dy);
				fishes[map[dx][dy].fish] = new Fish(x, y);
				map[dx][dy] = new Node(fish, direction);
				break;
			}
		}
	}
}
