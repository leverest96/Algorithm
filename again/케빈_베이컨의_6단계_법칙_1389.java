package Algorithm.again;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 케빈_베이컨의_6단계_법칙_1389 {
    static int[][] arr;
    static boolean[] visit;

    static int N, M, result;
    static int min_count = Integer.MAX_VALUE;

    static class Bacon {
        int num;
        int value;

        public Bacon(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 유저의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        arr = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
            arr[x][y] = 1;
        }

        for(int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];

            BFS(i);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static void BFS(int start) {
        Queue<Bacon> queue = new LinkedList<>();
        int count = 0;

        visit[start] = true;
        queue.offer(new Bacon(start, 0));

        while(!queue.isEmpty()) {
            Bacon bacon = queue.poll();
            count += bacon.value;

            for(int i=1; i<=N; i++) {
                int num = arr[bacon.num][i];

                if(num == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.offer(new Bacon(i, bacon.value + 1));
                }
            }
        }

        if(min_count > count) {
            min_count = count;
            result = start;
        }
    }
}
