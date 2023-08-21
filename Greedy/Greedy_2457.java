package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_2457 {
    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start) {
                if (this.end == o.end) {
                }
                return o.end - this.end;
            }
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] flowers = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            flowers[i] = new Node(start, end);
        }

        Arrays.sort(flowers);

        int start = 301;
        int end = 1201;
        int index = 0;
        int maxEnd = 0;
        int count = 0;

        while (start < end) {
            boolean isFind = false;

            for (int i = index; i < flowers.length; i++) {
                if (flowers[i].start <= start) {
                    if (maxEnd < flowers[i].end) {
                        maxEnd = flowers[i].end;
                        index = i + 1;
                        isFind = true;
                    }
                }
            }

            if (isFind) {
                start = maxEnd;
                count++;
            } else {
                break;
            }
        }

        if (maxEnd < end) {
            System.out.println("0");
        } else {
            System.out.println(count);
        }
    }
}
