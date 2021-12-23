package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Dp_1932 {
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp(n);
    }

    private static void dp(int n) {
        int[] res = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < list[i].size(); j++) {
                int max = Math.max(list[i + 1].get(j), list[i + 1].get(j + 1));
                list[i].set(j, list[i].get(j) + max);
            }
        }

        System.out.println(list[0].get(0));
    }

}
