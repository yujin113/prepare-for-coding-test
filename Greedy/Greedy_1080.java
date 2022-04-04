package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Greedy_1080 {
    static int[][] before, after;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        before = new int[N][M];
        after = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                before[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                after[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        System.out.println(greedy(N, M));
    }

    private static int greedy(int N, int M) {
        int count = 0;

        for (int i = 0; i <= N - 3; i++) {
            for (int j = 0; j <= M - 3; j++) {

                if (before[i][j] != after[i][j]) {
                    count += 1;
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            if (before[k][l] == 0) {
                                before[k][l] = 1;
                            } else {
                                before[k][l] = 0;
                            }
                        }
                    }
                }

            }
        }
        if (compare(N, M)) return count;

        return -1;
    }

    private static boolean compare(int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (before[i][j] != after[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
