package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bs_8983 {
    static class Animal {
        int x, y;

        public Animal(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] shoot;
    static Animal[] animals;
    static int M, N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        shoot = new int[M];
        for (int i = 0; i < M; i++) {
            shoot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shoot);

        animals = new Animal[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            animals[i] = new Animal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for (Animal animal : animals) {
            result += search(animal);
        }
        System.out.println(result);
    }

    private static int search(Animal animal) {
        int left = 0;
        int right = M;
        while (left <= right) {
            int mid = (left + right) / 2;

            int distance = Math.abs(animal.x - shoot[mid]) + animal.y;

            if (distance <= L)
                return 1;

            if (animal.x < shoot[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }
}
