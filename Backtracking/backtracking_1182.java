package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backtracking_1182 {

    static int[] arr;
    static int res = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }
        dfs(0, n, s, 0);
        System.out.println(s == 0 ? --res : res);
    }

    public static void dfs(int sum, int n, int s, int count) {
        if (count == n) {
            if (sum == s) {
                res++;
            }
            return;
        }
        dfs(sum + arr[count], n, s, count + 1);
        dfs(sum, n, s, count + 1);
    }

//    public static void bt(int num, int n, int s, int count) {
//        if (count == num) {
//            int sum = 0;
//            for (int i = 0; i < num; i++) {
//                sb.append(temp[i]).append(" ");
//                sum += temp[i];
//            }
//            if (sum == s) {
//                res++;
//                sb.append("!!!!!!!!!!!!!!!");
//            }
//            sb.append("\n");
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (count > 0 && temp[count - 1] > arr[i])
//                continue;
//            if (!visited[i]) {
//                visited[i] = true;
//                temp[count] = arr[i];
//                bt(num, n, s, count + 1);
//                visited[i] = false;
//            }
//        }
//    }
}
