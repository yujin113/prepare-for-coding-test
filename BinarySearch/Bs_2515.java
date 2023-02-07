package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bs_2515 {
	static class Node implements Comparable<Node> {
		int height, cost;

		public Node(int height, int cost) {
			this.height = height;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if (this.height == o.height) {
				return o.cost - this.cost;
			}
			return this.height - o.height;
		}
	}

	static Node[] arr;
	static int[] dp;
	static int N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		S = Integer.parseInt(str[1]);

		arr = new Node[N];
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			arr[i] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}

		Arrays.sort(arr);

		dp = new int[N];
		dp[0] = arr[0].cost;
		for (int i = 1; i < N; i++) {
			int index = findIndex(0, i, arr[i].height - S);
			if (index < 0) {
				dp[i] = Math.max(arr[i].cost, dp[i - 1]);
				continue;
			}
			dp[i] = Math.max(dp[i], dp[i - 1]);
			dp[i] = Math.max(dp[i], dp[index] + arr[i].cost);
		}

		System.out.println(dp[N - 1]);
	}

	static int findIndex(int left, int right, int num) {
		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid].height <= num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}
}
