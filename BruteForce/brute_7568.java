package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class brute_7568 {
    static class Person {
        int height, weight, rate;

        Person(int height, int weight, int rate) {
            this.height = height;
            this.weight = weight;
            this.rate = rate;
        }
    }
    static Person[] arr;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new Person[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Person(h, w, 1);
        }

        for (int i = 0; i < n; i++) {
            func(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].rate + " ");
        }
    }

    private static void func(int num) {
        int h = arr[num].height;
        int w = arr[num].weight;

        for (int i = 0; i < n; i++) {
            if (i == num) continue;

            if (h > arr[i].height && w > arr[i].weight) {
                arr[i].rate += 1;
            }
        }
    }
}
