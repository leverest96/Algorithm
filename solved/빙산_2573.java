package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 빙산_2573 {
    public static int[][] arr;
    public static int N, M;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

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

        int time = 0;

        while (true) {
            divide();
            time++;

            boolean[][] visited = new boolean[N][M];

            int check = check(visited);

            if (check == 1) {
                break;
            } else if (check == 2) {
                time = 0;
                break;
            }
        }

        bw.write(String.valueOf(time));

        bw.flush();
        bw.close();
    }

    public static void divide() {
        int[][] copied = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copied[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int r = i + dr[k];
                        int c = j + dc[k];

                        if (r >= 0 && r < N && c >= 0 && c < M && arr[r][c] == 0) {
                            copied[i][j] = Math.max(copied[i][j] - 1, 0);
                        }
                    }
                }
            }
        }

        arr = copied;
    }

    public static int check(boolean[][] visited) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);

                    cnt++;
                }
            }
        }

        if (cnt > 1) {
            return 1;
        } else if (cnt == 0) {
            return 2;
        }

        return 0;
    }

    public static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int k = 0; k < 4; k++) {
            int rd = r + dr[k];
            int cd = c + dc[k];

            if (rd >= 0 && rd < N && cd >= 0 && cd < M && arr[rd][cd] != 0 && !visited[rd][cd]) {
                dfs(rd, cd, visited);
            }
        }
    }
}
