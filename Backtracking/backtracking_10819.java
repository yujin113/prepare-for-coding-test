package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backtracking_10819 {
    static int[] arr, temp;
    static boolean[] visited;
    static int res = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        bt(0, n, 0);
        System.out.println(res);
//        System.out.println(sb);
    }

    public static void bt(int sum, int n, int count) {
        if (count == n) {
            if (res < sum) res = sum;
//            for(int i = 0; i < n; i++) {
//                sb.append(temp[i] + " ");
//            }
//            System.out.println(sum);
//            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cal = 0;
                visited[i] = true;
                if (count > 0) cal = temp[count - 1] - arr[i];
                if (cal < 0) cal = -cal;
                temp[count] = arr[i];
                bt(sum + cal, n, count + 1);
                visited[i] = false;
            }
        }
    }
}
