package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dac_6549 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line.equals("0"))
                break;

            StringTokenizer st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long result = calcMax(0, N - 1);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static long calcMax(int left, int right) {
        if (left == right) return arr[left];

        int mid = (left + right) / 2;
        long area = Math.max(calcMax(left, mid), calcMax(mid + 1, right));

        int goL = mid;
        int goR = mid;
        long height = arr[mid];
        area = Math.max(area, height);

        while (left < goL || goR < right) {
            if (left < goL && (goR == right || arr[goL - 1] > arr[goR + 1])) {
                goL -= 1;
                height = Math.min(height, arr[goL]);
            } else {
                goR += 1;
                height = Math.min(height, arr[goR]);
            }
            area = Math.max(area, height * (goR - goL + 1));
        }

        return area;
    }
}
