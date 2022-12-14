package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Dp_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {

                if (arr[j] < arr[i] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);

        Stack<Integer> stack = new Stack<>();
        int index = max;
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == index) {
                stack.push(arr[i]);
                index--;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
