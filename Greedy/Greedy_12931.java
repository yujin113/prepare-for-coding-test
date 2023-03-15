package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_12931 {
	static int N;
	static int[] B;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		B = new int[N];

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(str[i]);
		}

		greedy();
		System.out.println(count);
	}

	private static void greedy() {
		while (!checkAllZero()) {
			divide();

			for (int i = 0; i < N; i++) {
				if (B[i] % 2 != 0 && B[i] - 1 >= 0) {
					B[i] -= 1;
					count++;
				}
			}
		}
	}

	private static void divide() {
		while (true) {
			boolean canDivide = true;
			for (int i = 0; i < N; i++) {
				if (B[i] % 2 != 0) {
					canDivide = false;
					break;
				}
			}
			if (!canDivide) {
				return;
			}

			for (int i = 0; i < N; i++) {
				B[i] /= 2;
			}
			count++;
		}
	}

	private static boolean checkAllZero() {
		boolean isAllZero = true;
		for (int i = 0; i < N; i++) {
			if (B[i] != 0) {
				isAllZero = false;
				break;
			}
		}
		return isAllZero;
	}
}
