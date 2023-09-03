package Algorithm.again;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토_7569 {
    static int M, N, H, cnt;
    static int[] rd = {-1, 1, 0, 0, 0, 0};
    static int[] cd = {0, 0, -1, 1, 0, 0};
    static int[] hd = {0, 0, 0, 0, -1, 1};
    static int[][][] arr;
    static Queue<Node> queue;

    static class Node {
        int r;
        int c;
        int h;

        Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[N][M][H];

        queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());

                for (int c = 0; c < M; c++) {
                    arr[r][c][h] = Integer.parseInt(st.nextToken());

                    if (arr[r][c][h] == 1) {
                        queue.offer(new Node(r, c, h));
                    }
                }
            }
        }

        cnt = 0;

        if (check()) bw.write("0");
        else {
            cnt = 0;

            bfs();

            if (check()) {
                bw.write(cnt - 1 + "");
            } else {
                bw.write("-1");
            }
        }

        bw.flush();
        bw.close();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextR = now.r + rd[i];
                int nextC = now.c + cd[i];
                int nextH = now.h + hd[i];

                if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && nextH >= 0 && nextH < H) {
                    if (arr[nextR][nextC][nextH] == 0) {
                        arr[nextR][nextC][nextH] = arr[now.r][now.c][now.h] + 1;
                        queue.offer(new Node(nextR, nextC, nextH));
                    }
                }
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[j][k][i] == 0) return false;
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    cnt = Math.max(cnt, arr[j][k][i]);
                }
            }
        }

        return true;
    }
}
