package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 무기공학_18430 {
    public static int N, M, max;
    public static int[][] arr;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean[][] visited = new boolean[N][M];

                check(i, j, visited, max);
            }
        }

        bw.flush();
        bw.close();
    }

    public static void check(int r, int c, boolean[][] visited, int max) {
        if (visited[r][c]) return;

        for (int i = 0; i < 4; i++) {
            int rd1 = r + dr[i];
            int cd1 = c + dc[i];

            if (rd1 < 0 || rd1 > N || cd1 < 0 || cd1 > N) continue;

            int ing = i + 1 > 3 ? 0 : i + 1;

            int rd2 = r + dr[ing];
            int cd2 = c + dc[ing];

            if (rd2 < 0 || rd2 > N || cd2 < 0 || cd2 > N) continue;

            visited[rd1][cd1] = true;
            visited[rd2][cd2] = true;
            visited[rd1][cd1] = false;
            visited[rd2][cd2] = false;
        }
    }
}
