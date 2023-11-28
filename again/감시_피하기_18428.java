package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 감시_피하기_18428 {
    public static int N, answer;
    public static int[][] arr;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                String temp = st.nextToken();

                if (temp.equals("X")) {
                    arr[i][j] = 0;
                } else if (temp.equals("S")) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 2;
                }
            }
        }

        answer = 0;

        dfs(0, 0, 0);

        if (answer == 1) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int r, int c, int cnt) {
        if (cnt == 3) {
            boolean result = true;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 2) {
                        continue;
                    }

                    boolean findStudent = check(i, j);

                    if (findStudent) {
                        result = false;
                        break;
                    }
                }

                if (!result) {
                    break;
                }
            }

            if (result) {
                answer = 1;
            }

            return;
        }

        for (int i = c + 1; i < N; i++) {
            if (arr[r][i] != 0) {
                continue;
            }

            arr[r][i] = 3;
            dfs(r, i, cnt+1);
            arr[r][i] = 0;
        }

        for (int i = r + 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] != 0) {
                    continue;
                }

                arr[i][j] = 3;
                dfs(i, j, cnt+1);
                arr[i][j] = 0;
            }
        }
    }

    public static boolean check(int x, int y) {
        for (int j = 0; j < 4; j++) {
            int r = x;
            int c = y;

            while (true) {
                r += dr[j];
                c += dc[j];

                if (r < 0 || r >= N || c < 0 || c >= N) {
                    break;
                }

                if (arr[r][c] == 3) {
                    break;
                } else if (arr[r][c] == 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
