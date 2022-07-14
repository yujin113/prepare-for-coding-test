package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] arr = new int[91];
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            arr[(int) c] = arr[(int) c] + 1;
        }

        int mid = 0;
        for (int i = 65; i < 91; i++) {
            if (arr[(int) i] % 2 == 1) {
                if (mid != 0) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
                mid = i;
            }
        }
        char[] result = new char[line.length()];
        if (mid != 0) {
            result[line.length() / 2] = (char) mid;
            arr[mid] -= 1;
        }
        int left = 0, right = line.length() - 1;
        for (int i = 65; i < 91; i++) {
            while (arr[i] > 0) {
                result[left] = (char) i;
                result[right] = (char) i;

                arr[i] -= 2;
                left++;
                right--;
            }
        }
        for (int j = 0; j < result.length; j++) {
            System.out.print(result[j]);
        }
    }
}
