package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dp_1149 {
    static class RGB {
        int r, g, b;

        public RGB(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        RGB[] arr = new RGB[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new RGB(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(dp(arr, N));
    }

    private static int dp(RGB[] arr, int N) {
        for (int i = 1; i < N; i++) {
            arr[i].r += Math.min(arr[i - 1].g, arr[i - 1].b);

            arr[i].g += Math.min(arr[i - 1].r, arr[i - 1].b);

            arr[i].b += Math.min(arr[i - 1].r, arr[i - 1].g);
        }

        int min = Math.min(arr[N - 1].r, arr[N - 1].g);
        return Math.min(min, arr[N - 1].b);
    }
}
