package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ds_2841 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int P = Integer.parseInt(str[1]);
        Stack<Integer>[] list = new Stack[7];
        for (int i = 1; i < 7; i++) {
            list[i] = new Stack<>();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            int line = Integer.parseInt(str[0]);
            int fret = Integer.parseInt(str[1]);

            while (!list[line].isEmpty() && list[line].peek() > fret) {
                list[line].pop();
                count++;
            }
            if (list[line].isEmpty() || list[line].peek() != fret) {
                list[line].push(fret);
                count++;
            }
        }
        System.out.println(count);
    }
}
