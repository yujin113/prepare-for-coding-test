package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_1931 {
    static class Node implements Comparable<Node> {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            // 끝나는 시간 기준으로 오름차순 정렬, 같으면 시작 시간 기준 오름차순 정렬
            if (end == o.end)
                return start - o.start;
            return end - o.end;
        }
    }

    static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[i] = new Node(s, e);
        }
        Arrays.sort(arr);

        int result = calc();
        System.out.println(result);
    }

    private static int calc() {
        int result = 0;
        int time = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].start >= time) {
                result++;
                time = arr[i].end;
            }
        }

        return result;
    }
}
