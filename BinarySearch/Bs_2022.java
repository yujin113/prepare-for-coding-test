package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_2022 {
    static double x, y, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Double.parseDouble(st.nextToken());
        y = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        double result = bs(0, Math.max(x, y));

        System.out.printf("%.3f", result);
    }

    private static double bs(double left, double right) {
        while (right - left > 0.001) {
            double result = (left + right) / 2;
            double h1 = Math.sqrt(x * x - result * result);
            double h2 = Math.sqrt(y * y - result * result);
            double height = (h1 * h2) / (h1 + h2);

            if (height >= c) {
                left = result;
            } else {
                right = result;
            }
        }
        return right;
    }
}
