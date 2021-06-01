package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class brute_14501 {
    static class Work {
        int period, cost;

        Work(int period, int cost) {
            this.period = period;
            this.cost = cost;
        }
    }
    static Work[] arr;
    static int n, res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Work[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i] = new Work(p, c);
        }

        func(0, 0);

        System.out.println(res);
    }

    private static void func(int num, int total) {
        if (num > n) {
            return;
        }
        if (num == n) {
            if (res < total)
                res = total;
            return;
        }
        if (res < total)
            res = total;

        func(num + arr[num].period, total + arr[num].cost);
        func(num + 1, total);
    }
}
