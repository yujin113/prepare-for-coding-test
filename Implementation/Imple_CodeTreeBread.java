package Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Imple_CodeTreeBread {
	static class Node {
		int x, y;
		boolean arrived;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, boolean arrived) {
			this.x = x;
			this.y = y;
			this.arrived = arrived;
		}
	}

	static int[][] move = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 위, 왼, 오, 아래
	static int[][] map;
	static boolean[][] visited;
	static Node[] store;
	static List<Node> basecamp;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);

		map = new int[N][N];
		visited = new boolean[N][N];
		basecamp = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
				if (map[i][j] == 1) {
					basecamp.add(new Node(i, j, false));
				}
			}
		}

		store = new Node[M + 1];
		for (int i = 1; i <= M; i++) {
			strs = br.readLine().split(" ");
			store[i] = new Node(Integer.parseInt(strs[0]) - 1, Integer.parseInt(strs[1]) - 1);
		}

		int result = move();
		System.out.println(result);
	}

	private static int move() {
		int time = 0;
		Node[] people = new Node[M + 1];
		for (int i = 1; i <= M; i++) {
			people[i] = new Node(-1, -1, false);
		}

		while (!checkArrived(people)) {
			time++;
			// 격자에 있는 사람들이 본인이 가고 싶은 편의점 방향을 향해서 1 칸 움직입니다.
			for (int i = 1; i <= M; i++) {
				if (people[i].x == -1 || people[i].y == -1 || people[i].arrived) {
					continue;
				}
				// 편의점 향해 움직이기
				int[][] step = bfs(people[i].x, people[i].y, store[i]);

				int min = Integer.MAX_VALUE;
				int dx = people[i].x;
				int dy = people[i].y;
				for (int j = 0; j < 4; j++) {
					int tempX = people[i].x + move[j][0];
					int tempY = people[i].y + move[j][1];
					if (tempX >= 0 && tempY >= 0 && tempX < N && tempY < N) {
						if (step[tempX][tempY] != 0 && step[tempX][tempY] < min) {
							min = step[tempX][tempY];
							dx = tempX;
							dy = tempY;
						}
					}
				}
				people[i].x = dx;
				people[i].y = dy;

				// 만약 편의점에 도착한다면 해당 편의점에서 멈추게 되고,
				// 이때부터 다른 사람들은 해당 편의점이 있는 칸을 지나갈 수 없게 됩니다.
				if (dx == store[i].x && dy == store[i].y) {
					visited[dx][dy] = true;
					people[i].arrived = true;
				}
			}

			// 현재 시간이 t분이고 t ≤ m를 만족한다면, t번 사람은 자신이 가고 싶은 편의점과 가장 가까이 있는 베이스 캠프에 들어갑니다.
			// t번 사람이 베이스 캠프로 이동하는 데에는 시간이 전혀 소요되지 않습니다.
			if (time <= M) {
				Node base = findBasecamp(store[time]);
				visited[base.x][base.y] = true;
				base.arrived = true;
				people[time].x = base.x;
				people[time].y = base.y;
			}

			// printMap(people);
		}

		return time;
	}

	private static int[][] bfs(int x, int y, Node store) {
		int[][] step = new int[N][N];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(store.x, store.y));
		step[store.x][store.y] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.x == x && node.y == y) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int dx = node.x + move[i][0];
				int dy = node.y + move[i][1];

				if (dx >= 0 && dy >= 0 && dx < N && dy < N && !visited[dx][dy] && step[dx][dy] == 0) {
					step[dx][dy] = step[node.x][node.y] + 1;
					q.add(new Node(dx, dy));
				}
			}
		}
		return step;
	}

	private static Node findBasecamp(Node store) {
		int basecampNum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < basecamp.size(); i++) {
			Node node = basecamp.get(i);
			if (node.arrived) {
				continue;
			}

			int[][] step = bfs(node.x, node.y, store);

			if (step[node.x][node.y] != 0 && step[node.x][node.y] < min) {
				min = step[node.x][node.y];
				basecampNum = i;
			}
		}
		return basecamp.get(basecampNum);
	}

	private static boolean checkArrived(Node[] people) {
		boolean flag = true;
		for (int i = 1; i <= M; i++) {
			if (!people[i].arrived) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	// static void printMap(Node[] people) {
	// 	for (int i = 1; i <= M; i++) {
	// 		if (people[i].x != -1) {
	// 			map[people[i].x][people[i].y] = i + 1;
	// 		}
	// 	}
	//
	// 	for (int i = 0; i < N; i++) {
	// 		for (int j = 0; j < N; j++) {
	// 			System.out.print(map[i][j] + " ");
	// 		}
	// 		System.out.println();
	// 	}
	//
	// 	System.out.println();
	// }
	//
	// static void printStep(int[][] map) {
	// 	for (int i = 0; i < N; i++) {
	// 		for (int j = 0; j < N; j++) {
	// 			System.out.print(map[i][j] + " ");
	// 		}
	// 		System.out.println();
	// 	}
	// 	System.out.println();
	// }
}
