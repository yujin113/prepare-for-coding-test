package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bs_16434 {
    static class Node {
        int t;
        int a;
        int h;

        public Node(int t, int a, int h) {
            this.t = t;
            this.a = a;
            this.h = h;
        }
    }

    static Node[] arr;
    static long atk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        arr = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Node(t, a, h);
        }

        System.out.println(bs(0, Long.MAX_VALUE));
    }

    private static long bs(long left, long right) {
        while (left <= right) {
            long mid = (left + right) / 2;

            int result = enter(mid);

            if (result < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static int enter(long maxHp) {
        long curAtk = atk;
        long curHp = maxHp;

        for (Node node : arr) {
            if (node.t == 1) {
                if (node.h % curAtk == 0) {
                    curHp -= (node.h / curAtk - 1) * node.a;
                } else {
                    curHp -= (node.h / curAtk) * node.a;
                }

                if (curHp <= 0) {
                    return -1;
                }
            }
            if (node.t == 2) {
                curAtk += node.a;
                curHp += node.h;
                if (curHp > maxHp) {
                    curHp = maxHp;
                }
            }
        }

        return 1;
    }
}
