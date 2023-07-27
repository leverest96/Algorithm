package Algorithm.solved;

import java.io.*;

public class Hashing_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        long result = 0;
        long pow = 1;

        for(int i = 0; i < N; i++) {
            result += ((line.charAt(i) - 96) * pow);
            pow = (pow * 31) % 1234567891;
        }

        bw.write(String.valueOf(result % 1234567891));

        bw.flush();
        bw.close();
    }
}
