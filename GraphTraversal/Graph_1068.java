package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph_1068 {
    static int[] arr;
    static boolean[] removed;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        removed = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        removeNode(Integer.parseInt(br.readLine()));

        int root = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == -1) {
                root = i;
            }
        }
        if (removed[root]) {
            System.out.println("0");
        } else {
            System.out.println(findLeaf(root));
        }
    }

    static void removeNode(int n) {
        removed[n] = true;
        for (int i = 0; i < N; i++) {
            if (removed[i]) continue;
            if (arr[i] == n) {
                removeNode(i);
            }
        }
    }

    static int findLeaf(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int cnt = 0;

        while (!q.isEmpty()) {
            Integer num = q.poll();

            boolean isLeaf = true;
            for (int i = 0; i < N; i++) {
                if (!removed[i] && arr[i] == num) {
                    q.add(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) {
                cnt++;
            }
        }
        return cnt;
    }
}
