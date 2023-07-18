package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                search(i, j, 1, arr[i][j], visited);
                visited[i][j] = false;
                check(i, j);
            }
        }

        bw.write(max + "");

        bw.flush();
        bw.close();
    }

    static void search(int xd, int yd, int level, int sum, boolean[][] visited) {
        if (level >= 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = xd + dx[i];
            int y = yd + dy[i];
            if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) continue;

            visited[x][y] = true;
            search(x, y, level + 1, sum + arr[x][y], visited);
            visited[x][y] = false;
        }
    }

    static void check(int y, int x) {
        if (y < N - 2 && x < M - 1)
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x + 1]);

        if (y < N - 2 && x > 0)
            max = Math.max(max, arr[y][x] + arr[y + 1][x] + arr[y + 2][x] + arr[y + 1][x - 1]);

        if (y < N - 1 && x < M - 2)
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y + 1][x + 1]);

        if (y > 0 && x < M - 2)
            max = Math.max(max, arr[y][x] + arr[y][x + 1] + arr[y][x + 2] + arr[y - 1][x + 1]);
    }
}
