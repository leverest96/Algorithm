package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 무기공학_18430 {
    public static int N, M;
    public static int[][] arr;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if ((N == 1 && M == 2) || (N == 2 && M == 1) || (N == 1 && M == 1)) {
            bw.write(String.valueOf(0));
        } else {
            arr = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int max = 0;
                    max += arr[i][j] * 2;

                    int[] temp = new int[4];

                    for (int k = 0; k < 4; k++) {
                        int row = i + dr[i];
                        int col = j + dc[i];

                        if (row >= 0 && row < N && col >= 0 && col < M) {
                            temp[k] = arr[row][col];
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        int end = k + 1 < 4 ? k + 1 : 0;

                        if (temp[k] != 0 && temp[end] != 0) {
                            max += temp[k] + temp[end];
                            result = Math.max(max, result);
                            max -= temp[k] + temp[end];
                        }
                    }
                }
            }

            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
    }
}
