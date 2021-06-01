package Backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backtracking_6603 {

    static int[] testcase;
    static int[] arr = new int[6];
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            testcase = new int[num];
            visited = new boolean[num];
            for (int i = 0; i < num; i++) {
                testcase[i] = Integer.parseInt(st.nextToken());
            }
            bt(num, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void bt(int num, int count) {
        if (count == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < num; i++) {
            if (count > 0 && arr[count - 1] > testcase[i])
                continue;
            if (!visited[i]) {
                visited[i] = true;
                arr[count] = testcase[i];
                bt(num, count + 1);
                visited[i] = false;
            }
        }
    }
}
