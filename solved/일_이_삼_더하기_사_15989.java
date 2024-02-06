package Algorithm.solved;

import java.io.*;

public class 일_이_삼_더하기_사_15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int test = Integer.parseInt(br.readLine());

            int answer = 0;

            int three = test / 3;

            for (int j = 0; j <= three; j++) {
                int temp3 = test;

                temp3 -= j * 3;

                int two = temp3 / 2;

                answer += two + 1;
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
