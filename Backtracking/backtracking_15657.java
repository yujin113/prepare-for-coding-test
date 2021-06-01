package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backtracking_15657 {

    static int[] num, arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        num = new int[n];
        arr = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(num);
        func(n, m, 0);
        System.out.println(sb);
    }

    public static void func(int n, int m, int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (count > 0 && arr[count - 1] > num[i])
                continue;
            arr[count] = num[i];
            func(n, m, count + 1);
        }
    }

}
