package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Greedy_19598 {
	static class Node implements Comparable<Node> {
		int start;
		int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] arr = new Node[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			arr[i] = new Node(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}
		Arrays.sort(arr);

		int result = getCount(N, arr);
		System.out.println(result);
	}

	static int getCount(int N, Node[] arr) {
		Queue<Integer> q = new PriorityQueue<>();
		q.add(arr[0].end);
		int count = 1;

		for (int i = 1; i < N; i++) {
			if (q.peek() > arr[i].start) {
				q.add(arr[i].end);
				count++;
				continue;
			}

			q.poll();
			q.add(arr[i].end);
		}
		return count;
	}
}
