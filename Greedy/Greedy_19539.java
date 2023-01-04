package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");

        int sum = 0;
        int oddCount = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(strings[i]);
            sum += num;
            if (num % 2 != 0) {
                oddCount += 1;
            }
        }

        if (sum % 3 != 0 || oddCount > sum / 3) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
