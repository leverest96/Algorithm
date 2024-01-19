package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 무기_공학_18430 {
    public static int N, M, max;
    public static int[][] arr;

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

        boolean[][] visited = new boolean[N][M];

        max = 0;

        dfs(visited, 0, 0, 0);

        bw.write(max + "");

        bw.flush();
        bw.close();
    }

    public static void dfs(boolean[][] visited, int r, int c, int sum) {
        if (r == N) {
            max = Math.max(max, sum);
            return;
        }

        if (!visited[r][c]) {
            if (r + 1 < N && c + 1 < M && !visited[r + 1][c] && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r + 1][c] = true;
                visited[r][c + 1] = true;

                if (c + 1 == M) {
                    dfs(visited, r + 1, 0, sum + 2 * arr[r][c] + arr[r + 1][c] + arr[r][c + 1]);
                } else {
                    dfs(visited, r, c + 1, sum + 2 * arr[r][c] + arr[r + 1][c] + arr[r][c + 1]);
                }

                visited[r][c] = false;
                visited[r + 1][c] = false;
                visited[r][c + 1] = false;
            }

            if (r + 1 < N && c - 1 >= 0 && !visited[r + 1][c] && !visited[r][c - 1]) {
                visited[r][c] = true;
                visited[r + 1][c] = true;
                visited[r][c - 1] = true;

                if (c + 1 == M) {
                    dfs(visited, r + 1, 0, sum + 2 * arr[r][c] + arr[r + 1][c] + arr[r][c - 1]);
                } else {
                    dfs(visited, r, c + 1, sum + 2 * arr[r][c] + arr[r + 1][c] + arr[r][c - 1]);
                }

                visited[r][c] = false;
                visited[r + 1][c] = false;
                visited[r][c - 1] = false;
            }

            if (r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c] && !visited[r][c - 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c - 1] = true;

                if (c + 1 == M) {
                    dfs(visited, r + 1, 0, sum + 2 * arr[r][c] + arr[r - 1][c] + arr[r][c - 1]);
                } else {
                    dfs(visited, r, c + 1, sum + 2 * arr[r][c] + arr[r - 1][c] + arr[r][c - 1]);
                }

                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c - 1] = false;
            }

            if (r - 1 >= 0 && c + 1 < M && !visited[r - 1][c] && !visited[r][c + 1]) {
                visited[r][c] = true;
                visited[r - 1][c] = true;
                visited[r][c + 1] = true;

                if (c + 1 == M) {
                    dfs(visited, r + 1, 0, sum + 2 * arr[r][c] + arr[r - 1][c] + arr[r][c + 1]);
                } else {
                    dfs(visited, r, c + 1, sum + 2 * arr[r][c] + arr[r - 1][c] + arr[r][c + 1]);
                }

                visited[r][c] = false;
                visited[r - 1][c] = false;
                visited[r][c + 1] = false;
            }
        }

        if (c + 1 == M) {
            dfs(visited, r + 1, 0, sum);
        } else {
            dfs(visited, r, c + 1, sum);
        }
    }
}
