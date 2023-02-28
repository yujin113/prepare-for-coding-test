package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_5582 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int N = str1.length();
		int M = str2.length();
		int[][] dp = new int[M + 1][N + 1];
		int max = 0;

		for (int i = 0; i < M; i++) {
			char c1 = str2.charAt(i);
			for (int j = 0; j < N; j++) {
				char c2 = str1.charAt(j);
				if (c1 == c2) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					max = Math.max(dp[i + 1][j + 1], max);
				}
			}
		}
		// for (int i = 1; i <= M; i++) {
		// 	for (int j = 1; j <= N; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		System.out.println(max);
	}
}
