package solved;

import java.io.*;
import java.util.StringTokenizer;

public class 설탕_배달_2839 {
    static int N, five, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        five = N / 5;

        while (five >= 0) {
            int check = N - five * 5;
            if (check % 3 == 0) {
                result = five + check / 3;
                break;
            }
            five--;
        }

        if (five < 0) bw.write(-1 + "");
        else bw.write(result + "");

        bw.flush();
        bw.close();
    }
}
