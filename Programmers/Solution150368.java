package Programmers;

public class Solution150368 {
	static int[] arr;
	static int[] answer = new int[2];

	public int[] solution(int[][] users, int[] emoticons) {
		arr = new int[emoticons.length];

		backtracking(0, users, emoticons);

		return answer;
	}

	private static void backtracking(int depth, int[][] users, int[] emoticons) {
		if (depth == emoticons.length) {
			calc(users, emoticons);
			return;
		}

		for (int i = 10; i <= 40; i += 10) {
			arr[depth] = i;
			backtracking(depth + 1, users, emoticons);
		}
	}

	private static void calc(int[][] users, int[] emoticons) {
		int[] discount = new int[emoticons.length];

		for (int i = 0; i < emoticons.length; i++) {
			discount[i] = (emoticons[i] / 100) * (100 - arr[i]);
		}

		int count = 0;
		int costSum = 0;
		for (int i = 0; i < users.length; i++) {
			int cost = 0;
			for (int j = 0; j < discount.length; j++) {
				if (arr[j] >= users[i][0]) {
					cost += discount[j];
				}
			}

			if (cost >= users[i][1]) {
				cost = 0;
				count++;
			}

			costSum += cost;
		}

		if (count > answer[0]) {
			answer[0] = count;
			answer[1] = costSum;
		} else if (count == answer[0]) {
			answer[1] = Math.max(answer[1], costSum);
		}
	}
}
