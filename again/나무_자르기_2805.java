package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 나무_자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long max = 0;
        long min = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while (min <= max) {
            long mid = (min + max) / 2;
            long sum = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }

            if (sum >= M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
