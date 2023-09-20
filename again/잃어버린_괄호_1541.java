package Algorithm.again;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 잃어버린_괄호_1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int result = Integer.MAX_VALUE;

        StringTokenizer outer = new StringTokenizer(br.readLine(), "-");

        while (outer.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer inner = new StringTokenizer(outer.nextToken(), "+");

            while (inner.hasMoreTokens()) {
                temp += Integer.parseInt(inner.nextToken());
            }

            if (result == Integer.MAX_VALUE) {
                result = temp;
            } else {
                result -= temp;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
