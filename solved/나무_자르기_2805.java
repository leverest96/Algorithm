package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 나무_자르기_2805 {
    static int N, M, min, max, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        max = min = result = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) max = arr[i];
        }

        binary();

        bw.write(result + "");

        bw.flush();
        bw.close();
    }

    static void binary() {
        if (min > max) return;

        int mid = (min + max) / 2;

        long sum = 0L;

        for (int i = 0; i < N; i++) {
            if (arr[i] > mid) {
                sum += arr[i] - mid;
            }
        }

        if (sum >= M) {
            min = mid + 1;
            if (result <= mid) result = mid;
        } else max = mid - 1;

        binary();
    }
}
