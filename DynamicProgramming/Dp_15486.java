package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_15486 {
	static class Node {
		int day;
		int cost;

		public Node(int day, int cost) {
			this.day = day;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N + 1];
		for (int i = 1; i <= N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}

		int[] dp = new int[N + 2];
		int max = 0;

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
			int next = i + arr[i].day;

			if (next <= N + 1) {
				dp[next] = Math.max(dp[next], max + arr[i].cost);
			}
		}

		int result = 0;
		for (int i : dp) {
			result = Math.max(result, i);
		}

		System.out.println(result);
	}
}
