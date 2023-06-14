package Algorithm.again;

import java.io.*;
import java.util.StringTokenizer;

public class 달팽이는_올라가고_싶다_2869 {
    static long A, B, V, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        sum = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) sum++;

        bw.write(sum + "");

        bw.flush();
        bw.close();
    }
}
