package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Bs_2866 {
    static String[] arr;
    static int R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);
        arr = new String[C];
        for (int i = 0; i < C; i++) {
            arr[i] = "";
        }
        for (int i = 0; i < R; i++) {
            str = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                arr[j] += str[j];
            }
        }

        System.out.println(bs(0, R - 1));
    }

    static int bs(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    static boolean check(int start) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < C; i++) {
            set.add(arr[i].substring(start, R));
        }

        if (set.size() == C) {
            return true;
        } else {
            return false;
        }
    }
}