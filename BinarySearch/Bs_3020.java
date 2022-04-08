package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_3020 {
    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] up = new int[N / 2];
        int[] down = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(up);
        Arrays.sort(down);

        int min = N;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            int num = bs(0, N / 2, i, down) + bs(0, N / 2, H - i + 1, up);
            if (min == num) {
                count++;
            }
            if (min > num) {
                min = num;
                count = 1;
            }
        }
        System.out.println(min + " " + count);
    }

    private static int bs(int left, int right, int height, int[] arr) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid >= arr.length) break;

            if (arr[mid] < height) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return arr.length - left;
    }
}
