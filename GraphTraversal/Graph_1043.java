package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_1043 {
	static boolean[] canSpeak;
	static boolean[] isSearch;
	static ArrayList<Integer>[] party;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		str = br.readLine().split(" ");
		int count = Integer.parseInt(str[0]);
		Queue<Integer> q = new LinkedList<>();
		isSearch = new boolean[N + 1];
		for (int i = 0; i < count; i++) {
			int num = Integer.parseInt(str[i + 1]);
			q.add(num);
			isSearch[num] = true;
		}

		party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			count = Integer.parseInt(str[0]);
			for (int j = 0; j < count; j++) {
				party[i].add(Integer.parseInt(str[j + 1]));
			}
		}

		canSpeak = new boolean[M];
		for (int i = 0; i < M; i++) {
			canSpeak[i] = true;
		}
		search(q);

		int result = 0;
		for (boolean b : canSpeak) {
			if (b) {
				result++;
			}
		}
		System.out.println(result);
	}

	private static void search(Queue<Integer> q) {
		while (!q.isEmpty()) {
			int person = q.poll();

			for (int i = 0; i < party.length; i++) {
				for (Integer j : party[i]) {
					if (j == person) {
						canSpeak[i] = false;
						for (Integer k : party[i]) {
							if (!isSearch[k]) {
								q.add(k);
								isSearch[k] = true;
							}
						}
						break;
					}
				}
			}
		}
	}
}
