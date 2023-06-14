package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기_1018 {
    static int N, M, min;
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {
                sort(i, j);
            }
        }

        bw.write(min + "");
        bw.flush();
        bw.close();
    }

    static void sort(int i, int j) {
        char init = arr[i][j];
        int cnt = 0;

        for (int k = i; k < i+8; k++) {
            for (int l = j; l < j+8; l++) {
                if (arr[k][l] != init) {
                    cnt++;
                }
                if (init == 'B') init = 'W';
                else init = 'B';
            }
            if (init == 'B') init = 'W';
            else init = 'B';
        }

        min = Math.min(min, Math.min(cnt, 64-cnt));
    }
}