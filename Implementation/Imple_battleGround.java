package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Imple_battleGround {
	static class Player {
		int x, y;
		int direction;
		int stat;
		int gun;
		int point;

		public Player(int x, int y, int direction, int stat, int gun, int point) {
			this.x = x;
			this.y = y;
			this.direction = direction;
			this.stat = stat;
			this.gun = gun;
			this.point = point;
		}
	}

	static ArrayList<Integer>[][] map;
	static Player[] players;
	static int[][] playerMap;
	static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상 우 하 좌
	static int n, m, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		m = Integer.parseInt(strs[1]);
		k = Integer.parseInt(strs[2]);

		map = new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < n; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				int gun = Integer.parseInt(strs[j]);
				if (gun != 0) {
					map[i][j].add(gun);
				}
			}
		}

		players = new Player[m + 1];
		playerMap = new int[n][n];
		for (int i = 1; i <= m; i++) {
			strs = br.readLine().split(" ");
			int x = Integer.parseInt(strs[0]) - 1;
			int y = Integer.parseInt(strs[1]) - 1;
			players[i] = new Player(x, y, Integer.parseInt(strs[2]), Integer.parseInt(strs[3]), 0, 0);
			playerMap[x][y] = i;
		}

		game();
		for (int i = 1; i <= m; i++) {
			System.out.print(players[i].point + " ");
		}
	}

	private static void game() {
		while (k-- > 0) {
			for (int i = 1; i <= m; i++) {
				// 1-1. 첫 번째 플레이어부터 순차적으로 본인이 향하고 있는 방향대로 한 칸만큼 이동합니다.
				Player player = players[i];
				int dx = player.x + move[player.direction][0];
				int dy = player.y + move[player.direction][1];

				// 만약 해당 방향으로 나갈 때 격자를 벗어나는 경우에는 정반대 방향으로 방향을 바꾸어서 1만큼 이동합니다.
				if (dx < 0 || dy < 0 || dx >= n || dy >= n) {
					dx = player.x + move[(player.direction + 2) % 4][0];
					dy = player.y + move[(player.direction + 2) % 4][1];
					player.direction = (player.direction + 2) % 4;
				}

				playerMap[player.x][player.y] = 0;
				player.x = dx;
				player.y = dy;

				// 2-1. 만약 이동한 방향에 플레이어가 없다면 해당 칸에 총이 있는지 확인합니다.
				if (playerMap[dx][dy] == 0) {
					playerMap[dx][dy] = i;
					if (map[dx][dy].size() > 0) {
						if (player.gun == 0) {
							// 총이 있는 경우, 해당 플레이어는 총을 획득합니다.
							int index = getBestGun(dx, dy);
							player.gun = map[dx][dy].get(index);
							map[dx][dy].remove(index);
						} else {
							// 플레이어가 이미 총을 가지고 있는 경우에는 놓여있는 총들과 플레이어가 가지고 있는 총 가운데 공격력이 더 쎈 총을 획득하고,
							// 나머지 총들은 해당 격자에 둡니다.
							int index = getBestGun(dx, dy);
							int bestGun = map[dx][dy].get(index);
							if (bestGun > player.gun) {
								map[dx][dy].add(player.gun);
								player.gun = bestGun;
								map[dx][dy].remove(index);
							}
						}
					}
				} else {
					// 2-2-1. 만약 이동한 방향에 플레이어가 있는 경우에는 두 플레이어가 싸우게 됩니다.
					Player other = players[playerMap[dx][dy]];
					// 해당 플레이어의 초기 능력치와 가지고 있는 총의 공격력의 합을 비교하여 더 큰 플레이어가 이기게 됩니다.
					if (player.gun + player.stat > other.gun + other.stat
						|| (player.gun + player.stat == other.gun + other.stat) && player.stat > other.stat) {
						fight(i, playerMap[dx][dy], dx, dy);
					} else if (player.gun + player.stat < other.gun + other.stat
						|| (player.gun + player.stat == other.gun + other.stat) && player.stat < other.stat) {
						fight(playerMap[dx][dy], i, dx, dy);
					}
				}
			}
		}
	}

	private static void fight(int winP, int loseP, int x, int y) {
		playerMap[x][y] = winP;
		Player win = players[winP];
		Player lose = players[loseP];

		// 이긴 플레이어는 각 플레이어의 초기 능력치와 가지고 있는 총의 공격력의 합의 차이만큼을 포인트로 획득하게 됩니다.
		win.point += Math.abs((win.stat + win.gun) - (lose.stat + lose.gun));

		// 2-2-2. 진 플레이어는 본인이 가지고 있는 총을 해당 격자에 내려놓고, 해당 플레이어가 원래 가지고 있던 방향대로 한 칸 이동합니다.
		// 만약 이동하려는 칸에 다른 플레이어가 있거나 격자 범위 밖인 경우에는 오른쪽으로 90도씩 회전하여 빈 칸이 보이는 순간 이동합니다.
		if (lose.gun != 0) {
			map[x][y].add(lose.gun);
			lose.gun = 0;
		}
		int direction = lose.direction;
		for (int i = 0; i < 4; i++) {
			int dx = lose.x + move[direction][0];
			int dy = lose.y + move[direction][1];

			if (dx < 0 || dy < 0 || dx >= n || dy >= n || playerMap[dx][dy] != 0) {
				direction = (direction + 1) % 4;
				lose.direction = direction;
			} else {
				playerMap[dx][dy] = loseP;
				lose.x = dx;
				lose.y = dy;

				// 만약 해당 칸에 총이 있다면, 해당 플레이어는 가장 공격력이 높은 총을 획득하고 나머지 총들은 해당 격자에 내려 놓습니다.
				if (map[dx][dy].size() > 0) {
					int index = getBestGun(dx, dy);
					lose.gun = map[dx][dy].get(index);
					map[dx][dy].remove(index);
				}
				break;
			}
		}

		// 2-2-3. 이긴 플레이어는 승리한 칸에 떨어져 있는 총들과 원래 들고 있던 총 중 가장 공격력이 높은 총을 획득하고,
		// 나머지 총들은 해당 격자에 내려 놓습니다
		if (map[x][y].size() > 0) {
			int index = getBestGun(x, y);
			int bestGun = map[x][y].get(index);
			if (bestGun > win.gun) {
				map[x][y].add(win.gun);
				win.gun = bestGun;
				map[x][y].remove(index);
			}
		}
	}

	private static int getBestGun(int x, int y) {
		int index = 0;
		int max = 0;
		for (int i = 0; i < map[x][y].size(); i++) {
			int gun = map[x][y].get(i);
			if (gun > max) {
				index = i;
				max = gun;
			}
		}
		return index;
	}

	// static void printMap() {
	// 	for (int i = 0; i < n; i++) {
	// 		for (int j = 0; j < n; j++) {
	// 			if (map[i][j].guns.size() == 0) {
	// 				System.out.print("0 ");
	// 			} else {
	// 				for (int k = 0; k < map[i][j].guns.size(); k++) {
	// 					System.out.print(map[i][j].guns.get(k));
	// 					if (k < map[i][j].guns.size() - 1) {
	// 						System.out.print(",");
	// 					}
	// 				}
	// 				System.out.print(" ");
	// 			}
	// 		}
	// 		System.out.println();
	// 	}
	// 	System.out.println();
	// }
	//
	// static void printPlayerMap() {
	// 	for (int i = 0; i < n; i++) {
	// 		for (int j = 0; j < n; j++) {
	// 			System.out.print(playerMap[i][j] + " ");
	// 		}
	// 		System.out.println();
	// 	}
	// 	for (int i = 1; i <= m; i++) {
	// 		System.out.println(i + " : " + players[i].stat + " + " + players[i].gun);
	// 	}
	// 	System.out.println();
	// }
}
