package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Greedy_1541 {
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '-') {
                list.add(sb.toString());
                list.add("-");
                sb = new StringBuilder();
                continue;
            }
            if (c == '+') {
                list.add(sb.toString());
                sb = new StringBuilder();
                continue;
            }
            sb.append(c);
        }
        list.add(sb.toString());

        System.out.println(calc());
    }

    private static int calc() {
        int result = 0;
        int sum = 0;
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("-")) {
                temp = i + 1;
                break;
            }
            result += Integer.parseInt(list.get(i));
        }

        if (temp != 0) {
            for (int i = temp; i < list.size(); i++) {
                if (list.get(i).equals("-")) {
                    result -= sum;
                    sum = 0;
                    continue;
                }
                sum += Integer.parseInt(list.get(i));
            }
            result -= sum;
        }
        return result;
    }
}
