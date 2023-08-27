package Algorithm.again;

import java.io.*;

public class 피보나치_함수_1003 {
    static int zero, one, next;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        fibonacci(40);

        for (int i = 0; i < N; i++) {
            int test = Integer.parseInt(br.readLine());

            fibonacci(test);

            bw.write(zero + " " + one);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static void fibonacci(int N) {
        zero = 1;
        one = 0;
        next = 1;

        for (int i = 0; i < N; i++) {
            zero = one;
            one = next;
            next = zero + one;
        }
    }
}
