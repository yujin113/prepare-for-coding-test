package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bs_2613 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		arr = new int[N];
		int left = 0;
		int right = 0;
		str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
			left = Math.max(left, arr[i]);
			right += arr[i];
		}

		int result = bs(left, right);
		sb.append(result).append("\n");

		int sum = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			if (sum > result) {
				sb.append(count).append(" ");
				count = 1;
				sum = arr[i];
				M--;
			} else {
				count++;
			}

			if (M == N - i) {
				break;
			}
		}
		while (M-- > 0) {
			sb.append(count).append(" ");
			count = 1;
		}
		System.out.println(sb);
	}

	private static int bs(int left, int right) {
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = 1;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += arr[i];
				if (sum > mid) {
					sum = arr[i];
					count++;
				}
			}

			if (count <= M) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
