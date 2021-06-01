package Recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class recursion_2263 {
    static StringBuilder sb = new StringBuilder();
    static int[] in;
    static int[] post;
    static int[] index;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        index = new int[n + 1];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (i == 0)
                    in[j] = num;
                if (i == 1)
                    post[j] = num;
            }
        }
        for (int i = 0; i < n; i++)
            index[in[i]] = i;

        makeTree(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    private static void makeTree(int in_start, int in_end, int post_start, int post_end) {
        if (in_end < in_start || post_end < post_start) return;

        int num = post[post_end];
        sb.append(num).append(" ");

        int id = index[num];
        int left = id - in_start;
        int right = in_end - id;

        makeTree(in_start, in_start + left - 1, post_start, post_start + left - 1);

        makeTree(id + 1, id + right, post_end - right, post_end - 1);

    }

}
