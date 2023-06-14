package Algorithm.solved;

import java.io.*;
import java.util.StringTokenizer;

public class 직각삼각형_4153 {
    static int max, sum;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[3];

            max = sum = 0;

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max < arr[i]) max = arr[i];
            }

            if (arr[0] == 0) break;

            for (int i = 0; i < 3; i++) {
                if (arr[i] != max) sum += arr[i] * arr[i];
            }

            if (max * max == sum) bw.write("right\n");
            else bw.write("wrong\n");
        }

        bw.flush();
        bw.close();
    }
}
