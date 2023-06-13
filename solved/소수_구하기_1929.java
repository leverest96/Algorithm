package solved;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 소수_구하기_1929 {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        eratostenes(N);

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) System.out.println(i);
        }

        bw.flush();
        bw.close();
    }

    public static void eratostenes(int key) {
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(key); i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= key; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
