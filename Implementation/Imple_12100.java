package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Imple_12100 {
	static int[][] originMap;
	static int[][] map;
	static int[] arr = new int[5];
	static int N;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		originMap = new int[N][N];
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				originMap[i][j] = Integer.parseInt(str[j]);
			}
		}

		backtracking(0);
		System.out.println(result);
	}

	private static void backtracking(int depth) {
		if (depth == 5) {
			for (int i = 0; i < N; i++) {
				map[i] = Arrays.copyOf(originMap[i], N);
			}

			for (int i : arr) {
				game(i);
			}
			countMax();
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 위0 오1 아2 왼3
			arr[depth] = i;
			backtracking(depth + 1);
		}
	}

	private static void game(int direction) {
		Queue<Integer> q = new LinkedList<>();
		if (direction == 0) { //위
			for (int i = 0; i < N; i++) {
				// 00 10 20 30
				// 01 11 21 31
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 0)
						continue;
					q.add(map[j][i]);
					map[j][i] = 0;
				}
				int index = 0;
				while (!q.isEmpty()) {
					int num = q.poll();

					if (map[index][i] == 0) {
						map[index][i] = num;
					} else if (map[index][i] == num) {
						map[index][i] *= 2;
						index++;
					} else {
						index++;
						map[index][i] = num;
					}
				}
			}
		} else if (direction == 1) { //오른쪽
			for (int i = 0; i < N; i++) {
				// 03 02 01 00
				// 13 12 11 10
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] == 0)
						continue;
					q.add(map[i][j]);
					map[i][j] = 0;
				}

				int index = N - 1;
				while (!q.isEmpty()) {
					int num = q.poll();

					if (map[i][index] == 0) {
						map[i][index] = num;
					} else if (map[i][index] == num) {
						map[i][index] *= 2;
						index--;
					} else {
						index--;
						map[i][index] = num;
					}
				}
			}
		} else if (direction == 2) { //아래
			// 30 20 10 00
			// 31 21 11 01
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] == 0)
						continue;
					q.add(map[j][i]);
					map[j][i] = 0;
				}

				int index = N - 1;
				while (!q.isEmpty()) {
					int num = q.poll();

					if (map[index][i] == 0) {
						map[index][i] = num;
					} else if (map[index][i] == num) {
						map[index][i] *= 2;
						index--;
					} else {
						index--;
						map[index][i] = num;
					}
				}
			}
		} else if (direction == 3) { //왼쪽
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0)
						continue;
					q.add(map[i][j]);
					map[i][j] = 0;
				}

				int index = 0;
				while (!q.isEmpty()) {
					int num = q.poll();

					if (map[i][index] == 0) {
						map[i][index] = num;
					} else if (map[i][index] == num) {
						map[i][index] *= 2;
						index++;
					} else {
						index++;
						map[i][index] = num;
					}
				}
			}
		}

	}

	private static void countMax() {
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp = Math.max(temp, map[i][j]);
			}
		}
		result = Math.max(result, temp);
	}
}
