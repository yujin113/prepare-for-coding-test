package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}

		int[] up = new int[N];
		for (int i = 0; i < N; i++) {
			up[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					up[i] = Math.max(up[i], up[j] + 1);
				}
			}
		}

		int[] down = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			down[i] = 1;
			for (int j = N - 1; j >= i; j--) {
				if (arr[j] < arr[i]) {
					down[i] = Math.max(down[i], down[j] + 1);
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			result = Math.max(result, up[i] + down[i] - 1);
		}
		System.out.println(result);
	}
}
