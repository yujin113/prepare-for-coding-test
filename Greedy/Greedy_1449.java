package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_1449 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(greedy(N, L));
    }

    private static int greedy(int N, int L) {
        int result = 1;

        double range = arr[0] - 0.5 + L;

        for (int i = 1; i < N; i++) {
            if (range < arr[i] + 0.5) {
                range = arr[i] - 0.5 + L;
                result++;
            }
        }

        return result;
    }
}
