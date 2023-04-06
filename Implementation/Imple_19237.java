package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Imple_19237 {
	static class Node {
		int shark;
		int smell;

		public Node(int shark, int smell) {
			this.shark = shark;
			this.smell = smell;
		}
	}

	static class Shark {
		int x, y;
		int direction;

		public Shark(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Shark(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}
	}

	static Node[][] map;
	static Shark[] sharks;
	static int N, M, k;
	static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //위,아래,왼쪽,오른쪽
	static int[][][] priority;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);

		map = new Node[N][N];
		sharks = new Shark[M + 1];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(str[j]);
				if (num == 0) {
					map[i][j] = new Node(0, 0);
				} else {
					map[i][j] = new Node(num, k);
					sharks[num] = new Shark(i, j);
				}
			}
		}

		str = br.readLine().split(" ");
		for (int i = 1; i <= M; i++) {
			sharks[i].setDirection(Integer.parseInt(str[i - 1]) - 1);
		}

		priority = new int[M + 1][4][4];
		for (int i = 0; i < M * 4; i++) {
			str = br.readLine().split(" ");
			int[] temp = new int[4];
			for (int j = 0; j < 4; j++) {
				temp[j] = Integer.parseInt(str[j]) - 1;
			}
			priority[(i / 4) + 1][i % 4] = temp;
		}

		int result = move();
		System.out.println(result);
	}

	private static int move() {
		int time = 0;
		while (sharkCount() > 1) {
			time++;
			if (time > 1000) {
				time = -1;
				break;
			}
			// System.out.println("time = " + time);
			// System.out.println("shark = " + sharkCount());
			// System.out.println();

			Node[][] backup = new Node[N][N];
			for (int i = 0; i < N; i++) {
				backup[i] = Arrays.copyOf(map[i], N);
			}
			boolean[][] moved = new boolean[N][N]; //상어가 새로 이동한 곳 구분

			for (int i = 1; i <= M; i++) {
				if (sharks[i] == null) {
					continue;
				}
				Shark shark = sharks[i];

				boolean isMove = false;
				for (int j = 0; j < 4; j++) {
					int direction = priority[i][shark.direction][j];
					int dx = shark.x + move[direction][0];
					int dy = shark.y + move[direction][1];

					//빈칸 먼저 탐색
					if (dx >= 0 && dy >= 0 && dx < N && dy < N && backup[dx][dy].smell == 0) {
						// 상어가 있는 칸이라면
						if (map[dx][dy].smell == k) {
							int win = Math.min(map[dx][dy].shark, i);
							if (win == i) {
								sharks[map[dx][dy].shark] = null;
								map[dx][dy] = new Node(i, k);
								sharks[i] = new Shark(dx, dy, direction);
								moved[dx][dy] = true;
							} else {
								sharks[i] = null;
							}
						} else {
							// 상어 없는 빈칸이라면
							map[dx][dy] = new Node(i, k);
							sharks[i] = new Shark(dx, dy, direction);
							moved[dx][dy] = true;
						}
						isMove = true;
						break;
					}
				}
				//빈칸 없으면 자신의 냄새가 있는 방향 탐색
				if (!isMove) {
					for (int j = 0; j < 4; j++) {
						int direction = priority[i][shark.direction][j];
						int dx = shark.x + move[direction][0];
						int dy = shark.y + move[direction][1];

						if (dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy].shark == i) {
							map[dx][dy] = new Node(i, k);
							sharks[i] = new Shark(dx, dy, direction);
							moved[dx][dy] = true;
							break;
						}
					}
				}
			}
			decreaseSmell(moved);
			// printMap();
			// System.out.println();
		}
		return time;
	}

	private static void decreaseSmell(boolean[][] moved) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].smell > 0 && !moved[i][j]) {
					map[i][j].smell--;
				}
				if (map[i][j].smell == 0) {
					map[i][j] = new Node(0, 0);
				}
			}
		}
	}

	private static int sharkCount() {
		int count = 0;
		for (int i = 1; i <= M; i++) {
			if (sharks[i] != null) {
				count++;
			}
		}
		return count;
	}

	// private static void printMap() {
	// 	for (int i = 0; i < N; i++) {
	// 		for (int j = 0; j < N; j++) {
	// 			System.out.print(map[i][j].shark + "(" + map[i][j].smell + ") ");
	// 		}
	// 		System.out.println();
	// 	}
	// }
	//
	// private static void printPriority(int M) {
	// 	for (int i = 1; i <= M; i++) {
	// 		for (int j = 0; j < 4; j++) {
	// 			for (int l = 0; l < 4; l++) {
	// 				System.out.print(priority[i][j][l] + " ");
	// 			}
	// 			System.out.println();
	// 		}
	// 		System.out.println("----");
	// 	}
	// }
	//
	// private static void printSharks() {
	// 	System.out.println("--");
	// 	for (int i = 0; i <= M; i++) {
	// 		if (sharks[i] == null) {
	// 			System.out.println("x");
	// 		} else {
	// 			System.out.println(sharks[i].x + "," + sharks[i].y + "  " + sharks[i].direction);
	// 		}
	// 	}
	// 	System.out.println("--");
	// }
}
