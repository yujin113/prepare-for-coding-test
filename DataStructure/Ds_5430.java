package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ds_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String p = br.readLine(); //함수
            int n = Integer.parseInt(br.readLine()); //배열 원소 개수
            String line = br.readLine();
            String[] arr = (line.substring(1, line.length() - 1)).split(",");
            Deque<Integer> deq = new ArrayDeque<>();
            if (line.length() > 2) {
                for (String s : arr) {
                    deq.add(Integer.parseInt(s));
                }
            }
            result.append(calc(deq, p)).append("\n");
        }

        System.out.println(result);
    }

    static String calc(Deque<Integer> deq, String p) {
        StringBuilder res = new StringBuilder();
        boolean reverse = false;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == 'R') {
                reverse = !reverse;
            }
            if (c == 'D') {
                if (deq.size() == 0) {
                    return "error";
                } else {
                    if (reverse) {
                        deq.removeLast();
                    } else {
                        deq.removeFirst();
                    }
                }
            }
        }

        if (deq.size() == 0) {
            res.append("[]");
        } else {
            res.append("[");
        }

        if (reverse) {
            while (deq.size() != 0) {
                if (deq.size() == 1) {
                    res.append(deq.pollLast()).append("]");
                } else {
                    res.append(deq.pollLast()).append(",");
                }
            }
        } else {
            while (deq.size() != 0) {
                if (deq.size() == 1) {
                    res.append(deq.pollFirst()).append("]");
                } else {
                    res.append(deq.pollFirst()).append(",");
                }
            }
        }
        return res.toString();
    }
}
