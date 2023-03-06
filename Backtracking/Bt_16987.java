package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bt_16987 {
	static class Egg {
		int S;
		int W;

		public Egg(int S, int W) {
			this.S = S;
			this.W = W;
		}

		public void breakEgg(int W) {
			this.S -= W;
		}

		public void restoreEgg(int W) {
			this.S += W;
		}
	}

	static Egg[] eggs;
	static int N;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			eggs[i] = new Egg(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
		}

		bt(0, 0);

		System.out.println(max);
	}

	private static void bt(int depth, int count) {
		// System.out.println();
		// System.out.println("진입 depth = " + depth + " , count = " + count);
		if (depth == N) {
			max = Math.max(max, count);
			return;
		}

		if (eggs[depth].S <= 0 || count == N - 1) {
			bt(depth + 1, count);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (depth == i) {
				continue;
			}
			if (eggs[i].S <= 0) {
				continue;
			}

			// System.out.print("depth = " + depth);
			// System.out.println(" i = " + i);
			eggs[depth].breakEgg(eggs[i].W);
			eggs[i].breakEgg(eggs[depth].W);

			int nowCount = count;
			if (eggs[depth].S <= 0) {
				nowCount++;
			}
			if (eggs[i].S <= 0) {
				nowCount++;
			}
			// for (Egg egg : eggs) {
			// 	System.out.print(egg.S + " ");
			// }
			// System.out.println();

			bt(depth + 1, nowCount);

			eggs[depth].restoreEgg(eggs[i].W);
			eggs[i].restoreEgg(eggs[depth].W);
		}
	}
}
