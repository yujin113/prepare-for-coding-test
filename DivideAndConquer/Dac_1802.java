package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dac_1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String line = br.readLine();
            int[] arr = new int[line.length()];

            for (int j = 0; j < line.length(); j++) {
                arr[j] = line.charAt(j) - '0';
            }

            if (dac(arr)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean dac(int[] arr) {
        int mid = arr.length / 2;
        while (mid != 0) {
            for (int i = 1; i <= mid; i++) {
                if (arr[mid - i] == arr[mid + i]) return false;
            }
            mid /= 2;
        }
        return true;
    }
}
