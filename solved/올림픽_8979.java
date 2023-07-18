package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 올림픽_8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long sum = 0;
            int location = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 1; j < 4; j++) {
                long score = 1;
                for (int k = j; k < 3; k++) {
                    score *= 2000000;
                }
                sum += Long.parseLong(st.nextToken()) * score;
            }
            arr[location] = sum;
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > arr[M - 1]) cnt++;
        }

        bw.write(cnt + 1 + "");

        bw.flush();
        bw.close();
    }
}
