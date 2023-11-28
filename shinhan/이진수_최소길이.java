package Algorithm.shinhan;

import java.io.*;
import java.util.StringTokenizer;

public class 이진수_최소길이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int cntN = 0;
        int cntM = 0;

        if (N < 0) {
            N = Math.abs(N + 1);
            cntN++;
        }

        if (M < 0) {
            M = Math.abs(M + 1);
            cntM++;
        }

        cntN += Integer.toBinaryString(N).length();
        cntM += Integer.toBinaryString(M).length();

        bw.write(cntN + " " + cntM);
        bw.flush();
        bw.close();
    }
}
