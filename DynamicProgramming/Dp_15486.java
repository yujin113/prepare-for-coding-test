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
		Node[] arr = new Node[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}

		int[] dp = new int[N + 1];

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp[i]);

			int next = i + arr[i].day;
			if (next <= N) {
				dp[next] = Math.max(dp[next], max + arr[i].cost);
			}
		}
		max = Math.max(max, dp[N]);

		System.out.println(max);
	}
}
