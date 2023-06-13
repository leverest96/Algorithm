package solved;

import java.io.*;

public class 분해합_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int length = String.valueOf(N).length();

        int result = 0;

        for(int i = (N - (length * 9)); i < N; i++) {
            int number = i;
            int sum = 0;

            while(number != 0) {
                sum += number % 10;
                number /= 10;
            }

            if(sum + i == N) {
                result = i;
                break;
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
