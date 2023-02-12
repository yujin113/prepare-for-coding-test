package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_1083 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		String[] str = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int S = Integer.parseInt(br.readLine());

		for (int i = 0; i < N - 1; i++) {
			if (S == 0) {
				break;
			}
			int max = arr[i];
			int index = i;
			for (int j = i; j <= i + S; j++) {
				if (j >= N) break;
				if (arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			while (index > i) {
				sort(index, index - 1);
				index--;
				S--;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	static void sort(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
