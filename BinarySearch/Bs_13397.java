package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bs_13397 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        str = br.readLine().split(" ");
        arr = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(str[i]);
            max = Math.max(max, arr[i]);
        }
        System.out.println(bs(0, max, M));
    }

    static int bs(int left, int right, int M) {
        while (left <= right) {
            int mid = (left + right) / 2;
//            System.out.println("left = " + left + " , right = " + right);
//            System.out.println("mid = " + mid);

            if (count(mid) > M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
//            System.out.println("left = " + left + " , right = " + right);
//            System.out.println();
        }
        return left;
    }

    static int count(int mid) {
        int count = 1; // 구간 수
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if (max - min > mid) {
                count++;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                i--;
            }
        }
//        System.out.println("count = " + count);
        return count;
    }
}
