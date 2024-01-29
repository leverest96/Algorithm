package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 주유소_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] roadArr = new long[N - 1];
        long[] literArr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N - 1; i++) {
            roadArr[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            literArr[i] = Long.parseLong(st.nextToken());
        }

        long cost = literArr[0] * roadArr[0];

        long temp = literArr[0];

        for (int i = 1; i < N - 1; i++) {
            if (temp >= literArr[i]) {
                temp = literArr[i];
            }

            cost += temp * roadArr[i];
        }

        bw.write(String.valueOf(cost));

        bw.flush();
        bw.close();
    }
}
