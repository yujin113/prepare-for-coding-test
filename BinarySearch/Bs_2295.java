package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bs_2295 {
	static int[] U;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		U = new int[N];
		for (int i = 0; i < N; i++) {
			U[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(U);

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				list.add(U[i] + U[j]);
			}
		}
		Collections.sort(list);

		for (int i = N - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				if (bs(U[i] - U[j])) {
					System.out.println(U[i]);
					return;
				}
			}
		}
	}

	private static boolean bs(int num) {
		int left = 0;
		int right = list.size() - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (list.get(mid) == num) {
				return true;
			}

			if (list.get(mid) < num) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return false;
	}
}
