package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_5557 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		System.out.println(dp(N));
	}

	static long dp(int N) {
		long[][] dp = new long[N - 1][21];
		dp[0][arr[0]] = 1;

		for (int i = 1; i < N - 1; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] == 0) {
					continue;
				}

				if (j + arr[i] <= 20) {
					dp[i][j + arr[i]] += dp[i - 1][j];
				}
				if (j - arr[i] >= 0) {
					dp[i][j - arr[i]] += dp[i - 1][j];
				}
			}
		}

		return dp[N - 2][arr[N - 1]];
	}
}
