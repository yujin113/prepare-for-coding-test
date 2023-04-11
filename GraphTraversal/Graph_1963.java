package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_1963 {
	static class Node {
		int num;
		int[] numArr = new int[4];
		int count;

		public Node(int num, int count) {
			this.num = num;
			this.count = count;
			this.numArr[0] = Integer.parseInt((num + "").substring(0, 1));
			this.numArr[1] = Integer.parseInt((num + "").substring(1, 2));
			this.numArr[2] = Integer.parseInt((num + "").substring(2, 3));
			this.numArr[3] = Integer.parseInt((num + "").substring(3, 4));
		}
	}

	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String[] str = br.readLine().split(" ");
			int n1 = Integer.parseInt(str[0]);
			int n2 = Integer.parseInt(str[1]);

			bfs(n1, n2);
			if (min == Integer.MAX_VALUE) {
				sb.append("Impossible").append("\n");
			} else {
				sb.append(min).append("\n");
			}
		}

		System.out.println(sb);
	}

	private static void bfs(int n1, int n2) {
		min = Integer.MAX_VALUE;
		boolean[] visited = new boolean[10000];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n1, 0));
		visited[n1] = true;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.num == n2) {
				min = Math.min(min, node.count);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int[] numArr = Arrays.copyOf(node.numArr, 4);
				for (int j = 0; j < 10; j++) {
					numArr[i] = j;
					int num = toNum(numArr);
					if (num < 1000 || num == node.num) {
						continue;
					}

					if (!visited[num] && isDecimal(num)) {
						visited[num] = true;
						Node next = new Node(num, node.count + 1);
						next.numArr = Arrays.copyOf(numArr, 4);
						q.add(next);
					}
				}
			}

		}
	}

	private static int toNum(int[] num) {
		return num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];
	}

	private static boolean isDecimal(int num) {
		boolean flag = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}
