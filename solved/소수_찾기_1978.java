package Algorithm.solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수_찾기_1978 {
    static int max;
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        max = 0;

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (max < arr[i]) max = arr[i];
        }

        eratostenes();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (isPrime[arr[i]]) cnt++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }

    static void eratostenes() {
        isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            for (int j = i*i; j <= max; j+=i) {
                isPrime[j] = false;
            }
        }
    }
}
