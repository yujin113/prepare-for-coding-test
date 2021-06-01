package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Example {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 71; i++) {
            Double n = Double.parseDouble(br.readLine());
//            calc(0.01208, n);
//            calc(0.01661, n);
//            calc(0.02114, n);
//            calc(0.02567, n);
//            calc(0.0302, n);

//            calc(0.00765, n);
//            calc(0.01515, n);
//            calc(0.02265, n);
//            calc(0.03015, n);
            calc(0.03765, n);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void calc(Double temp, Double n) {
        Double res = Math.round((temp * n * n) * 100) / 100.0;
        sb.append(res).append(" ");
    }
}
