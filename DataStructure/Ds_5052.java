package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ds_5052 {
    static class Tree {
        Tree[] next = new Tree[10];
        boolean isEnd;

        public boolean check(String tel) {
            Tree tree = this;

            for (int i = 0; i < tel.length(); i++) {
                int num = tel.charAt(i) - '0';

                if (tree.next[num] == null) {
                    tree.next[num] = new Tree();
                    tree.next[num].isEnd = (i == tel.length() - 1);
                } else {
                    if (tree.next[num].isEnd) {
                        return false;
                    }
                }
                tree = tree.next[num];
            }

            return true;
        }
    }

    static boolean result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);
            Tree tree = new Tree();
            result = true;

            for (int i = 0; i < n; i++) {
                String tel = arr[i];
                boolean checked = tree.check(tel);
                if (!checked) {
                    result = false;
                    break;
                }
            }

            if (result) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
