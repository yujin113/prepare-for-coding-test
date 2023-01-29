package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy_13975 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split(" ");
			Queue<Long> q = new PriorityQueue<>();
			for (int j = 0; j < K; j++) {
				q.add(Long.parseLong(str[j]));
			}

			sb.append(greedy(q)).append("\n");
		}
		System.out.println(sb);
	}

	static long greedy(Queue<Long> q) {
		long result = 0;
		long sum = 0;
		while (q.size() > 1) {
			long num1 = q.poll();
			long num2 = q.poll();
			sum = num1 + num2;
			q.add(sum);

			result += sum;
		}
		return result;
	}
}
