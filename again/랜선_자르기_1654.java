package again;

import java.io.*;
import java.util.StringTokenizer;

public class 랜선_자르기_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long[] arr = new long[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) max = arr[i];
        }

        long start = 0;
        long end = max + 1;

        while (start < end) {
            long mid = (start + end) / 2;

            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt < N) end = mid;
            else start = mid + 1;
        }

        bw.write((start - 1) + "");
        bw.flush();
        bw.close();
    }
}
