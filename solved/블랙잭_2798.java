package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 블랙잭_2798 {
    static int N, M, cnt, sum, max;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = sum = max = 0;

        powerset(0, cnt, sum);

        bw.write(max + "");

        bw.flush();
        bw.close();
    }

    static void powerset(int idx, int cnt, int sum) {
        if (sum > M) {
            return;
        }

        if (cnt == 3) {
            if (max < sum) max = sum;
            return;
        }

        if (idx == N) return;

        powerset(idx + 1, cnt + 1, sum + arr[idx]);
        powerset(idx + 1, cnt, sum);
    }
}
