package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 마인크래프트_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
            }
        }

        int time = 64000000;
        int high = 0;

        for (int i = min; i <= max; i++) {
            int count = 0;
            int pocket = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < arr[j][k]) {
                        count += (arr[j][k] - i) * 2;
                        pocket += arr[j][k] - i;
                    } else {
                        count += i - arr[j][k];
                        pocket -= i - arr[j][k];
                    }
                }
            }

            if (pocket < 0) break;
            if (time >= count) {
                time = count;
                high = i;
            }
        }

        bw.write(time + " " + high);

        bw.flush();
        bw.close();
    }
}
