package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();
        String[] st = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st[i]));
        }

        int M = Integer.parseInt(br.readLine());
        st = br.readLine().split(" ");
        ArrayList<Integer> box = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            box.add(Integer.parseInt(st[i]));
        }

        crane.sort(Collections.reverseOrder());
        box.sort(Collections.reverseOrder());

        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while (!box.isEmpty()) {
            for (int i = 0; i < crane.size(); i++) {
                for (int j = 0; j < box.size(); j++) {
                    if (crane.get(i) >= box.get(j)) {
                        box.remove(j);
                        break;
                    }
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
