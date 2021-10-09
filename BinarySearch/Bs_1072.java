package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_1072 {
    static long X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Z = 100 * Y / X;

        if (Z >= 99) {
            System.out.println("-1");
        } else {
            System.out.println(bs(1, X));
        }
    }

    private static long bs(long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;

            long temp = 100 * (Y + mid) / (X + mid);

            if (temp > Z)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
