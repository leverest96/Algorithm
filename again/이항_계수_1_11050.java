package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 이항_계수_1_11050 {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][K + 1];

        bw.write(String.valueOf(BC(N, K)));

        bw.flush();
        bw.close();
    }

    static int BC(int N, int K) {
        if(dp[N][K] > 0) {
            return dp[N][K];
        }

        if(N == K || K == 0) {
            return dp[N][K] = 1;
        }

        return dp[N][K] = BC(N - 1, K - 1) + BC(N - 1, K);
    }
}
