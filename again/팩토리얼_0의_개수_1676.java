package Algorithm.again;

import java.io.*;

public class 팩토리얼_0의_개수_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }

        bw.write(cnt + "");

        bw.flush();
        bw.close();
    }
}
