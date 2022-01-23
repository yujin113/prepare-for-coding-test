package GraphTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Graph_16236 {
    static class Node {
        int row, col, time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int[][] arr;
    static Node shark;
    static int[] moveR = {0, 1, 0, -1};
    static int[] moveC = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) {
                    shark = new Node(i, j, 0);
                    // 상어 위치 저장 후 배열에는 꼭 0으로 저장해줘야 함!
                    arr[i][j] = 0;
                }
            }
        }

        bfs(N);
    }

    private static void bfs(int N) {
        int size = 2;
        int eat = 0;
        int result = 0;
        boolean[][] visited = new boolean[N][N];

        Queue<Node> q = new LinkedList<>();
        q.add(shark);
        visited[shark.row][shark.col] = true;
        ArrayList<Node> fishes = new ArrayList<>();

        // 탐색 -> 먹기를 반복
        while (true) {
            // 배열 탐색
            while (!q.isEmpty()) {
                Node node = q.poll();

                for (int i = 0; i < 4; i++) {
                    int row = node.row + moveR[i];
                    int col = node.col + moveC[i];

                    if (row >= 0 && col >= 0 && row < N && col < N) {
                        if (visited[row][col]) continue;
                        visited[row][col] = true;

                        if (arr[row][col] < size && arr[row][col] != 0) {
                            // 상어 크기보다 작고 0이 아니면 물고기를 먹으므로 큐와 fishes에 둘 다 추가
                            q.add(new Node(row, col, node.time + 1));
                            fishes.add(new Node(row, col, node.time + 1));
                        } else if (arr[row][col] == size || arr[row][col] == 0){
                            // 상어 크기와 같거나 0이면 큐에만 추가
                            q.add(new Node(row, col, node.time + 1));
                        }
                    }
                }
            }

            // 물고기 먹을 순서 정하기
            if (!fishes.isEmpty()) {
                // 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
                Collections.sort(fishes, new Comparator<Node>() {
                    @Override
                    public int compare(Node o1, Node o2) {
                        if (o1.time == o2.time) {
                            if (o1.row == o2.row) {
                                if (o1.col > o2.col) {
                                    return 1;
                                } else {
                                    return -1;
                                }
                            } else if (o1.row > o2.row) {
                                return 1;
                            } else {
                                return -1;
                            }
                        } else if (o1.time > o2.time) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                });
                // 상어 위치 이동
                Node now = fishes.get(0);
                shark.row = now.row;
                shark.col = now.col;
                // 상어 크기 증가
                if (++eat == size) {
                    size += 1;
                    eat = 0;
                }
                // 시간 증가, 먹은 곳 0으로 없애기, ArrayList 초기화
                result += now.time;
                arr[now.row][now.col] = 0;
                fishes.clear();

                // 큐에 상어 다시 넣기
                q.clear();
                q.add(shark);
                visited = new boolean[N][N];
                visited[shark.row][shark.col] = true;
            } else {
                // 더 이상 먹을 물고기가 없으므로 결과 출력 후 리턴
                System.out.println(result);
                return;
            }
        }
    }
}
