package Algorithm.solved;

import java.io.*;

public class 벌집_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int start = 0;
        int cnt = 0;
        int result = 0;

        while (true) {
            result++;

            if (start < N && N <= 1 + 6 * cnt) {
                break;
            }

            start = 1 + 6 * cnt;
            cnt += result;
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
