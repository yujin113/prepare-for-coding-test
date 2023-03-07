package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Ds_1655 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q1 = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> q2 = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (q1.size() == q2.size()) {
				q1.add(num);
			} else {
				q2.add(num);
			}

			if (!q1.isEmpty() && !q2.isEmpty()) {
				if (q1.peek() > q2.peek()) {
					int temp = q2.poll();
					q2.add(q1.poll());
					q1.add(temp);
				}
			}

			sb.append(q1.peek()).append("\n");
		}

		System.out.println(sb);
	}
}
