package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bs_2143 {
    static int[] A, B;
    static List<Integer> sumA, sumB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        makeSumArr(n, m);

        System.out.println(bs(T));
    }

    private static long bs(int T) {
        int left = 0;
        int right = sumB.size() - 1;
        long count = 0;
        while (left < sumA.size() && right >= 0) {
            int sum = sumA.get(left) + sumB.get(right);

            if (sum == T) {
                int a = sumA.get(left);
                int b = sumB.get(right);
                int leftCount = 0;
                int rightCount = 0;

                while (left < sumA.size() && sumA.get(left).equals(a)) {
                    leftCount++;
                    left++;
                }
                while (right >= 0 && sumB.get(right).equals(b)) {
                    rightCount++;
                    right--;
                }
                count += ((long) leftCount * rightCount);
            } else if (sum > T) {
                right--;
            } else {
                left++;
            }
        }

        return count;
    }

    private static void makeSumArr(int n, int m) {
        sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }
        Collections.sort(sumA);

        sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }
        Collections.sort(sumB);
    }
}
