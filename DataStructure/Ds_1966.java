package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Ds_1966 {
	static class Node {
		int n;
		boolean checked;

		public Node(int n) {
			this.n = n;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			String[] str = br.readLine().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			str = br.readLine().split(" ");

			Queue<Node> q = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				Node node = new Node(Integer.parseInt(str[j]));
				if (j == M) {
					node.setChecked(true);
				}
				q.add(node);
			}

			int result = getCount(q);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	static int getCount(Queue<Node> q) {
		int count = 0;
		while (!q.isEmpty()) {
			Node poll = q.poll();

			boolean isExist = false;
			for (Node node : q) {
				if (node.n > poll.n) {
					isExist = true;
					break;
				}
			}

			if (isExist) {
				q.add(poll);
			} else {
				count++;
				if (poll.checked) {
					break;
				}
			}
		}
		return count;
	}
}
