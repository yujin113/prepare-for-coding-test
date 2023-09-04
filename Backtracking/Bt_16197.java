package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bt_16197 {
    static char[][] map;
    static int N, M;
    static Coin coin = null;
    static int[][] move = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'o') {
                    if (coin == null) {
                        coin = new Coin(i, j);
                    } else {
                        coin.setX2(i);
                        coin.setY2(j);
                    }
                }
            }
        }

        backtracking(0);

        if (result == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    private static void backtracking(int cnt) {
        if (cnt >= result || cnt == 10) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int outCount = 0;
            Coin originCoin = new Coin(coin.x1, coin.y1, coin.x2, coin.y2);

            int dx1 = coin.x1 + move[i][0];
            int dy1 = coin.y1 + move[i][1];
            int dx2 = coin.x2 + move[i][0];
            int dy2 = coin.y2 + move[i][1];

            if (isOut(dx1, dy1)) {
                outCount++;
            }
            if (isOut(dx2, dy2)) {
                outCount++;
            }

            if (outCount == 1) {
                result = Math.min(result, cnt + 1);
                break;
            }
            if (outCount == 2) {
                continue;
            }

            if (!isOut(dx1, dy1) && map[dx1][dy1] != '#') {
                coin.x1 = dx1;
                coin.y1 = dy1;
            }
            if (!isOut(dx2, dy2) && map[dx2][dy2] != '#') {
                coin.x2 = dx2;
                coin.y2 = dy2;
            }

            backtracking(cnt + 1);

            coin = originCoin;
        }
    }

    private static boolean isOut(int dx, int dy) {
        return dx < 0 || dy < 0 || dx >= N || dy >= M;
    }

    static class Coin {
        int x1;
        int y1;
        int x2;
        int y2;

        public Coin(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public Coin(int x1, int y1) {
            this.x1 = x1;
            this.y1 = y1;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }
    }
}
