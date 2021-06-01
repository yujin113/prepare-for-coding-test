package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DfsBfs_1963 {
    static int res;
//    static int[] arr = new int[4];
//    static int[] arr2 = new int[4];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
//            for (int j = 0; j < 4; j++) {
//                arr[j] = Integer.parseInt(str1.substring(j, j + 1));
//                arr2[j] = Integer.parseInt(str2.substring(j, j + 1));
//            }
            res = 999999;
//            dfs(0);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

//    private static void bfs(String str1, String str2) {
//        Queue<String> q = new LinkedList<>();
//        if ()
//
//        while(!q.isEmpty()) {
//
//        }
//    }

//    private static void dfs(int count) {
//        if (makeStr(arr).equals(makeStr(arr2))) {
//            if (res > count) res = count;
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int temp = arr[i];
//            arr[i] = arr2[i];
//            System.out.println(makeStr(arr));
//            if (test(arr)) {
//                //System.out.println(makeStr(arr));
//                dfs(count + 1);
////                arr[i] = temp;
//            } else {
//                for (int j = 0; j <= 9; j++) {
//                    if (i == 0 && j == 0) continue;
//                    System.out.println(i+ " " + j);
//                    arr[i] = j;
//                    if (test(arr)) {
//                        System.out.println(makeStr(arr) + "!!");
//                        dfs(count + 1);
////                        arr[i] = temp;
//                    }
//                }
//            }
//        }
//    }

    private static String makeStr(int[] arr) {
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += arr[i];
        }
        return str;
    }

    private static boolean test(int[] arr) {
        int num = Integer.parseInt(makeStr(arr));
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false; // 소수 아님
        }
        return true; // 소수임
    }
}
