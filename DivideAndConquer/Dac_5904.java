package DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dac_5904 {
    static ArrayList<Integer> cnt = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cnt.add(3);
        int count = 0;
        int index = 1;
        while (count < N) {
            Integer n = cnt.get(index - 1);
            count = n + (1 + index + 2) + n;
            cnt.add(count);
            index++;
        }
        index--;
//        System.out.println("index " + index);

        while (index > 0) {
            if (!middle(N, index)) {
                if (N > cnt.get(index - 1)) {
                    N -= (cnt.get(index - 1) + 3 + index);
                }
            } else {
                return;
            }
            index--;
        }

//        System.out.println(N);
        if (N == 1) {
            System.out.println("m");
        } else if (N == 2 || N == 3) {
            System.out.println("o");
        }
    }

    private static boolean middle(int N, int index) {
//        System.out.println(N + "~~~~~~~~~~~");
        if (N > cnt.get(index - 1) && N <= (cnt.get(index) - cnt.get(index - 1))) {
            if (N == cnt.get(index - 1) + 1) {
                System.out.println("m");
                return true;
            } else {
                System.out.println("o");
                return true;
            }
        }
        return false;
    }
}
