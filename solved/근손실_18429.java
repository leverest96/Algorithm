package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 근손실_18429 {
    public static int N, K, cnt;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];

        cnt = 0;

        permutation(visited, 0, 500);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    public static void permutation(boolean[] visited, int day, int total) {
        if (day == N && total >= 500) {
            cnt++;
            return;
        }

        if (total < 500) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                total -= K;
                total += arr[i];
                permutation(visited, day + 1, total);
                total += K;
                total -= arr[i];
                visited[i] = false;
            }
        }
    }
}
