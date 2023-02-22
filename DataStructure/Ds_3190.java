package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ds_3190 {
	static class Node {
		int x, y;
		int direction; //오른 아래 왼 위 0 1 2 3

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int direction) {
			this.x = x;
			this.y = y;
			this.direction = direction;
		}

	}

	static class Info {
		int time;
		char direction;

		public Info(int time, char direction) {
			this.time = time;
			this.direction = direction;
		}
	}

	static int[][] map;
	static int now = 0;
	static Deque<Node> snake = new LinkedList<>();
	static Info[] info;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < K; i++) {
			String[] str = br.readLine().split(" ");
			Node apple = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			map[apple.x - 1][apple.y - 1] = 1;
		}
		map[0][0] = 2;
		snake.add(new Node(0, 0, 0));

		int L = Integer.parseInt(br.readLine());
		info = new Info[L];
		for (int i = 0; i < L; i++) {
			String[] str = br.readLine().split(" ");
			info[i] = new Info(Integer.parseInt(str[0]), str[1].charAt(0));
		}

		moveSnake(N, L);
		System.out.println(now);
	}

	static void moveSnake(int N, int L) {
		int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 오 아 왼 위
		int index = 0;

		while (true) {
			Node node = snake.peekFirst();
			int direction = node.direction;
			if (index < L && now == info[index].time) {
				if (info[index].direction == 'D') {
					direction = (direction + 1) % 4;
				}
				if (info[index].direction == 'L') {
					direction = (direction + 3) % 4;
				}
				index++;
			}

			int x = node.x + move[direction][0];
			int y = node.y + move[direction][1];
			if (x < 0 || y < 0 || x >= N || y >= N) {
				now++;
				break;
			}
			if (map[x][y] == 2) {
				now++;
				break;
			}

			if (map[x][y] == 0) {
				map[x][y] = 2;
				snake.addFirst(new Node(x, y, direction));
				Node tail = snake.removeLast();
				map[tail.x][tail.y] = 0;
			} else if (map[x][y] == 1) {
				map[x][y] = 2;
				snake.addFirst(new Node(x, y, direction));
			}

			now++;
		}
	}
}