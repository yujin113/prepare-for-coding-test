package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dac_4779 {
    static StringBuilder line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            line = new StringBuilder();
            int N = Integer.parseInt(s);
            int len = (int) Math.pow(3, N);
            for (int i = 0; i < len; i++) {
                line.append(" ");
            }
            dac(0, len);
            result.append(line).append("\n");
        }
        System.out.println(result);
    }

    private static void dac(int start, int len) {
        if (len == 1) {
            line.replace(start, start + 1, "-");
            return;
        }
        dac(start, len / 3);
        dac(start + (len / 3) * 2, len / 3);
    }
}
