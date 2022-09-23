package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bs_1365 {
    static int[] lis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        lis = new int[N + 1];
        lis[0] = arr[0];
        int lastIndex = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] > lis[lastIndex - 1]) {
                lis[lastIndex] = arr[i];
                lastIndex++;
            } else {
                int idx = findIndex(arr[i], lastIndex);
                lis[idx] = arr[i];
            }
        }

        System.out.println(N - lastIndex);
    }

    // num보다 큰 수의 인덱스 찾기
    static int findIndex(int num, int lastIndex) {
        int left = 0;
        int right = lastIndex;
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
