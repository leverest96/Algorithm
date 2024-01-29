package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 동전1_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            for (int j = arr[i]; j <= k; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        bw.write(String.valueOf(dp[k]));

        bw.flush();
        bw.close();
    }
}
