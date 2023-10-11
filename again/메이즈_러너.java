package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 메이즈_러너 {
    static int[][] maze;
    static int N, M, K, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            maze[r][c]--;
        }

        st = new StringTokenizer(br.readLine());

        int exitR = Integer.parseInt(st.nextToken());
        int exitC = Integer.parseInt(st.nextToken());

        maze[exitR][exitC] = 10;

        while (K-- > 0) {
            move();

            if (isFinish()) {
                break;
            }

            rotateMaze();
        }

        bw.write(String.valueOf(cnt));
        bw.newLine();

        int[] arr = findExit();
        bw.write(arr[0] + " " + arr[1]);

        bw.flush();
        bw.close();
    }

    static void move() {
        int[][] newMaze = new int[N + 1][N + 1];

        int[] arr = findExit();

        int exitR = arr[0];
        int exitC = arr[1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] > 0) {
                    newMaze[i][j] = maze[i][j];
                    continue;
                }

                if (maze[i][j] == 0) {
                    continue;
                }

                int curDist = Math.abs(i - exitR) + Math.abs(j - exitC);

                int minDist = curDist;
                int minI = 0;
                int minJ = 0;

                int[][] dirs = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

                for (int k = 0; k < 4; k++) {
                    int ni = i + dirs[k][0];
                    int nj = j + dirs[k][1];

                    if (ni < 1 || nj < 1 || ni > N || nj > N) continue;

                    if (1 <= maze[ni][nj] && maze[ni][nj] <= 9) continue;

                    int dist = Math.abs(ni - exitR) + Math.abs(nj - exitC);

                    if (minDist > dist) {
                        minDist = dist;
                        minI = ni;
                        minJ = nj;
                    }
                }

                if (minDist == curDist) {
                    newMaze[i][j] += maze[i][j];
                    continue;
                }

                cnt -= maze[i][j];

                if (maze[minI][minJ] == 10) {
                    continue;
                }

                newMaze[minI][minJ] += maze[i][j];
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                maze[i][j] = newMaze[i][j];
            }
        }
    }

    static boolean isFinish() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static int[] findExit() {
        int[] arr = new int[2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] == 10) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }

        return arr;
    }

    static void rotateMaze() {
        int min = Integer.MAX_VALUE;

        int[] arr = findExit();

        int exitR = arr[0];
        int exitC = arr[1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (maze[i][j] >= 0) continue;

                int dist = Math.max(Math.abs(i - exitR), Math.abs(j - exitC));

                min = Math.min(min, dist);
            }
        }

        int row = 0;
        int col = 0;

        Loop:
        for (int i = 1; i <= N - min; i++) {
            for (int j = 1; j <= N - min; j++) {
                boolean flagExit = false;
                boolean flagPerson = false;

                for (int k = i; k <= i + min; k++) {
                    for (int l = j; l <= j + min; l++) {
                        if (maze[k][l] == 10) flagExit = true;
                        if (maze[k][l] < 0) flagPerson = true;
                    }
                }

                if (flagExit && flagPerson) {
                    row = i;
                    col = j;
                    break Loop;
                }
            }
        }

        int[][] a = new int[15][15];
        int[][] b = new int[15][15];

        for (int i = row; i <= row + min; i++) {
            for (int j = col; j <= col + min; j++) {
                a[i - row + 1][j - col + 1] = maze[i][j];
            }
        }

        int n = min + 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (1 <= a[i][j] && a[i][j] <= 9) {
                    a[i][j]--;
                }

                b[j][n + 1 - i] = a[i][j];
            }
        }

        for (int i = row; i <= row + min; i++) {
            for (int j = col; j <= col + min; j++) {
                maze[i][j] = b[i - row + 1][j - col + 1];
            }
        }
    }
}
