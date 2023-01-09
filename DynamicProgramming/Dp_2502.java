package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_2502 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int D = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);
        int[] a = new int[D + 1];
        int[] b = new int[D + 1];
        a[1] = b[2] = a[3] = b[3] = 1;
        for (int i = 4; i <= D; i++) {
            a[i] = a[i - 1] + a[i - 2];
            b[i] = b[i - 1] + b[i - 2];
        }

        int aMax = K / a[D];
        int bMax = K / b[D];
        for (int i = 1; i <= aMax; i++) {
            for (int j = i; j <= bMax; j++) {
                if (a[D] * i + b[D] * j == K) {
                    System.out.println(i);
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}