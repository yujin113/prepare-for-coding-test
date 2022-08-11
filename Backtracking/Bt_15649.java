package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bt_15649 {
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        answer = new int[M];

        find(N, M, 0);
        System.out.println(sb);
    }

    static void find(int N, int M, int cnt) {
        if (cnt == M) {
            for (int i : answer) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            answer[cnt] = i;
            find(N, M, cnt + 1);
            visited[i] = false;
        }
    }
}
