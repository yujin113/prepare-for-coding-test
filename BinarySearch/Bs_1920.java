package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_1920 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(num, 0, N - 1));
        }
    }

    private static int binarySearch(int key, int low, int high) {
        int mid;

//        if (low <= high) {
//            mid = (low + high) / 2;
//
//            if (key == arr[mid])
//                return 1;
//            else if (key < arr[mid])
//                return binarySearch(key, low, mid - 1);
//            else
//                return binarySearch(key, mid + 1, high);
//
//        }

        while (low <= high) {
            mid = (low + high) / 2;

            if (key == arr[mid])
                return 1;
            else if (key < arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return 0;
    }
}
