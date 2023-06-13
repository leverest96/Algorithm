package solved;

import java.io.*;
import java.util.StringTokenizer;

public class 최대공약수와_최소공배수_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(gcd(A, B) + "\n");
        bw.write(lcm(A, B) + "");
        bw.flush();
        bw.close();
    }

    // 최대 공약수
    static int gcd(int a, int b) {
        if (a < b) gcd(b, a);
        return b != 0 ? gcd(b, a%b) : a;
    }

    // 최소 공배수
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
