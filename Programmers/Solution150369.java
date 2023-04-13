package Programmers;

public class Solution150369 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int dIndex = n - 1;
		int pIndex = n - 1;

		while (dIndex >= 0 || pIndex >= 0) {
			while (dIndex >= 0 && deliveries[dIndex] == 0) {
				dIndex--;
			}
			while (pIndex >= 0 && pickups[pIndex] == 0) {
				pIndex--;
			}

			answer += (Math.max(dIndex, pIndex) + 1) * 2;

			int sum = 0;

			while (dIndex >= 0 && sum < cap) {
				sum += deliveries[dIndex];
				deliveries[dIndex] = 0;
				dIndex--;
			}
			if (sum > cap) {
				dIndex++;
				deliveries[dIndex] = (sum - cap);
			}

			sum = 0;
			while (pIndex >= 0 && sum < cap) {
				sum += pickups[pIndex];
				pickups[pIndex] = 0;
				pIndex--;
			}
			if (sum > cap) {
				pIndex++;
				pickups[pIndex] = (sum - cap);
			}
		}

		return answer;
	}
}
