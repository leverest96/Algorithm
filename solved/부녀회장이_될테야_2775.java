package solved;

import java.io.*;

public class 부녀회장이_될테야_2775 {
    static int a, b;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testcase; tc++) {
            a = Integer.parseInt(br.readLine());
            b = Integer.parseInt(br.readLine());

            arr = new int[a + 1][b + 1];

            sum();

            bw.write(arr[a][b] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void sum() {
        for (int i = 0; i <= b; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] += arr[i-1][k];
                }
            }
        }
    }
}
