package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bs_9024 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int K = Integer.parseInt(str[1]);
			arr = new int[n];

			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(str[j]);
			}
			Arrays.sort(arr);
			sb.append(binarySearch(0, n - 1, K)).append("\n");
		}
		System.out.println(sb);
	}

	static int binarySearch(int left, int right, int K) {
		int closest = Integer.MAX_VALUE;
		int count = 0;
		while (left < right) {
			int sum = arr[left] + arr[right];
			int diff = Math.abs(K - sum);

			if (diff < closest) {
				closest = diff;
				count = 1;
			} else if (diff == closest) {
				count++;
			}

			if (sum <= K) {
				left++;
			} else {
				right--;
			}
		}
		return count;
	}
}
