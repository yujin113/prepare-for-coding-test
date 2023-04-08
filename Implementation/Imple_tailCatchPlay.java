package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Imple_tailCatchPlay {
	static class Person {
		int x, y;
		int num;
		int team;

		public Person(int x, int y, int num, int team) {
			this.x = x;
			this.y = y;
			this.num = num;
			this.team = team;
		}

		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] map;
	static ArrayList<Person>[] teams;
	static int[] point;
	static int n, m, k;
	static int[][] move = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}}; // 우 상 좌 하

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);

		map = new int[n][n];
		point = new int[m];
		teams = new ArrayList[m];
		for (int i = 0; i < m; i++) {
			teams[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					bfs(i, j, index);
					index++;
				}
			}
		}

		game();

		int result = 0;
		for (int i : point) {
			result += i;
		}
		System.out.println(result);
	}

	private static void game() {
		int round = 0;
		while (k-- > 0) {
			round++;
			if (round > 4 * n) {
				round = 1;
			}

			// 먼저 각 팀은 머리사람을 따라서 한 칸 이동합니다.
			go();

			// 각 라운드마다 공이 정해진 선을 따라 던져집니다.
			if (round >= 1 && round <= n) {
				throwBall(0, round - 1);
			} else if (round > n && round <= 2 * n) {
				throwBall(1, round - 1);
			} else if (round > 2 * n && round <= 3 * n) {
				throwBall(2, round - 1);
			} else if (round > 3 * n && round <= 4 * n) {
				throwBall(3, round - 1);
			}
		}
	}

	private static void throwBall(int direction, int round) {
		if (direction == 0) {
			for (int i = 0; i < n; i++) {
				if (map[round][i] != 0 && map[round][i] != 4) {
					getPointAndChangeDirection(round, i);
					break;
				}
			}
		} else if (direction == 1) {
			round %= n;
			for (int i = n - 1; i >= 0; i--) {
				if (map[i][round] != 0 && map[i][round] != 4) {
					getPointAndChangeDirection(i, round);
					break;
				}
			}
		} else if (direction == 2) {
			round = n - 1 - (round % n);
			for (int i = n - 1; i >= 0; i--) {
				if (map[round][i] != 0 && map[round][i] != 4) {
					getPointAndChangeDirection(round, i);
					break;
				}
			}
		} else if (direction == 3) {
			round = n - 1 - (round % n);
			for (int i = 0; i < n; i++) {
				if (map[i][round] != 0 && map[i][round] != 4) {
					getPointAndChangeDirection(i, round);
					break;
				}
			}
		}
	}

	private static void getPointAndChangeDirection(int x, int y) {
		// 공이 던져지는 경우에 해당 선에 사람이 있으면 최초에 만나게 되는 사람만이 공을 얻게 되어 점수를 얻게 됩니다.
		// 점수는 해당 사람이 머리사람을 시작으로 팀 내에서 k번째 사람이라면 k의 제곱만큼 점수를 얻게 됩니다.
		// 아무도 공을 받지 못하는 경우에는 아무 점수도 획득하지 못합니다.
		int[] info = findPerson(x, y);
		Person person = teams[info[0]].get(info[1]);
		int teamNum = person.team;
		int k = info[1] + 1;
		point[teamNum] += (k * k);

		// 공을 획득한 팀의 경우에는 머리사람과 꼬리사람이 바뀝니다. 즉 방향을 바꾸게 됩니다.
		ArrayList<Person> team = teams[teamNum];
		Person head = team.get(0);
		Person tail = team.get(team.size() - 1);
		map[head.x][head.y] = tail.num;
		map[tail.x][tail.y] = head.num;
		head.num = 3;
		tail.num = 1;

		ArrayList<Person> changeDirection = new ArrayList<>();
		for (int i = team.size() - 1; i >= 0; i--) {
			changeDirection.add(team.get(i));
		}
		teams[teamNum] = changeDirection;
	}

	private static void go() {
		for (int i = 0; i < m; i++) {
			Person head = teams[i].get(0);
			int x = head.x;
			int y = head.y;

			for (int j = 0; j < 4; j++) {
				int dx = x + move[j][0];
				int dy = y + move[j][1];

				if (dx >= 0 && dy >= 0 && dx < n && dy < n) {
					if (map[dx][dy] == 4 || map[dx][dy] == 3) {
						head.x = dx;
						head.y = dy;
						map[dx][dy] = head.num;
						break;
					}
				}
			}

			for (int j = 1; j < teams[i].size(); j++) {
				Person person = teams[i].get(j);
				int[] temp = {person.x, person.y};
				person.x = x;
				person.y = y;

				map[x][y] = person.num;
				if (map[temp[0]][temp[1]] != 1) {
					map[temp[0]][temp[1]] = 4;
				}
				x = temp[0];
				y = temp[1];
			}
		}
	}

	private static void bfs(int x, int y, int index) {
		boolean[][] visited = new boolean[n][n];
		teams[index].add(new Person(x, y, map[x][y], index));
		visited[x][y] = true;
		Queue<Person> q = new LinkedList<>();
		q.add(new Person(x, y));

		while (!q.isEmpty()) {
			Person person = q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = person.x + move[i][0];
				int dy = person.y + move[i][1];

				if (dx >= 0 && dy >= 0 && dx < n && dy < n && !visited[dx][dy]) {
					if (map[person.x][person.y] == 1 && map[dx][dy] != 2) {
						continue;
					}
					visited[dx][dy] = true;
					if (map[dx][dy] == 2 || map[dx][dy] == 3) {
						teams[index].add(new Person(dx, dy, map[dx][dy], index));
						q.add(new Person(dx, dy));
					}
				}
			}
		}
	}

	private static int[] findPerson(int x, int y) {
		int[] info = new int[2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < teams[i].size(); j++) {
				if (teams[i].get(j).x == x && teams[i].get(j).y == y) {
					info[0] = i;
					info[1] = j;
					break;
				}
			}
		}
		return info;
	}

	// private static void printTeam() {
	// 	for (int i = 0; i < m; i++) {
	// 		for (int j = 0; j < teams[i].size(); j++) {
	// 			System.out.print(teams[i].get(j).num + "(" + teams[i].get(j).x + "," + teams[i].get(j).y + ") ");
	// 		}
	// 		System.out.println();
	// 	}
	// }
	//
	// private static void printMap() {
	// 	for (int i = 0; i < n; i++) {
	// 		for (int j = 0; j < n; j++) {
	// 			System.out.print(map[i][j] + " ");
	// 		}
	// 		System.out.println();
	// 	}
	// 	System.out.println();
	// }
}