package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bs_14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        int[] lis = new int[N];
        int[] index = new int[N];
        lis[0] = arr[0];
        index[0] = 0;
        int lastIndex = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i] > lis[lastIndex]) {
                lis[++lastIndex] = arr[i];
                index[i] = lastIndex;
            } else {
                int bs = bs(lis, lastIndex, arr[i]);
                lis[bs] = arr[i];
                index[i] = bs;
            }
        }
        System.out.println(lastIndex + 1);

        Stack<Integer> stack = new Stack<>();
        int idx = lastIndex;
        for (int i = N - 1; i >= 0; i--) {
            if (index[i] == idx) {
                stack.push(arr[i]);
                idx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static int bs(int[] lis, int right, int num) {
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (lis[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
