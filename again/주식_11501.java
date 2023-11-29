package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 주식_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < T; testcase++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long benefit = 0;
            long max = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    benefit += max - arr[i];
                }
            }

            bw.write(String.valueOf(benefit));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
