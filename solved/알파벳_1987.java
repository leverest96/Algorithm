package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 알파벳_1987 {
    public static int R, C, result;
    public static char[][] arr;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        boolean[] visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();

            for (int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        result = 0;

        int start = arr[0][0] - 65;

        visited[start] = true;

        dfs(0, 0, 1, visited);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c, int max, boolean[] visited) {
        for (int i = 0; i < 4; i++) {
            int row = r + dr[i];
            int col = c + dc[i];

            if (row < 0 || row >= R || col < 0 || col >= C) {
                result = Math.max(max, result);
                continue;
            }

            int visit = arr[row][col] - 65;

            if (!visited[visit]) {
                visited[visit] = true;
                result = Math.max(max + 1, result);
                dfs(row, col, max + 1, visited);
                visited[visit] = false;
            } else {
                result = Math.max(max, result);
            }
        }
    }
}
