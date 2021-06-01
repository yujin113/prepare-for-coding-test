package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backtracking_14888 {

    static int[] num, operator, op, arr;
//    static boolean[] visited;
    static int large = -100000001;
    static int small = 100000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        num = new int[n];
        operator = new int[4];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st2.nextToken());
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st3.nextToken());
        }

        arr = new int[n - 1]; // 연산자 배열
//        visited = new boolean[n - 1];
//        op = new int[n - 1]; // index 담
//
//        int k = 0;
//        for (int i = 0; i < 4; i++) {
//            if (operator[i] > 0) {
//                for (int j = 0; j < operator[i]; j++) {
//                    op[k] = i;
//                    k++;
//                }
//            }
//        }
//        bt(n - 1, 0);
        dfs(num[0], n, 1);
        System.out.println(large);
        System.out.println(small);
    }


    public static void dfs(int n, int sum, int count) {
        if (count == sum) {
            if (large < n)
                large = n;
            if (small > n)
                small = n;
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        dfs(n + num[count], sum, count + 1);
                        break;
                    case 1:
                        dfs(n - num[count], sum, count + 1);
                        break;
                    case 2:
                        dfs(n * num[count], sum, count + 1);
                        break;
                    case 3:
                        dfs(n / num[count], sum, count + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }

//    public static void bt(int sum, int count) {
//        if (count == sum) {
//            int res = num[0];
//            for (int i = 0; i < sum; i++) {
//                switch (arr[i]) {
//                    case 0:
//                        res = res + num[i + 1];
//                        break;
//                    case 1:
//                        res = res - num[i + 1];
//                        break;
//                    case 2:
//                        res = res * num[i + 1];
//                        break;
//                    case 3:
//                        if (res < 0) {
//                            res = res / num[i + 1];
//                        } else
//                            res = res / num[i + 1];
//                        break;
//                }
//            }
//            if (res > large)
//                large = res;
//            if (res < small)
//                small = res;
//            return;
//        }
//        for (int i = 0; i < sum; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//
//                switch (i)
//
//                bt(sum, count + 1);
//                visited[i] = false;
//            }
//        }
//    }
}
