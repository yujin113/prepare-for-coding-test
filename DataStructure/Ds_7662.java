package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ds_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> isAdded = new HashMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String operator = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (operator.equals("I")) {
                    minQ.add(num);
                    maxQ.add(num);
                    if (isAdded.containsKey(num)) {
                        isAdded.put(num, isAdded.get(num) + 1);
                    } else {
                        isAdded.put(num, 1);
                    }
                }
                if (!maxQ.isEmpty() && operator.equals("D") && num == 1) {
                    popQueue(maxQ, isAdded);
                }
                if (!minQ.isEmpty() && operator.equals("D") && num == -1) {
                    popQueue(minQ, isAdded);
                }
            }

            boolean isEmpty = true;
            while (!maxQ.isEmpty()) {
                Integer poll = maxQ.poll();
                if (isAdded.get(poll) > 0) {
                    sb.append(poll).append(" ");
                    isEmpty = false;
                    break;
                }
            }
            while (!minQ.isEmpty()) {
                Integer poll = minQ.poll();
                if (isAdded.get(poll) > 0) {
                    sb.append(poll).append("\n");
                    isEmpty = false;
                    break;
                }
            }
            if (isEmpty) {
                sb.append("EMPTY").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void popQueue(PriorityQueue<Integer> q, Map<Integer, Integer> isAdded) {
        boolean flag = false;
        while (!q.isEmpty() && !flag) {
            Integer key = q.poll();
            int value = isAdded.get(key);
            if (value > 0) {
                isAdded.put(key, value - 1);
                flag = true;
            }
        }
    }
}
