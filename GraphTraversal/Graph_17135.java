package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph_17135 {
	static class Node implements Comparable<Node> {
		int x, y, distance;

		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if (this.distance == o.distance) {
				return this.y - o.y;
			}
			return this.distance - o.distance;
		}
	}

	static int[][] arr, copyArr;
	static int N, M, D;
	static int[] archer;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		D = Integer.parseInt(str[2]);
		arr = new int[N][M];
		copyArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				copyArr[i][j] = arr[i][j];
			}
		}

		result = Integer.MIN_VALUE;
		archer = new int[3];
		pushArcher(0);

		System.out.println(result);
	}

	static void bfs(Queue<Node> archerQueue, int length) {
		boolean[][] visited = new boolean[N][M];
		copyArray();

		int count = 0;
		while (length-- > 0) {
			for (int i = 0; i < 3; i++) {
				Node node = archerQueue.poll(); // 궁수

				PriorityQueue<Node> pq = getEnemies(node); // 궁수 별 적까지의 거리 구하기

				while (!pq.isEmpty()) {
					Node enemy = pq.poll();

					if (enemy.x <= length && enemy.distance <= D) {
						if (visited[enemy.x][enemy.y]) {
							break;
						}
						visited[enemy.x][enemy.y] = true;
						count++;
						break;
					}
				}
				archerQueue.add(new Node(node.x - 1, node.y));
			}

			// 궁수 셋이 모두 공격이 끝나면, 그 때 공격받은 적을 0으로 만들어야 함
			// 한 궁수가 여러 적을 공격할 수 있기 때문
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (visited[i][j]) {
						copyArr[i][j] = 0;
					}
				}
			}
		}
		result = Math.max(result, count);
	}

	private static PriorityQueue<Node> getEnemies(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (copyArr[j][k] == 1) {
					int dis = getDistance(node.x, node.y, j, k);
					pq.add(new Node(j, k, dis));
				}
			}
		}
		return pq;
	}

	static void pushArcher(int depth) {
		if (depth == 3) {
			Queue<Node> archerQueue = new LinkedList<>();
			for (int i : archer) {
				archerQueue.add(new Node(N, i));
			}
			bfs(archerQueue, N);
			return;
		}

		for (int i = 0; i < M; i++) {
			if (depth > 0 && archer[depth - 1] >= i) {
				continue;
			}
			archer[depth] = i;
			pushArcher(depth + 1);
		}
	}

	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static void copyArray() {
		for (int i = 0; i < N; i++) {
			copyArr[i] = Arrays.copyOf(arr[i], M);
		}
	}
}
