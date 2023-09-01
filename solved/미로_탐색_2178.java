package Algorithm.solved;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색_2178 {
    static boolean[][] visited;
    static char[][] arr;
    static int N, M, min;
    static int[] rd = {-1, 1, 0, 0};
    static int[] cd = {0, 0, -1, 1};

    static class Node {
        int r;
        int c;
        int cnt;

        Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                char now = line.charAt(j);

                arr[i][j] = now;
            }
        }

        min = Integer.MAX_VALUE;

        visited = new boolean[N][M];

        bfs(new Node(0, 0, 0));

        bw.write(min + 1 + "");
        bw.flush();
        bw.close();
    }

    static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        visited[node.r][node.c] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            for(int i = 0; i < 4; i++) {
                int next_r = now.r + rd[i];
                int next_c = now.c + cd[i];
                int cnt = now.cnt;

                if (next_r == N - 1 && next_c == M - 1) min = Math.min(min, ++cnt);

                if (next_r < 0 || next_r >= N || next_c < 0 || next_c >= M) continue;

                if(arr[next_r][next_c] == '1' && !visited[next_r][next_c]) {
                    visited[next_r][next_c] = true;

                    queue.offer(new Node(next_r, next_c, ++cnt));
                }
            }
        }
    }
}
